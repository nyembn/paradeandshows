import java.util.Timer; 
import java.util.TimerTask; 
  
public class Parade extends TimerTask{
int totalNumberOfParades = 6;
BlueStudent b;
public static int i = 0;
public Parade(BlueStudent b){
	this.b = b;
}
 
    public void run()
    {
	synchronized(b){
		b.setParadeDuration(1000);
		b.incParadeCount();
		b.notify();
}
	//signal a waiting student
	//Parade 1
	//Parade 2
	//Parade 3
	//Parade 4
	//Parade 5
	//Parade 6
	//synchronized block

        System.out.println("Parade ran" + ++i); 
        if(i == 6) 
        { 
            synchronized(MClock.obj) 
            { 
                MClock.obj.notify(); 
            } 
        } 
    } 
      
} 
