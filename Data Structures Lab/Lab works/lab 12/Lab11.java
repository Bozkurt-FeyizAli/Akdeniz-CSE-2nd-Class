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
