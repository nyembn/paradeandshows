import java.util.Timer; 
import java.util.TimerTask;
import java.util.List;
  
public class Parade extends TimerTask{
int totalNumberOfParades = 6;
private List<BlueStudent> bg;
//private BlueStudent b;
public static int i = 0;
public Parade(List<BlueStudent> b){
	this.bg = b;
}
 
    public void run()
    {
	//while th group ist in not empty
	//ITERATE OVER ALL GROUP AND SIGNAL
	for(int i=0; i<bg.size(); i++){
	synchronized(bg.get(i)){//**********
	//create group
	//GROUP BLOCKS ON SAME OBJECT
	bg.get(i).setParadeDuration(1000);
	(bg.get(i)).incParadeCount();
		bg.get(i).notify();
	//NOTIFY THE GROUP
}
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
