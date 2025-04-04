package Q3;

// Queue interface
interface Queue<T> {
    void offer(T element);

    T remove();

    T peek();

    boolean isEmpty();

    boolean isFull();
}

// implementing the queue interface
class QueueArray<T> implements Queue<T> {
    private T[] arr;
    private int start, point, size, capacity;

    // Constructor
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.start = -1;
        this.point = -1;
        this.size = 0;
    }

    /**
     * addding the element in the queue
     * 
     * @param T element adding the element in queue of type t
     */
    @Override
    public void offer(final T element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        point = (point + 1) % capacity;
        arr[point] = element;
        if (start == -1)
            start = 0;
        size++;
    }

    /**
     * peek return the peek of the queue
     */
    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return arr[start];
    }

    /**
     * remove removes the front element or the start element of the queue
     */
    @Override
    public T remove() {
        if (isEmpty())
            return null;
        T removed = arr[start];
        if (start == point) {
            start = -1;
            point = -1;
        } else {
            start = (start + 1) % capacity;
        }
        size--;
        return removed;
    }

    /**
     * isEmpty checking the queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * isFull checks the size of the
     */
    @Override
    public boolean isFull() {
        return size == capacity;
    }
}

public class QueueInteface {
}
