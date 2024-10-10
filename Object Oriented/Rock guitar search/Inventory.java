import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    
    List<Guitar> guitars;
    List<Guitar> matchingGuitars;
    

    public Inventory(){
        guitars= new LinkedList<>();
        matchingGuitars=  new LinkedList<>();;
    }

    public void addGuitar(String serialNumber, double price,
        Builder builder, String model,
        Type type, Wood backWood, Wood topWood) {
        Guitar guitar=new Guitar(serialNumber, price, new GuitarSpec(builder,
        model, type, 5, backWood, topWood));
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for(Iterator<Guitar> i =guitars.iterator(); i.hasNext(); ) {
        Guitar guitar=(Guitar)i.next();
        if(guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
        }
        }
        return null;
    }

    

    
        public List search(GuitarSpec searchSpec) {
            matchingGuitars= new LinkedList<>();
            for(Iterator<Guitar> i =guitars.iterator(); i.hasNext(); ) {
            Guitar guitar=(Guitar)i.next();
            // Ignoreserialnumberandpricesince theyareunique
            GuitarSpec guitarSpec=guitar.getSpec();
            if(guitar.getSpec().matches(searchSpec))
                matchingGuitars.add(guitar);
            }
            return matchingGuitars;
            }

}
