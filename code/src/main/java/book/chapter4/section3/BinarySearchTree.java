package book.chapter4.section3;

import book.chapter4.Node;

public class BinarySearchTree<T extends Comparable<? super T>> {
    public Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void clear() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T v) {
        return contains(v, root);
    }

    public T findMin() {
        Node<T> n = findMin(root);
        if (n == null) {
            return null;
        } else {
            return n.data;
        }
    }

    public T findMax() {
        Node<T> n = findMax(root);
        if (n == null) {
            return null;
        } else {
            return n.data;
        }
    }

    public void insert(T v) {
        if (root == null) {
            root = new Node<T>(v);
        }
        insert(v, root);
    }


    private boolean contains(T v, Node<T> node) {
        if (node == null) {
            return false;
        }
        int res = v.compareTo(node.data);
        if (res < 0) {
            return contains(v, node.left);
        } else if (res > 0) {
            return contains(v, node.right);
        }
        return true;
    }

    private Node<T> findMin(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node<T> findMax(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node<T> insert(T v, Node<T> node) {
        if (node == null) {
            return new Node<T>(v);
        }

        int res = v.compareTo(node.data);
        if (res < 0) {
            node.left = insert(v, node.left);
        } else if (res > 0) {
            node.right = insert(v, node.right);
        }

        return node;
    }

    public Node<T> remove(T v) {
        return remove(v, root);
    }

    private Node<T> remove(T v, Node<T> node) {
        if (node == null) {
            return null;
        }

        int res = v.compareTo(node.data);
        if (res < 0) {
            node.left = remove(v, node.left);
        } else if (res > 0) {
            node.right= remove(v, node.right);
        } else {    // 找到
            if (node.left == null && node.right == null) { // 页节点
                node = null;
                return node;
            } else if (node.left != null && node.right != null) {
                node.data = findMin(node).data;
                node.right = remove(node.data, node.right);
            } else if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }
}
