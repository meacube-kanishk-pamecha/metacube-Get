public class PriorityQueue {
    interface pQueue<T extends Comparable<T>> {
        T peek();
        void add(T t);
        T remove();
    }


    class priorityQueueArray<T extends Comparable<T>> implements pQueue<T> {
        private int size = 0;
        private T[] arr = (T[]) new Comparable[10];
        /**
         * peek method to get the top element 
         */
        
         @Override
         public T peek() {
             return arr[0];
         }

        /**
         * add it add the element to the heap
         * @param T t the element to be added in the heap
         */
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
     
       
        /**
         * remove it removes the top element either minimum or maximum
         */
        @Override
        public T remove() {
            if (size == 0) return null;
            T root = arr[0];
            arr[0] = arr[size - 1];
            size--;
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
            return root;
        }
        /**
         * swap the values from index i to j and vice versa
         * @param  int i position of 1 element
         * @param int j position of 2 element
         */
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

