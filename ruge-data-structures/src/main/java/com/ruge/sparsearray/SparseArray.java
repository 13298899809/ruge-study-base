package com.ruge.sparsearray;

import org.junit.Test;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 稀疏数组
 * @date 2020/6/13 12:14
 */
public class SparseArray {
    /*原始棋盘*/
    public static int[][] chessPlay;
    /*稀疏数组*/
    public static int[][] sparseArr;
    /*复盘*/
    public static int[][] chessReplay;

    /*选手A 1 表示*/
    public static int playerA = 1;
    /*选手B 2 表示*/
    public static int playerB = 2;
    /*游戏是否结束*/
    public static boolean gameOver = false;
    /*一共下了多少个棋子*/
    public static int chess;


    /*原始棋盘初始化*/
    public void init() {
        chessPlay = new int[11][11];
        System.out.println("初始化棋盘");
        design();
    }


    /*下棋ing*/
    public void play(int x, int y, int player) {
        System.out.println("选手" + player + "--x-->" + x + "--y-->" + y);
        chessPlay[x][y] = player;
        design();
    }

    /*棋盘现状*/
    public void design() {
        for (int[] row : chessPlay) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /*稀疏数组初始化*/
    public void sparseArrInit() {
        /*temp 1 得到一共有多少个棋子 */
        chess = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessPlay[i][j] != 0) {
                    chess++;
                }
            }
        }
        System.out.println("稀疏数组~有效棋子数量为:" + chess);
        /*temp 2 创建对应的稀疏数组*/
        sparseArr = new int[chess + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = chess;
        /*
         * temp 3 给稀疏数组赋值
         *num row col val
         * 0   11  11  3
         * 1   1   1   1
         * 2   2   2   2
         * 3   3   2   1
         */
        //count 用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessPlay[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessPlay[i][j];
                }
            }
        }
        sparseArrDesign();
    }


    /*稀疏数组遍历*/
    public void sparseArrDesign() {
        System.out.println("稀疏数组~~~");
        System.out.println();
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        System.out.println();
    }

    /*回盘文件初始化*/
    public void replayInit() {
        /*temp 1 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组*/
        chessReplay = new int[sparseArr[0][0]][sparseArr[0][1]];
        System.out.println("初始化棋盘");
        replayDesign();

        /*temp 2 回盘文件赋值*/
        for (int i = 1; i < sparseArr.length; i++) {
            replay(sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

    }

    /*复盘ing*/
    public void replay(int x, int y, int player) {
        System.out.println("复盘文件~~~选手" + player + "--x-->" + x + "--y-->" + y);
        chessReplay[x][y] = player;
        replayDesign();
    }

    /*复盘遍历*/
    public void replayDesign() {
        System.out.println("复盘遍历~~~");
        for (int[] row : chessReplay) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        init();
        play(1, 1, playerA);
        play(1, 2, playerB);
        play(1, 3, playerA);
        gameOver = true;
        sparseArrInit();
        replayInit();
    }
}
