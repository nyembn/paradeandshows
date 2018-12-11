import java.util.Timer; 
import java.util.TimerTask;
import java.util.List;
public class MClock{
    public static MClock obj; 
    public static void main(String[] args) throws InterruptedException 
    { 
        obj = new MClock(); 
          
        // creating an instance of timer class 
        Timer timer = new Timer(); 
          
        // creating instances of task to be scheduled
	BlueStudent b = new BlueStudent(1);
	new Thread(b).start();
	//wait for parade
	//implement as a list List<BlueStudents>
        TimerTask parade = new Parade(b);
	TimerTask show = new Show(); 
          
        // scheduling the timer instance 
        timer.schedule(parade, 1000, 6000); 
        timer.schedule(show, 5500, 9000);
        // fetching the scheduled execution time of  
        // the most recent actual execution of the task 
        System.out.println(parade.scheduledExecutionTime()); 
          
        synchronized(obj) 
        { 
            //this thread waits until i reaches 4 
            obj.wait(); 
        } 
          
        //canceling the task assigned  
        System.out.println("Cancel the timer task: " + parade.cancel()); 
          
        // at this point timer is still running  
        // without any task assigned to it 
      
        // canceling the timer instance created 
        timer.cancel(); 
    }
}
