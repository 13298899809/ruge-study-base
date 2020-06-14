package com.ruge.stack.stackCalculator;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 栈计算器工具类
 * @date 2020/6/14 21:53
 */
public class StackCalculatorTool {

    /**
     * 增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
     *
     * @param stack
     * @return
     */
    public static int peek(StackCalculator stack) {
        return stack.getStack()[stack.getTop()];
    }

    //栈满
    public static boolean isFull(StackCalculator stack) {
        return stack.getTop() == stack.getMaxSize() - 1;
    }

    //栈空
    public static boolean isEmpty(StackCalculator stack) {
        return stack.getTop() == -1;
    }

    //入栈-push
    public static void push(StackCalculator stack, int value) {
        //先判断栈是否满
        if (isFull(stack)) {
            System.out.println("栈满");
            return;
        }
        stack.setTop(stack.getTop() + 1);
        stack.getStack()[stack.getTop()] = value;
    }

    //出栈-pop, 将栈顶的数据返回
    public static int pop(StackCalculator stack) {
        //先判断栈是否空
        if (isEmpty(stack)) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack.getStack()[stack.getTop()];
        stack.setTop(stack.getTop() - 1);
        return value;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public static void list(StackCalculator stackCalculator) {
        if (isEmpty(stackCalculator)) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = stackCalculator.getTop(); i >= 0; i--) {
            System.out.printf("stackCalculator[%d]=%d\n", i, stackCalculator.getStack()[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }

    //判断是不是一个运算符
    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public static int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
