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
     * Does not remove the first element of the linked list
     * Instead returns the value of the first element of the linked list
     * @return T 
     */
    public synchronized T peek() {
        return list.getFirst();
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T task : list) {
            sb.append(task.toString());
            sb.append(", ");
        }
        // Remove the trailing comma and space
        if (!list.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
