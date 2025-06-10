package HomeWorks;
import java.util.Arrays;
public class MyHashMap<K, V> {
        private static final int DEFAULT_CAPACITY = 16;
        private static final float LOAD_FACTOR = 0.75f;
        private Entry<K, V>[] table;
        private int size;

        static class Entry<K, V> {
            final K key;
            V value;
            Entry<K, V> next;

            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public MyHashMap() {
            table = new Entry[DEFAULT_CAPACITY];
        }
        public void put(K key, V value) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            int hash = hash(key);
            int index = hash % table.length;

            Entry<K, V> entry = table[index];
            while (entry != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }

            Entry<K, V> newEntry = new Entry<>(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
            size++;

            if ((float) size / table.length > LOAD_FACTOR) {
                resize();
            }
        }

        public V get(K key) {
            int hash = hash(key);
            int index = hash % table.length;

            Entry<K, V> entry = table[index];
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return null;
        }

        private int hash(K key) {
            return key.hashCode() & 0x7FFFFFFF;
        }

        private void resize() {
            Entry<K, V>[] oldTable = table;
            table = new Entry[table.length * 2];
            size = 0;

            for (Entry<K, V> entry : oldTable) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }

        public static void main(String[] args) {
            MyHashMap<String, Integer> map = new MyHashMap<>();
            map.put("apple", 10);
            map.put("banana", 20);
            map.put("orange", 30);

            System.out.println("apple: " + map.get("apple"));   // 10
            System.out.println("banana: " + map.get("banana")); // 20
            System.out.println("pear: " + map.get("pear"));    // null
        }
    }

