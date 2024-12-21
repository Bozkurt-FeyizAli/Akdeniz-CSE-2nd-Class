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
