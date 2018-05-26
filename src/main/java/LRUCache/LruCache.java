package LRUCache;

public class LruCache {
    private int capacity;
    private Entry head = null;
    private Entry tail = null;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }


    public void put(int key, int value) {
        /*
        check if we have this key in our arr
        if true set this element to head
        else add new element to head with new key and value
         */

    }


    public int get(int key) {
        Entry entry = searchEntryByKey(key);

        if (key <= 0) {
            throw new IndexOutOfBoundsException("Key always must be positive!");
        }

        if (entry.getKey() == key) {
            //set this element to head(create method setElementToHead
            return entry.getKey();
        } else {
            return -1;
        }
    }

    public void deleteTail(Entry entry) {
        //delete tail
        entry.previousElemnt.nextElement = entry.nextElement;
    }

    public Entry searchEntryByKey(int key) {

        return null;
    }

    class Entry {

        private int key;
        private int value;
        private Entry previousElemnt;
        private Entry nextElement;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
