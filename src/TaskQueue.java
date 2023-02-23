import java.util.LinkedList;

public class TaskQueue<T> {
    private LinkedList<T> list;

    public TaskQueue() {
        list = new LinkedList<>();
    }

    /**
     * Adds an element to the end of the linked list to act as a FIFO queue
     * @param element generic element to be added to the queue
     */
    public synchronized void enqueue(T element) {
        list.addLast(element);
    }

    /**
     * if empty return null and do nothing otherwise, remove the first element of the linked list
     * @return null or T
     */
    public synchronized T dequeue() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    /**
     * Checks whether the linked list is empty
     * @return Boolean
     */
    public synchronized boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Finds and returns the size of the linked list
     * @return int
     */
    public synchronized int size() {
        return list.size();
    }
}
