import java.util.ArrayList;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Lab11 {
    public static void main(String[] args) {
        // Example usage
        IMap<Integer, String> map = new Map<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("Key 2: " + map.get(2));
        System.out.println("Removing key 1: " + map.remove(1));

        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Harita oluşturuluyor
        IMap<Integer, String> map1 = new Map<>();

        // put() metodunun testi
        map1.put(1, "One");
        map1.put(2, "Two");
        map1.put(3, "Three");
        System.out.println("Initial Map:");
        for (Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // get() metodunun testi
        System.out.println("\nValue for key 2: " + map1.get(2));
        System.out.println("Value for key 4 (not present): " + map1.get(4));

        // remove() metodunun testi
        System.out.println("\nRemoving key 1...");
        String removedValue = map1.remove(1);
        System.out.println("Removed value: " + removedValue);

        System.out.println("\nMap after removing key 1:");
        for (Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // keySet() ve values() metotlarının testi
        System.out.println("\nKeys:");
        for (Integer key : map1.keySet()) {
            System.out.println(key);
        }

        System.out.println("\nValues:");
        for (String value : map1.values()) {
            System.out.println(value);
        }

        // size() ve isEmpty() metotlarının testi
        System.out.println("\nMap size: " + map1.size());
        System.out.println("Is map empty? " + map1.isEmpty());
    }
}

interface IEntry<K, V> {
    K getKey();
    V getValue();
    void setValue(V value);
}

class Entry<K, V> implements IEntry<K, V> {
    K key;
    V value;

    public Entry(K k, V v){
        key=k;
        value=v;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
       return value;
    }

    @Override
    public void setValue(V value) {
       this.value=value;
    }

}

interface IList<T> {
    int size();
    boolean isEmpty();
}

interface IMap<K, V> extends IList<K> {
    V put(K key, V value);
    V remove(K key);
    V get(K key);
    Iterable<Entry<K, V>> entrySet();
    Iterable<K> keySet();
    Iterable<V> values();
}

class Map<K, V> implements IMap<K, V> {
    int size;
    ArrayList<Entry<K, V>> list;

    public Map(){
        size=0;
        list = new ArrayList<>();
    }

    @Override
    public int size() {
       return size;
    }

    @Override
    public boolean isEmpty() {
       return size==0;
    }

    @Override
    public V put(K key, V value) {
        
            Entry<K, V> nEntry= new Entry<>(key, value);
            int index=Index(key);
            while(list.get(index)!=null&&list.get(index).getValue()!=null){
                if (list.get(index).getKey().equals(key)) {
                    V oldValue = list.get(index).getValue();
                    list.set(index, new Entry<>(key, value));
                    return oldValue;
                }
                index+=1;
                if(index==list.size())
                    index-=list.size();
            }
        list.set(index, nEntry);
        size++;
        return value;
    }

    @Override
    public V remove(K key) {
        if(isEmpty())
            return null;
        else{
            int index= Index(key);
            while(list.get(index)!=null)
                if(list.get(index).getKey() != null&&list.get(index).getKey().equals(key)){
                    V value=list.get(index).getValue();
                    list.get(index).setValue(null);
                    size--;
                    return value;
                }
                index++;
                if(index==list.size())
                    index-=list.size();
            }
        return null;
    }

    @Override
    public V get(K key) {
        if(isEmpty())
            return null;
        else{
            int index= Index(key);
            while(list.get(index)!=null)
            if(list.get(index).getKey() != null&&list.get(index).getKey().equals(key)){
                    return list.get(index).getValue();
                }
                index++;
                if(index>=list.size())
                    index-=size;
            }
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> nList= new ArrayList<>();
        for (Entry<K,V> entry : list) {
            if(entry==null)
                continue;
            if(entry.getValue()==null)
                continue;
            nList.add(entry);
        }
        return nList;
    }

    @Override
    public Iterable<K> keySet() {
        List<K> nList= new ArrayList<>();
        for (Entry<K,V> entry : list) {
            if(entry==null)
                continue;
            if(entry.getValue()==null)
                continue;
            nList.add(entry.getKey());
        }
        return nList;
    }

    @Override
    public Iterable<V> values() {
        List<V> nList= new LinkedList<>();
        for (Entry<K,V> entry : list) {
            if(entry==null)
                continue;
            if(entry.getValue()==null)
                continue;
            nList.add(entry.getValue());
        }
        return nList;
    }

    public int hash(K k){
        return k.hashCode();
    }

    public int Index(K k){
        return hash(k)%list.size();
    }

}