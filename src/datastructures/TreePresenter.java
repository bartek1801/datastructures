package datastructures;

/**
 * Created by bartek on 06.08.2017.
 */
public class TreePresenter<E> {

    private final TreeNode<E> root;

    public TreePresenter(TreeNode<E> root){
        this.root = root;
    }

    public void show(){
        show(root,0);
    }


    private void show(TreeNode<E> node, int level){
        System.out.println(spaces(level) + node.element());
        for (TreeNode<E> child : node.children())
            show(child, level + 1);
    }

    private String spaces(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < level; i++)
            sb.append("\t");
        return sb.toString();
    }

}
