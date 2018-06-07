package LRUCache;

public class LruCache {
    private int capacity;
    private int size;
    private Entry head;
    private Entry tail;

    public LruCache(int capacity) {
        Entry temp = new Entry();
        this.capacity = capacity;
        head = temp;
        tail = temp;
    }


    public void put(int key, int value) {
        if (size == 0) {
            head = new Entry(key, value);
            tail = head;
            size++;
            return;
        }

        Entry temp = searchEntryByKey(key);

        if (temp != null) {
            temp.value = value;
            setElementToHead(temp);
            return;
        }

        Entry newHead = new Entry(key, value);
        newHead.nextElement = head;
        head.previousElemnt = newHead;
        head = newHead;
        size++;
    }

    public void setElementToHead(Entry entry) {
        entry.previousElemnt.nextElement = entry.nextElement;

        if (entry.nextElement == null) {
            tail = entry.previousElemnt;
        }

        if (entry.nextElement != null) {
            entry.nextElement.previousElemnt = entry.previousElemnt;
        }

        entry.previousElemnt = null;
        entry.nextElement = head;
        head.previousElemnt = entry;
        head = entry;
    }

    public int get(int key) {
        Entry entry = searchEntryByKey(key);

        if (key <= 0) {
            throw new IndexOutOfBoundsException("Key always must be positive!");
        }

        if (entry.getKey() == key) {
            setElementToHead(entry);
            return entry.getKey();
        } else {
            return -1;
        }
    }

    public void deleteTail(Entry entry) {
        tail = tail.nextElement;
        tail.previousElemnt = null;
        size--;
    }

    public Entry searchEntryByKey(int key) {
        Entry temp = tail;

        for (int i = 0; i < size; i++) {
            if (temp.key == key) {
                return temp;
            }
            temp = temp.nextElement;
        }

        return temp = null;
    }

    public int getSize() {
        return size;
    }

    public class Entry {

        private int key;
        private int value;
        private Entry previousElemnt;
        private Entry nextElement;

        public Entry() {
        }

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry(int key, int value, Entry previousElemnt, Entry nextElement) {
            this.key = key;
            this.value = value;
            this.previousElemnt = previousElemnt;
            this.nextElement = nextElement;
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
