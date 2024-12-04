import java.io.*;
import java.util.*;

public class HW03 {
    public static void main(String[] args) {
         File f = new File("./test.html");
        try (Scanner reader = new Scanner(f)) {
            StringBuilder content = new StringBuilder();
            while (reader.hasNextLine()) {
                content.append(reader.nextLine()).append(System.lineSeparator());
            }
            String fileContent = content.toString();
            
            System.out.println(isHTMLMatching(fileContent));
        } catch (Exception e) {
            System.out.println(e);
        } 

        ArrayQueue<String> queue = new ArrayQueue<>(15);

        // Test: Kuyruğa eleman ekleme
        System.out.println("Kuyruğa eleman ekleniyor...");
        queue.enqueue("Birinci");
        queue.enqueue("İkinci");
        queue.enqueue("Üçüncü");
        System.out.println("Kuyruk: " + queue);

        // Test: Kuyruğun ilk elemanını görüntüleme (çıkarmadan)
        System.out.println("\nKuyruğun ilk elemanı: " + queue.first());

        // Test: Kuyruğun ilk elemanını çıkarma
        System.out.println("\nKuyruğun ilk elemanı çıkarılıyor: " + queue.dequeue());
        System.out.println("\nKuyruğun ilk elemanı: " + queue.first());
        System.out.println("Kuyruk: " + queue);

        // Test: Kuyruk boş mu kontrolü
        System.out.println("\nKuyruk boş mu? " + queue.isEmpty());

        // Test: Kuyruğun boyutunu öğrenme
        System.out.println("Kuyruğun boyutu: " + queue.size());

        // Tüm elemanları çıkarma
        System.out.println("\nKuyruktaki tüm elemanlar çıkarılıyor...");
        while (!queue.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + queue.dequeue());
        }
        System.out.println("Kuyruk boş mu? " + queue.isEmpty());

        System.out.println("=== ArrayStack Test ===");
        IStack<Integer> arrayStack = new ArrayStack<>(5); // Kapasitesi 5 olan bir ArrayStack

        // Eleman ekleme
        System.out.println("Stack'e eleman ekleniyor: 10, 20, 30");
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        System.out.println("Stack durumu: " + arrayStack);

        // Top eleman kontrolü
        System.out.println("Stack'in en üst elemanı: " + arrayStack.top());

        // Eleman çıkarma
        System.out.println("Stack'ten eleman çıkarılıyor: " + arrayStack.pop());
        System.out.println("Stack durumu: " + arrayStack);

        // Stack dolu mu kontrolü
        System.out.println("Stack dolu mu? " + (arrayStack.size() == 5));

        // Tüm elemanları çıkarma
        System.out.println("Tüm elemanlar çıkarılıyor...");
        while (!arrayStack.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + arrayStack.pop());
        }
        System.out.println("Stack boş mu? " + arrayStack.isEmpty());

        System.out.println("\n=== LinkedStack Test ===");
        IStack<String> linkedStack = new ArrayStack<>(15);

        // Eleman ekleme
        System.out.println("Stack'e eleman ekleniyor: A, B, C");
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");
        System.out.println("Stack durumu: " + linkedStack);

        // Top eleman kontrolü
        System.out.println("Stack'in en üst elemanı: " + linkedStack.top());

        // Eleman çıkarma
        System.out.println("Stack'ten eleman çıkarılıyor: " + linkedStack.pop());
        System.out.println("Stack durumu: " + linkedStack);

        // Eleman ekleme ve çıkarma kombinasyonu
        linkedStack.push("D");
        System.out.println("Stack'e eleman ekleniyor: D");
        System.out.println("Stack durumu: " + linkedStack);

        // Tüm elemanları çıkarma
        System.out.println("Tüm elemanlar çıkarılıyor...");
        while (!linkedStack.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + linkedStack.pop());
            System.out.println("Stack durumu: " + linkedStack);

        }
        System.out.println("Stack boş mu? " + linkedStack.isEmpty());

        System.out.println(evaluate("(15+5)*3"));
        System.out.println(reverse("abcd"));


        System.out.println(evaluate("3 + 5"));           // 8
System.out.println(evaluate("(1 + 2) * 3"));     // 9
System.out.println(evaluate("10 / (2 + 3)"));    // 2
System.out.println(evaluate("100 + 2 * 6"));     // 112
System.out.println(evaluate("(4 + 2) * (3 - 1)")); // 12
System.out.println(evaluate(""));               // 0 veya hata beklenmeli
System.out.println(evaluate("5 + )"));  
        
    }

    public static boolean isMatching(String expression) {
            /*
         * Given a string containing parentheses and other characters,
         *  write a function that determines whether the parentheses
         *  in the string are balanced. A string is said to have balanced
         *  parentheses if every opening parenthesis ((, {, [) has a
         *  corresponding closing parenthesis (), }, ]), and the pairs
         *  are properly nested.
         */
        // Your code here..
        String open="({[";
        String close=")}]";
        char[] letters=expression.toCharArray();
        LinkedStack<Character> parantez=new LinkedStack<>();
        for (char c : letters) {
            if(open.indexOf(c)!=-1)
                parantez.push(c);
            else if(close.indexOf(c)!=-1){
                if(parantez.isEmpty())
                    return false;
                int i=close.indexOf(c);
                if(open.charAt(i)==parantez.top())
                    parantez.pop();
            }
        } 
        return parantez.isEmpty();
        
    }

    public static String reverse(String str) {
            /*
         * Write a function that reverses a given string using a stack.
         *  In this problem, you will leverage the Last-In-First-Out (LIFO)
         *  property of a stack to reverse the order of characters in a string.
         */
        // Your code here..
        LinkedStack<Character> letters= new LinkedStack<>();
        for (char c : str.toCharArray()) {
            letters.push(c);
        }
        StringBuilder result=new StringBuilder();
        while (!letters.isEmpty()) {
            result.append(letters.pop());
        }
        return result.toString();
    }

    public static boolean isHTMLMatching(String html) {
            /*
         * In HTML, every opening tag (like <div>) must have a corresponding closing
         *  tag (like </div>). Write a function to check whether all the HTML tags in
         *  a given string are properly matched. A properly matched HTML string has balanced
