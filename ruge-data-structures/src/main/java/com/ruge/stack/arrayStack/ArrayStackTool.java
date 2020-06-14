package com.ruge.stack.arrayStack;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 栈的工具类
 * @date 2020/6/14 21:10
 */
public class ArrayStackTool {


    /**
     * @param arrayStack {@link ArrayStack}
     * @return 是否栈满
     */
    public static boolean isFull(ArrayStack arrayStack) {
        return arrayStack.getTop() == arrayStack.getMaxSize() - 1;
    }


    /**
     * @param arrayStack {@link ArrayStack}
     * @return 是否 栈空
     */
    public static boolean isEmpty(ArrayStack arrayStack) {
        return arrayStack.getTop() == -1;
    }

    /**
     * 入栈-push
     *
     * @param arrayStack {@link ArrayStack}
     * @param value      入栈的值
     */
    public static void push(ArrayStack arrayStack, int value) {
        //先判断栈是否满
        if (isFull(arrayStack)) {
            System.out.println("栈满");
            return;
        }
        arrayStack.setTop(arrayStack.getTop() + 1);
        arrayStack.getStack()[arrayStack.getTop()] = value;
    }

    //

    /**
     * 出栈-pop, 将栈顶的数据返回
     *
     * @param arrayStack {@link ArrayStack}
     * @return 出栈的值
     */
    public static int pop(ArrayStack arrayStack) {
        //先判断栈是否空
        if (isEmpty(arrayStack)) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = arrayStack.getStack()[arrayStack.getTop()];
        arrayStack.setTop(arrayStack.getTop() - 1);
        return value;
    }


    /**
     * 显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
     *
     * @param arrayStack {@link ArrayStack}
     */
    public static void list(ArrayStack arrayStack) {
        if (isEmpty(arrayStack)) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = arrayStack.getTop(); i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, arrayStack.getStack()[i]);
        }
    }
}
