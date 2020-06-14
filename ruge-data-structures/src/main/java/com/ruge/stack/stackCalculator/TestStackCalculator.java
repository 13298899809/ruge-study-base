package com.ruge.stack.stackCalculator;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 栈实现计算器的测试
 * @date 2020/6/14 21:58
 */
public class TestStackCalculator {
    public static void main(String[] args) {
        //根据前面老师思路，完成表达式的运算
        String expression = "7*2*2-5+1-5+3-4+2"; // 15//如何处理多位数的问题？
        //创建两个栈，数栈，一个符号栈
        StackCalculator numStack = new StackCalculator(10);
        StackCalculator operStack = new StackCalculator(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1;
        int num2;
        int oper;
        int res;
        char ch; //将每次扫描得到char保存到ch
        String keepNum = ""; //用于拼接 多位数
        //开始while循环的扫描expression
        do {
            //依次得到expression 的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (StackCalculatorTool.isOper(ch)) {//如果是运算符
                //判断当前的符号栈是否为空
                // 1 + 3
                if (!StackCalculatorTool.isEmpty(operStack)) {
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (StackCalculatorTool.priority(ch) <= StackCalculatorTool.priority(StackCalculatorTool.peek(operStack))) {
                        num1 = StackCalculatorTool.pop(numStack);
                        num2 = StackCalculatorTool.pop(numStack);
                        oper = StackCalculatorTool.pop(operStack);
                        res = StackCalculatorTool.cal(num1, num2, oper);
                        //把运算的结果如数栈
                        StackCalculatorTool.push(numStack, res);
                        //然后将当前的操作符入符号栈
                    }  //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.

                }  //如果为空直接入符号栈..

                StackCalculatorTool.push(operStack, ch);
            } else { //如果是数，则直接入数栈

                //numStack.push(ch - 48); //? "1+3" '1' => 1
                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接

                //处理多位数
                keepNum += ch;

                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    StackCalculatorTool.push(numStack, Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (StackCalculatorTool.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        StackCalculatorTool.push(numStack, Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index + 1, 并判断是否扫描到expression最后.
            index++;
        } while (index < expression.length());

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (!StackCalculatorTool.isEmpty(operStack)) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            num1 = StackCalculatorTool.pop(numStack);
            num2 = StackCalculatorTool.pop(numStack);
            oper = StackCalculatorTool.pop(operStack);
            res = StackCalculatorTool.cal(num1, num2, oper);
            StackCalculatorTool.push(numStack, res);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = StackCalculatorTool.pop(numStack);
        System.out.printf("表达式 %s = %d", expression, res2);
    }
}
