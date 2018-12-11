import java.util.Timer; 
import java.util.TimerTask; 
  
public class Show extends TimerTask 
{ 
    public static int i = 0; 
    public void run() 
    { 
        System.out.println("Show ran" + ++i); 
        /*if(i == 3) 
        { 
            synchronized(MClock.obj) 
            { 
                MClock.obj.notify(); 
            } 
        }
*/
//make the threads sleep during the  time
//calling to update showCount
    } 
      
} 
