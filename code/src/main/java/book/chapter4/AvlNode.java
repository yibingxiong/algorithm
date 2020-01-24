package book.chapter4;

public class AvlNode<T> {
    public T data;
    public AvlNode<T> left;
    public AvlNode<T> right;
    public int height;

    public AvlNode(T data) {
        this(data, null, null);
    }

    public AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    @Override
    public String toString() {
        return "AvlNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                ", height=" + height +
                '}';
    }
}
