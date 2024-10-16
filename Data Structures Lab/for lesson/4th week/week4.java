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
    private final static int defaultCapacity=100;
    private T[] array;
    private int capacity;
    private int index;
    
    public Stack() {
        this(defaultCapacity);
    }
    public Stack(int capacity) {
        this.capacity = capacity;
    }

    



    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
    
}
