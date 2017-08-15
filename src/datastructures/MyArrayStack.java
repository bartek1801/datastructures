package datastructures;

/**
 * Created by bartek on 26.07.2017.
 */
public class MyArrayStack<T> implements MyStack<T> {

    private T[] stack;
    private int count;

    public MyArrayStack(){
        stack = (T[]) new Object[100];
    }

    @Override
    public void push(T t) {
        if (count == stack.length){
            T[] newStack = (T[]) new Object[stack.length + 100];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[count] = t;
        count++;
    }

    @Override
    public T pop() {
        if (!empty())// użyj empty() lub count == 0
            return null;
        T tmp = stack[count - 1];
        stack[count - 1] = null;
        count--;
        return tmp;
    }

    @Override
    public boolean empty() {
        if (count > 0)
            return true;
        return false;
    }
}
