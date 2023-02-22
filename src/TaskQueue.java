import java.util.LinkedList;

public class TaskQueue<T> {
    private LinkedList<T> list;

    public TaskQueue() {
        list = new LinkedList<>();
    }

    public synchronized void enqueue(T element) {
        list.addLast(element);
    }

    public synchronized T dequeue() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    public synchronized T peek() {
        return list.getFirst();
    }

    public synchronized boolean isEmpty() {
        return list.isEmpty();
    }

    public synchronized int size() {
        return list.size();
    }
}
