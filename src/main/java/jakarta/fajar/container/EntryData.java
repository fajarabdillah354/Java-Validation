package jakarta.fajar.container;


// contoh pembuatan class multiple generic yang ingin kita extrat valuenya
public class EntryData<K,V> {

    private K key;

    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }



}
