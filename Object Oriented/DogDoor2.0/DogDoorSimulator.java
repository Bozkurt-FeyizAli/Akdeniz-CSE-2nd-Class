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

















            