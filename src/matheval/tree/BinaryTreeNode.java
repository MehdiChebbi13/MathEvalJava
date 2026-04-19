package matheval.tree;

/**
 * Noeud générique d'un arbre binaire.
 * Cette classe est fournie complète — ne pas modifier.
 *
 * @param <T> Le type de la valeur stockée dans le noeud.
 */
public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        return "Node(" + value + ")";
    }
}
