import java.util.Timer; 
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList;
public class MClock{
    public static MClock obj; 
    private static List<BlueStudent> bg;
    public static void main(String[] args) throws InterruptedException 
    { 
        obj = new MClock();
	//lock = new BlueStudent();
	bg = new ArrayList<BlueStudent>();

          
        // creating an instance of timer class 
        Timer timer = new Timer(); 
          for(int i=1; i<4; i++){
        // creating instances of task to be scheduled
	BlueStudent b = new BlueStudent(i);
	new Thread(b).start();
	bg.add(b);
	//RANDOM BECAUSE SNACK BREAK
}
	//wait for parade
	//implement as a list List<BlueStudents>
        TimerTask parade = new Parade(bg); //ENTER AS A GROUP NOT INDIVIDYAL then 
	TimerTask show = new Show();//then only one group parades at a time
          
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
