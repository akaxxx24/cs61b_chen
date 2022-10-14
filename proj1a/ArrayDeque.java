public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst ;
    private int nextLast ;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 4;
        nextFirst = 5;
    }

    public boolean isFull(){
        return size == items.length;
    }

    public void grow(){
        T[] tmp = (T[]) new Object[size * 2];
        int ptr1 = (nextFirst + 1) % size;
        int i = 0;
        while (ptr1 != nextLast)
        {
            tmp[i] = items[ptr1];
            i ++;
            ptr1 = (ptr1 + 1) % size;
        }
        nextFirst = tmp.length - 1;
        nextLast = size;
        items = tmp;
    }

    public void addFirst(T item){
        if (isFull())
        {
            grow();
        }
        items[nextFirst] = item;
        if(nextFirst - 1 < 0)
        {
            nextFirst = items.length - 1;
        }
        else
        {
            nextFirst = nextFirst - 1;
        }
        size ++;
    }

    public void addLast(T item){
        if (isFull())
        {
            grow();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size ++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int ptr = (nextFirst + 1) % items.length;
        while (ptr != nextLast)
        {
            System.out.print(items[ptr] + " ");
            ptr = (ptr + 1) % items.length;
        }
    }

    public  void shrink(){
        T[] tmp = (T[]) new Object[items.length / 2];
        int ptr1 = (nextFirst + 1) % items.length;
        int i = 0;
        while (ptr1 != nextLast)
        {
            tmp[i] = items[ptr1];
            i ++;
            ptr1 = (ptr1 + 1) % size;
        }
        nextFirst = tmp.length - 1;
        nextLast = size;
        items = tmp;
    }

    public T removeFirst(){
        if (items.length >= 16 && items.length / size >= 4)
        {
            shrink();
        }
        if (size == 0)
        {
            return null;
        }
        int ptr = (nextFirst + 1) % items.length;
        T ret = items[ptr];
        nextFirst = (ptr + 1) % items.length;
        size --;
        return ret;
    }

    public T removeLast(){
        if (items.length >= 16 && items.length / size >= 4)
        {
            shrink();
        }
        if (size == 0)
        {
            return  null;
        }
        int ptr;
        if (nextLast - 1 < 0)
        {
            ptr = items.length - 1;
        }
        else
        {
            ptr = nextLast - 1;
        }
        T ret = items[ptr];
        size --;
        if (nextLast == 0)
        {
            nextLast = items.length - 1;
        }
        else
        {
            nextLast = nextLast - 1;
        }
        return ret;
    }

    public T get(int index){
        if (index >= size)
        {
            return null;
        }
        int ptr = (nextFirst + 1) % items.length;
        for (int i = 0; i < index; i++)
        {
            ptr = (ptr + 1) % items.length;
        }
        return items[ptr];
    }


}
