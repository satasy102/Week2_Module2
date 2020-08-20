import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;
    private transient Node first;
    transient Node last;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, E e) {
        Node temp = head;
        Node holder;
        Node newNode = new Node(e);

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = newNode;
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        Node newNode = new Node(e);

        if (head.next == null) {
            addFirst(e);
        } else {
            for (int i = 0; i < numNodes; i++) {
                temp = temp.next;
                if (temp.next == null) {
                    temp.next = newNode;
                    temp = temp.next;
                }
            }
        }

        numNodes++;
    }

    public E remove(int index) {
        Node temp = head;
        Node deleteNode;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        deleteNode=temp.next;
        temp=deleteNode.next;

        for (int i=index+1; i<numNodes-2;i++){
            temp=temp.next;
        }
        temp.next=null;

        numNodes--;
        return (E) deleteNode;
    }

    public int size(){
        return numNodes;
    }

    public E clone(){
        return (E) this;
    }

    public boolean contains(E e) {
        return  indexOf(e)>=0;
    }

    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            Node x;
            for (x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            Node x;
            for ( x = first; x != null; x = x.next) {
                if (e.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public E getFirst() {
        final Node f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast() {
        final Node l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    public E get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return (E) temp;
    }

    private class Node {
        public E item;
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }


}
