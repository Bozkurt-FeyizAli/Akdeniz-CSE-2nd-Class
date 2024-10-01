import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {
    public static void main(String[] args) {    
        // Set up Rick's guitar inventory
         Inventory inventory = new Inventory();    
        initializeInventory(inventory);    
        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 5, Wood.ALDER, Wood.ALDER);    
        List matchingGuitars=inventory.search(whatErinLikes);
        if(!matchingGuitars.isEmpty()) {
        System.out.println("Erin, youmightliketheseguitars:");
        for(Iterator i =matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar=(Guitar)i.next();
        GuitarSpec guitarSpec=guitar.getSpec();
        if(guitarSpec.matches(whatErinLikes)){
            System.out.println("Erin, you might like this " +
            guitarSpec.getBuilder() + " " +
            guitarSpec.getModel() + " " +
            guitarSpec.getType() + " guitar:\n " +
            guitarSpec.getBackWood() + " back and sides,\n " +
            guitarSpec.getTopWood() + " top.\nYou can have it for only $" +
            guitar.getPrice() + "!"); 
            System.out.println("----");   
            }  
        }
        }
        else {      
            System.out.println("Sorry, Erin, we have nothing for you.");    
            } 
        }  
        private static void initializeInventory(Inventory inventory) {    
        inventory.addGuitar("V95693", 1499.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);    
        inventory.addGuitar("V32679", 1549.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
        // Add other guitars to the inventory...
         }



}