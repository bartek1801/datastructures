package datastructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bartek on 06.08.2017.
 */
public class StandardTreeNode<E> implements TreeNode<E> {

    private E element;
    private List<TreeNode<E>> children = new LinkedList<>();

    public StandardTreeNode(E element) {
        this.element = element;
    }

    @Override
    public void add(TreeNode<E> child) {
        children.add(child);
    }

    @Override
    public List<TreeNode<E>> children() {
        return children;
    }

    @Override
    public E element() {
        return element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
