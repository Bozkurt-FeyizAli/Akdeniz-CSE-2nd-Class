import java.util.Comparator;
public class week9{

}

interface IPriorityQueue{

}

 class PriorityQueueImpl<T> implements IPriorityQueue<T> {
    private static class Element<T> {
        T value;
        int priority;
        long insertionOrder;

        Element(T value, int priority, long insertionOrder) {
            this.value = value;
            this.priority = priority;
            this.insertionOrder = insertionOrder;
        }
    }

    private final PriorityQueueImpl<Element<T>> queue;
    private long orderCounter = 0;

    public PriorityQueueImpl() {
        this.queue = new PriorityQueue<>(Comparator
                .comparingInt((Element<T> e) -> -e.priority)
                .thenComparingLong(e -> e.insertionOrder));
    }

    @Override
    public void enqueue(T element, int priority) {
        queue.add(new Element<>(element, priority, orderCounter++));
    }

    @Override
    public T dequeue() {
        Element<T> highestPriorityElement = queue.poll();
        return highestPriorityElement != null ? highestPriorityElement.value : null;
    }

    @Override
    public T peek() {
        Element<T> highestPriorityElement = queue.peek();
        return highestPriorityElement != null ? highestPriorityElement.value : null;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
