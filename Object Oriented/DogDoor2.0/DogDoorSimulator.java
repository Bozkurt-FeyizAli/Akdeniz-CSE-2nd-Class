import java.util.Timer; 
import java.util.TimerTask;  

public class DogDoorSimulator{ 
    public static void main(String[] args) { 
    
    } 
    }
    class DogDoor { 
        boolean open;
        public void open() { 
        System.out.println("Thedog dooropens."); 
        open= true; 
        final Timer timer= new Timer(); 
        timer.schedule(new TimerTask() { 
        public void run() { 
        close(); 
        timer.cancel(); 
        } 
        }, 5000); 
        } 
        public void close() { 
        System.out.println("Thedog doorcloses."); 
        open= false; 
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
                if (door.open) { 
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
                    System.out.println(" BarkRecognizer:" +
                     "Heard a ‘" + bark + "’"); 
                    door.open(); 
                    }
                }    

















            