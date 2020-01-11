package book.chapter4.section2;

class Node<T> {
    private T data;
    public Node left;
    public Node right;


    public Node(T data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class MyTree<T> {

    public void preTraverse(Node root) {
        System.out.print(root.getData() + " ");
        if (root.getLeft() != null) {
            preTraverse(root.getLeft());
        }
        if (root.getRight() != null) {
            preTraverse(root.getRight());
        }
    }

    public void postTraverse(Node root) {
        if (root.getLeft() != null) {
            postTraverse(root.getLeft());
        }
        if (root.getRight() != null) {
            postTraverse(root.getRight());
        }
        System.out.print(root.getData() + " ");
    }

    public void midTraverse(Node root) {
        if (root.getLeft() != null) {
            midTraverse(root.getLeft());
        }
        System.out.print(root.getData() + " ");
        if (root.getRight() != null) {
            midTraverse(root.getRight());
        }
    }
}
