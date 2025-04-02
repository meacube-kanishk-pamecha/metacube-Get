import java.util.Scanner;


interface Queue<T> {
    void offer(T element);
    T remove();
    T peek();
    boolean isEmpty();
    boolean isFull();
}

class QueueArray<T> implements Queue<T> {
    private T[] arr;
    private int start, point, size, capacity;


    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.start = -1;
        this.point = -1;
        this.size = 0;
    }


    @Override
    public void offer(final T element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        point = (point + 1) % capacity;
        arr[point] = element;
        if (start == -1) start = 0;
        size++;
    }


    @Override
    public T peek() {
        if (isEmpty()) return null;
        return arr[start];
    }


    @Override
    public T remove() {
        if (isEmpty()) return null;
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


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean isFull() {
        return size == capacity;
    }
}


public class QueueInteface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new QueueArray<>(5);


        while (true) {
            System.out.println("\n1. insert \n2. remove\n3. peek \n4. Quit");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    int num = sc.nextInt();
                    queue.offer(num);
                    break;
                case 2:
                    System.out.println("Removed " + queue.remove());
                    break;
                case 3:
                    System.out.println("Peek " + queue.peek());
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Chi=oice is from 1 to 4");
                }
            }
     
    }
}


