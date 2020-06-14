package com.ruge.stack.polandNotation;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 波兰表达式
 * @date 2020/6/14 22:25
 */
@Data
public class PolandNotation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }
}
