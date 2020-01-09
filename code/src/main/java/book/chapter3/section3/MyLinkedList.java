package book.chapter3.section3;

import com.sun.tools.corba.se.idl.constExpr.Not;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class Node<T> {
        public T value;
        public Node<T> prev;
        public Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
        }

    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        // 这里加上两个额外的节点来避免复杂的边界判断问题
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, head, null);
        head.next = tail;
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T v) {
        return add(size(), v);
    }

    public boolean add(int idx, T v) {
        addBefore(getNode(idx), v);
        return true;
    }

    public T get(int idx) {
        return getNode(idx).value;
    }

    public T set(int idx, T v) {
        Node<T> node = getNode(idx);
        T oldValue = node.value;
        node.value = v;
        return oldValue;
    }

    public T remove(int idx) {
        Node<T> oldNode = getNode(idx);
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
        theSize--;
        return oldNode.value;
    }

    public T remove() {
        return remove(size() - 1);
    }

    private void addBefore(Node<T> p, T v) {
        Node<T> newNode = new Node<T>(v, p.prev, p);
        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }
        p.prev = newNode;
        theSize++;
    }


    private Node<T> getNode(int idx) {
        Node<T> p;
        if (idx >= theSize / 2) {
            p = tail;
            // 注意边界值的处理
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        } else {
            p = head.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        }
        return p;
    }




    private class MyLinkedListIterator implements Iterator<T> {

        private Node<T> cur = head.next;
        public boolean hasNext() {
            return cur!= tail;
        }

        public T next() {
            T t = cur.value;
            cur = cur.next;
            return t;
        }

        public void remove() {

        }
    }

    private int theSize;
    private Node<T> head;
    private Node<T> tail;
}
