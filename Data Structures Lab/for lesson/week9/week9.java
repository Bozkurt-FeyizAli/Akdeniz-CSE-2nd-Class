import java.util.ArrayList;
public class week9{
    public static void main(String[] args) {
        
    }
}

interface IPriorityQueue<T>{
    public void enqueue(T element, int priority);
    public T dequeue();
    public T peek();
    public boolean isEmpty();
    public long size();
    public void clear();
}


 class PriorityQueueImpl<T> implements IPriorityQueue<T> {
    private static class Element<T> implements Comparable<Element<T>>{
        T value;
        int priority;
        long insertionOrder;

        Element(T value, int priority, long insertionOrder) {
            this.value = value;
            this.priority = priority;
            this.insertionOrder = insertionOrder;
        }

        @Override
        public int compareTo(PriorityQueueImpl.Element<T> el) {
            if(priority>el.priority)
                return 1;
            else if(priority==el.priority)
                if(insertionOrder>el.insertionOrder)
                    return 1;
                if(insertionOrder==el.insertionOrder)
                    return 0;
            return -1;
        }
    }

    private  ArrayList<Element<T>> list;
    private long orderCounter = 0;
    

    public PriorityQueueImpl() {
        this.list=new ArrayList<>();
    }

    @Override
    public void enqueue(T element, int priority) {
        Element<T> el= new Element<>(element, priority, orderCounter);
        if(isEmpty())
            list.add(el);
        else{
            for (int i = 0; i < list.size(); i++) {
                Element<T> eList=list.get(i);
                if(el.compareTo(eList)>0)
                    if(orderCounter==1)
                        list.addFirst(eList);
                    else    
                        list.add(i-1, eList);
                if(i!=0)
                if(el.compareTo(list.get(i+1))>0)
                    list.add(i, el);
            }
            if(!list.contains(el))
                list.add(el);
        }
        orderCounter++;
    }

    @Override
    public T dequeue() {
        T first=list.getFirst().value;
        list.removeFirst();
        return first;
    }

    @Override
    public T peek() {
        return list.getFirst().value;
    }

    @Override
    public boolean isEmpty() {
        return orderCounter==0;
    }

    @Override
    public long size() {
        return orderCounter;
    }

    @Override
    public void clear() {
        list= new ArrayList<>();
    }
}
