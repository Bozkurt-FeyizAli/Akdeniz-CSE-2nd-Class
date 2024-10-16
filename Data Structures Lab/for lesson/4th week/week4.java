public class week4{

}

interface IStack<T> {

    /**
     * Yığının boş olup olmadığını kontrol eder.
     *
     * @return Yığın boşsa true, değilse false döndürür.
     */
    boolean isEmpty();

    /**
     * Yığının dolu olup olmadığını kontrol eder.
     *
     * @return Yığın doluysa true, değilse false döndürür.
     */
    boolean isFull();

    /**
     * Yığının üstündeki elemanı döndürür.
     *
     * @return Yığının üstündeki elemanı döndürür. Yığın boşsa null döndürür.
     */
    T peek();

    /**
     * Yığının üstündeki elemanı çıkarır ve döndürür.
     *
     * @return Yığının üstündeki elemanı döndürür. Yığın boşsa null döndürür.
     */
    T pop();

    /**
     * Yığına yeni bir eleman ekler.
     *
     * @param item Yığına eklenecek eleman.
     */
    void push(T item);

    /**
     * Yığının boyutunu döndürür.
     *
     * @return Yığının boyutunu döndürür.
     */
    int size();
}

class Stack<T> implements IStack<T>{
    private final static int defaultCapacity=50;
    private T[] array;
    private final static int capacity=100;
    private int index;
    
    public Stack() {
        this(defaultCapacity);
    }
    public Stack(int capacity) {
        this.array= (T[])new Object[capacity];
        index=-1;
    }

    @Override
    public boolean isEmpty() {
       return index==-1;
    }

    @Override
    public boolean isFull() {
        return index+1==capacity;
    }

    @Override
    public T peek() {
        if(isEmpty())
            return null;
        return array[index];
    }

    @Override
    public T pop() {
        if(index==-1)
            throw new IllegalAccessError();
        if(isEmpty())
            return null;
        index--;
        return array[index+1];
    }

    @Override
    public void push(T item) {
        if(isFull())
            throw new IllegalAccessError();
        else if(isEmpty())
            throw new IllegalAccessError();
        else{
            array[index+1]=item;
            index++;
        }
    }

    @Override
    public int size() {
        return index+1;
    }
    
}
