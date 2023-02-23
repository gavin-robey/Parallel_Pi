import java.util.HashMap;

public class ResultTable<K, V> {
    private final HashMap<K, V> map;

    public ResultTable() {
        map = new HashMap<>();
    }

    /**
     * Puts the input values values into the hash map 
     * By using the synchronized keyword, this method is thread safe
     * @param key
     * @param value
     */
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    /**
     * Returns a value given a key to the hash map
     * @param key
     * @return Value
     */
    public synchronized V get(K key) {
        return map.get(key);
    }

    /**
     * Returns true if the key is in the hash map, otherwise return false
     * @param key
     * @return Boolean
     */
    public synchronized boolean containsKey(K key) {
        return map.containsKey(key);
    }

    /**
     * Returns true if the value is in the hash map, otherwise returns false
     * @param value
     * @return Boolean
     */
    public synchronized boolean containsValue(V value) {
        return map.containsValue(value);
    }

    /**
     * Returns the size of the hash map
     * @return Int
     */
    public synchronized int size() {
        return map.size();
    }

    /**
     * Returns false if not empty and true if the hash map is empty
     * @return Boolean
     */
    public synchronized boolean isEmpty() {
        return map.isEmpty();
    }

    /*
     * Clears the map
     */
    public synchronized void clear() {
        map.clear();
    }

    @Override
    public synchronized String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("3.");
        for (K key : map.keySet()) {
            sb.append(map.get(key));
        }
        return sb.toString();
    }
}

