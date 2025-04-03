public class PriorityQueue {
    interface pQueue<T extends Comparable<T>> {
        void heapify();
        void add(T t);
        boolean contains(T t);
        T remove();
    }


    class priorityQueueArray<T extends Comparable<T>> implements pQueue<T> {
        private int size = 0;
        private T[] arr = (T[]) new Comparable[10];
        @Override
        public void heapify() {
            int i = 0;
            while (2*i+1< size) {
                int left = 2*i+1;
                int right = 2*i+2;
                int smallest = left;
                if (right < size && arr[right].compareTo(arr[left]) < 0) {
                    smallest = right;
                }
                if (arr[i].compareTo(arr[smallest]) > 0) {
                    swap(i, smallest);
                    i = smallest;
                } else {
                    break;
                }
            }
        }

        @Override
        public void add(T t) {
            if (size >= arr.length) {
                System.out.println("the heap is full");
            }
            arr[size] = t;
            int current = size;
            size++;
            while (current > 0 && arr[current].compareTo(arr[(current - 1) / 2]) < 0) {
                swap(current, (current - 1) / 2);
                current = (current - 1) / 2;
            }
        }
        @Override
        public boolean contains(T t) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(t)) return true;
            }
            return false;
        }
        @Override
        public T remove() {
            if (size == 0) return null;
            T root = arr[0];
            arr[0] = arr[size - 1];
            size--;
            heapify();
            return root;
        }
        private void swap(int i, int j) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        System.out.println("We are making a priority queue");
        PriorityQueue pq = new PriorityQueue();
        priorityQueueArray<Integer> minHeap = pq.new priorityQueueArray<>();
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(1);
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove()); 
    }
}

