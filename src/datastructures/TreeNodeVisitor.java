package datastructures;

/**
 * Created by bartek on 06.08.2017.
 */
public interface TreeNodeVisitor<E> {

    void visit(E element, int level);

}
