import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lab12 {
    public static void main(String[] args) {
       Map<String, Integer> map1=new Map<>(20);
       for (int i = 0; i <19; i++) {
            map1.put(Integer.toString(i), i);
       }

       for (var var : map1.entrySet()) {
        System.out.print(var.getKey());
        //System.out.print("  "+var.getValue());
   }
       Map<Integer, String> map2= new Map<>(map1.list.length);
       System.out.println();

       map2=map1.reverse();
       Map<String, Integer> map3= new Map<>(map2.list.length);
       map3=map2.reverse();


       for (var var : map3.entrySet()) {
            System.out.print(var.getKey());
            //System.out.print("  "+var.getValue());
       }
    }
}

interface IEntry<K, V> {
    K getKey();
    V getValue();
    void setValue(V value);
}

class Entry<K, V> implements IEntry<K, V> {
    private K key;
    private V value;

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
    Entry<K, V>[] list;

    public Map(int cap){
        size=0;
        list= (Entry<K, V>[])new Entry[cap];
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
        int index= hashIndex(key);
        if(list[index]==null){
            list[index]=new Entry<>(key, value);
            size++;
            return null;
        }
        else {
        V v=list[index].getValue();
        list[index].setValue(value);
        size++;
        return v;
        }
    }

    @Override
    public V remove(K key) {
        int index= hashIndex(key);
        if(list[index]==null) return null;
        V v= list[index].getValue();
        list[index]= null;
        size--;
        return v;
    }

    @Override
    public V get(K key) {
        int index= hashIndex(key);
        if(list[index]==null) return null;
        return list[index].getValue();
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
       List<Entry<K, V>> nList= new ArrayList<>();
       for (var entry : list) {
            if(entry!=null)
            nList.add(entry);
       }
       return nList;
    }

    @Override
    public Iterable<K> keySet() {
        List<K> nList= new ArrayList<>();
       for (var entry : list) {
            if(entry!=null)
            nList.add(entry.getKey());
       }
       return nList;
    }

    @Override
    public Iterable<V> values() {
        List<V> nList= new ArrayList<>();
       for (var entry : list) {
            if(entry!=null)
            nList.add(entry.getValue());
       }
       return nList;
    }

    public int hashIndex(K k){
        return Math.abs(k.hashCode()%list.length);
    }

    public Map<V, K> reverse(){
        Map<V, K> map= new Map<>(list.length);
        for (var entry : list) {
            if(entry!=null)
            map.put((V)entry.getValue(), (K)entry.getKey());
        }
        return map;
    }

}