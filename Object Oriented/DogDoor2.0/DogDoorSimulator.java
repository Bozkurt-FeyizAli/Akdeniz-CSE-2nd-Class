import java.util.Timer; 
import java.util.TimerTask; 

public class DogDoorSimulator { 
    public static void main(String[] args) { 
    DogDoor door = new DogDoor(); 
    Remote remote = new Remote(door); 
    // We need a new simulator!
     System.out.println("Fido barks to go outside..."); 
    remote.pressButton(); 
    System.out.println("\nFido has gone outside..."); 
    //  Our old simulator assumes Todd 
    // and Gina are closing the door 
    // manually, and not letting the 
    // timer do its work. 
    // Let’s update our simulator to 
    // make it work with the updated 
    // class.
    System.out.println("\nFido’s all done..."); 
     
    
    System.out.println("\nFido’s back inside...");
    }

}


class DogDoor { 
    private boolean open; 
    public DogDoor() { 
    this.open = false; 
    } 
    public void open() { 
    System.out.println("The dog door opens."); 
    open = true; 
    } 
    public void close() { 
    System.out.println("The dog door closes."); 
    open = false; 
    } 
    public boolean isOpen() { 
    return open; 
    } 
}

    class Remote { 
        private DogDoor door; 
        public Remote(DogDoor door) { 
        this.door = door; 
        } 
        // isOpen
        //  Code magnets
        //  public void pressButton() { 
        // System.out.println("Pressing the remote control button..."); 
        // if (door.isOpen()) { 
        // door.close(); 
        // } else { 
        // door.open(); 
        // } 
        // } 

        public void pressButton() { 
            System.out.println("Pressing the remote control button..."); 
            if (door.isOpen()) { 
            door.close(); 
            } else { 
            door.open(); 
            final Timer timer = new Timer(); 
            timer.schedule(new TimerTask() { 
            public void run() { 
            door.close(); 
            timer.cancel(); 
            } 
            }, 5000);
             } 
            } 
        }
        class BarkRecognizer { 
            private DogDoor door; 
            public BarkRecognizer(DogDoor door) { 
            this.door=door; 
            } 
            public void recognize(String bark) { 
            System.out.println(" BarkRecognizer: Heard a ‘" +
             bark + "’"); 
            door.open(); 
            } 
            }