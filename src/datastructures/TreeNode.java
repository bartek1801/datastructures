package datastructures;

import java.util.List;

/**
 * Created by bartek on 06.08.2017.
 */
public interface TreeNode<E> {

    // dodaje element jako dziecko węzła
    void add(TreeNode<E> child);

    // zwraca listę dzieci tego węzła
    List<TreeNode<E>> children();

    // zwraca element przechowywany w tym węźle
    E element();


}
