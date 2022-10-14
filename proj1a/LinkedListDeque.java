public class LinkedListDeque<T> {
    public class Node{
        private T item;
        private Node next;
        private Node prev;

        public Node(T i, Node pprev, Node nnext){
            item = i;
            next = nnext;
            prev = pprev;
        }
        public Node(Node pprev, Node nnext){
            next = nnext;
            prev = pprev;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque(){
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size ++;
    }

    public void addLast(T item){
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size ++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node tmp= sentinel.next;
        while (tmp != sentinel)
        {
            System.out.print(tmp.item);
            tmp = tmp.next;
        }
    }

    public T removeFirst(){
        if (size == 0)
        {
            return null;
        }
        T tmp = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return tmp;
    }

    public T removeLast(){
        if (size == 0)
        {
            return null;
        }
        T tmp = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return tmp;
    }

    /**must use iteration */
    public T get(int index){
        if (this.isEmpty() || index > size - 1 || index < 0)
        {
            return null;
        }
        Node tmp = sentinel.next;
        for (int i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        return tmp.item;
    }

    private T getRecursiveHelp(Node start, int index)
    {
        if (index == 0)
        {
            return start.item;
        }
        else
        {
            return getRecursiveHelp(start.next, index - 1);
        }

    }
    /** must use recursive */
    public T getRecursive(int index){
        if (this.isEmpty() || index > size - 1 || index < 0)
        {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }
}
