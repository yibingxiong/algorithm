package book.chapter4.section4;

import book.chapter4.AvlNode;

public class AvlTree<T extends Comparable<? super T>> {
    public AvlNode<T> head;
    private static final int ALLOWED_IMBANCE = 1;

    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) {
            AvlNode<T> tt = new AvlNode<T>(x);
            if (head == null) {
                head = tt;
            }
            return tt;
        }
        int res = x.compareTo(t.data);
        if (res < 0) {
            t.left = insert(x, t.left);
        } else if (res > 0) {
            t.right = insert(x, t.right);
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return balance(t);
    }

    public void insert(T x) {
        head = insert(x, head);
    }

    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null) {
            return t;
        }
        if (height(t.left) - height(t.right) > ALLOWED_IMBANCE) {
            if (height(t.left.left) >= height(t.left.right)) { // 左左
                t = rotateWithLeftChild(t);
            } else {    // 左右
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBANCE) {
            if (height(t.right.right) >= height(t.right.left)) { // 右右
                t = rotateWithRightChild(t);
            } else {    // 右左
                t = doubleWithRightChild(t);
            }
        }

        return t;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k2.right)) + 1;
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);

        return rotateWithRightChild(k3);
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k2.right)) + 1;
        return k1;
    }

    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            return t;
        }
        int res = x.compareTo(t.data);
        if (res < 0) {
            t.left = remove(x, t.left);
        } else if (res > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.data = findMin(t.right).data;
            t.right = remove(t.data, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;

        }
        return balance(t);
    }

    public void remove(T x) {
        head = remove(x, head);
    }

    public AvlNode<T> findMin(AvlNode<T> root) {
        AvlNode<T> n = root;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

}
