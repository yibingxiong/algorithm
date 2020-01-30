package book.chapter6.section6;

public class LeftistHeap<T extends Comparable<? super T>> {
    private Node<T> root;

    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        int npl;    // 0路径长度

        public Node(T element) {
            this(element, null, null);
        }

        public Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            npl = 0;
        }
    }

    public LeftistHeap() {
        root = null;
    }

    public void merge(LeftistHeap<T> leftistHeap) {
        if (leftistHeap == this) {
            return;
        }
        root = merge(root, leftistHeap.root);
        leftistHeap.root = null;
    }

    public void insert(T x) {
        root = merge(new Node<T>(x), root);
    }

    public T findMin() {
        return root.element;
    }

    public T deleteMin() {
        T min = root.element;
        root = merge(root.left, root.right);
        return min;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    private Node<T> merge(Node<T> h1, Node<T> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element) < 0) {
            return merge1(h1, h2);
        }
        return merge1(h2, h1);
    }

    private Node<T> merge1(Node<T> h1, Node<T> h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl) {
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<T> t) {
        Node<T> oldLeft = t.left;
        t.left = t.right;
        t.right = oldLeft;
    }
}
