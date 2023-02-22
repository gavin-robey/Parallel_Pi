import java.util.HashMap;

public class ResultTable<K, V> {
    private final HashMap<K, V> map;

    public ResultTable() {
        map = new HashMap<>();
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public synchronized boolean containsValue(V value) {
        return map.containsValue(value);
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized boolean isEmpty() {
        return map.isEmpty();
    }

    public synchronized void clear() {
        map.clear();
    }
}

