package datastructures;

/**
 * Created by bartek on 06.08.2017.
 */
public class TreeWalker<E> {

    private final TreeNode<E> root;

    public TreeWalker(TreeNode<E> root){
        this.root = root;
    }

    public void walk(TreeNodeVisitor<E> visitor){
        walkRec(root, visitor, 0);
    }

    private void walkRec(TreeNode<E> node, TreeNodeVisitor<E> visitor, int level){
        visitor.visit(node.element(), level);
        for (TreeNode<E>  child : node.children()){
            walkRec(child, visitor, level + 1);
        }
    }

}
