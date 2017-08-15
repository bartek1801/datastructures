package datastructures;

/**
 * Created by bartek on 26.07.2017.
 */
public class MyArrayListStack<T> implements MyStack<T> {


    private MyArrayList<T> stack = new MyArrayList<>();

    @Override
    public void push(T t) {
        stack.add(t);
    }

    @Override
    public T pop() {
        if (empty())// stack.length() == 0 lub empty()
            return null;
        T tmpLast = stack.last();
        stack.remove(stack.last());
        return tmpLast;
    }

    @Override
    public boolean empty() {
        if (stack.length() == 0)
            return true;
        return false;
    }
}
