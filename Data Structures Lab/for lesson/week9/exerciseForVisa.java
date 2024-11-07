public class exerciseForVisa {
    
}

interface PriorityQueueInterface<E> {
    /**
     * Inserts the specified element into the priority queue according to its priority.
     * Elements with higher priority should be placed before elements with lower priority.
     *
     * @param element the element to add to the priority queue.
     */
    void enqueue(E element, int priority);

    /**
     * Removes and returns the element with the highest priority from the priority queue.
     * If multiple elements have the same priority, removes the one that was added first.
     *
     * @return the element with the highest priority.
     * @throws NoSuchElementException if the priority queue is empty.
     */
    E dequeue();

    /**
     * Retrieves, but does not remove, the element with the highest priority from the priority queue.
     * If multiple elements have the same priority, retrieves the one that was added first.
     *
     * @return the element with the highest priority.
     * @throws NoSuchElementException if the priority queue is empty.
     */
    E peek();

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return the number of elements in the priority queue.
     */
    int size();

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue contains no elements, false otherwise.
     */
    boolean isEmpty();
}



 class PriorityQueueNode<E> implements Comparable<PriorityQueueNode<E>>{
    E data;
    int priority;
    PriorityQueueNode<E> next;

    /**
     * Constructor to create a node with specified data and priority.
     *
     * @param data the data to be stored in the node.
     * @param priority the priority of this element.
     */
    public PriorityQueueNode(E data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

    @Override
    public int compareTo(PriorityQueueNode<E> node) {
        return Integer.compare(priority, node.priority);
    }
}

 class PriorityQueue<E> implements PriorityQueueInterface<E> {
    private PriorityQueueNode<E> head;
    private int size;

    public PriorityQueue() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E element, int priority) {
        PriorityQueueNode<E> node= new PriorityQueueNode<>(element, priority);
        if(isEmpty()){
            head=node;
        }
        PriorityQueueNode<E> t=head;
        if(node.compareTo(head)>0){
            node.next=head;
            head=node;
        }
        else{
            t=t.next;
        while(t.next!=null){
            if(node.compareTo(t.next)>0){
                node.next=t.next;
                t.next=node;
                break;
            }
            t=t.next;
        }
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            return null;
        E data=head.data;
        if(size!=1)
        head=head.next;
        size--;
        return data;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    
}

 interface LinkedListInterface<E> {
    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added.
     */
    void add(E element);

    /**
     * Inserts an element at the specified position in the list.
     *
     * @param index the position where the element should be inserted.
     * @param element the element to be added.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    void add(int index, E element);

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index the position of the element to be removed.
     * @return the removed element.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    E remove(int index);

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index the position of the element to return.
     * @return the element at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    E get(int index);

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    int size();

    /**
     * Checks if the list is empty.
     *
     * @return true if the list contains no elements, false otherwise.
     */
    boolean isEmpty();

    /**
     * Clears all elements from the list.
     */
    void clear();
}


class LinkedList<E> implements LinkedListInterface<E>{
    linkedListNode<E> tail;
    int size;

    public LinkedList(){
        size=0;
        tail=null;
    }

    @Override
    public void add(E element) {
        linkedListNode<E> node= new linkedListNode<>(element);
        if (isEmpty()) {
            tail = node;
            tail.next = tail;  
            tail.prev = tail;
        } else {
            node.next = tail.next;
            node.prev = tail;
            tail.next.prev = node;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if(index<=size){
        linkedListNode<E> node = new linkedListNode<>(element);
        if (index == 0) {
            // Insert at the beginning
            if (isEmpty()) {
                tail = node;
                tail.next = tail;
                tail.prev = tail;
            } else {
                node.next = tail.next;
                node.prev = tail;
                tail.next.prev = node;
                tail.next = node;
            }
        } else {
            // Insert in the middle or at the end
            linkedListNode<E> current = tail.next;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            current.next.prev = node;
            current.next = node;
            if (index == size) {
                tail = node;
            }
        }
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        linkedListNode<E> toRemove;
        if (index == 0) {
            toRemove = tail.next;
            if (size == 1) {
                tail = null;
            } else {
                tail.next = toRemove.next;
                toRemove.next.prev = tail;
            }
        } else {
            linkedListNode<E> current = tail.next;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            toRemove = current.next;
            current.next = toRemove.next;
            toRemove.next.prev = current;
            if (index == size - 1) {
                tail = current;
            }
        }
        size--;
        return toRemove.data;
    }

    @Override
    public E get(int index) {
        if(index>size)
            return null;
        linkedListNode<E> t= tail;
        for (int i = 1; i < size; i++) {
            if(i==index)
                return tail.data;
            t=t.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        tail=null;
    }
    
}

 class linkedListNode<E> {
    E data;
    linkedListNode<E> next;
    linkedListNode<E> prev;

    /**
     * Constructor to create a node with specified data.
     *
     * @param data the data to be stored in the node.
     */
    public linkedListNode(E data) {
        this.data = data;
        this.next = null;
    }
}



