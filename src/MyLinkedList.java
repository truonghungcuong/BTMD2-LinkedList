public class MyLinkedList<E> {
    private class Node {
        E data;
        Node next;

        Node(E element) {
            this.data = element;
        }

        Node() {
        }
    }

    private int size = 0;
    private Node head = new Node();

    public int size() {
        return size;
    }

    public void add(E element) {
        Node newNode = new Node(element);
        Node tail = getNode(size - 1);
        tail.next = newNode;
        size++;
    }

    public void addLast(E element) {
        add(element);
    }

    public void addFirst(E element) {
        Node before = head.next;
        Node newNode = new Node(element);
        head.next = newNode;
        newNode.next = before;
    }

    private Node getNode(int index) {
        if (index >= size)
            return null;
        if (index < 0)
            return head;
        Node node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        return getNode(index).data;
    }
    public E getFirst(){
        return head.next.data;
    }
    public E getLast(){
        return get(size-1);
    }

    public void add(int index, E element) {
        Node before = getNode(index - 1);
        Node after = before.next;
        Node newNode = new Node(element);
        before.next = newNode;
        newNode.next = after;
        size++;
    }

    public int indexOf(E element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (node.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        int index = -1;
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (node.data.equals(element)) {
                index = i;
            }
        }
        return index;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            return;

        Node before = getNode(index - 1);
        Node after = getNode(index + 1);
        before.next = after;
        size--;
    }

    public void remove() {
        if (size == 0)
            return;
        Node newTail = getNode(size - 1 - 1);
        newTail.next = null;
    }

    public void remove(E element) {
        int index = indexOf(element);
        remove(index);
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index " + index + " of size " + size);
        } else {
            Node before = getNode(index - 1);
            Node after = getNode(index + 1);
            Node newNode = new Node(element);
            before.next = newNode;
            newNode.next = after;
        }
    }
    public boolean contains(E element){
        boolean isFound = false;
        Node node = head.next;
        while (node != null){
            if (node.data.equals(element)){
                isFound = true;
                break;
            }
            node = node.next;
        }
        return isFound;
    }
    public void clear(){
        size = 0;
        head.next = null;
    }
}