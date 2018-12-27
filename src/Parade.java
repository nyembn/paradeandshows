import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Parade extends TimerTask{
  int totalNumberOfParades = 6;
  private List<Group> studentGroups;
  public static int i = 0;
  public Parade(List<Group> s){
    this.studentGroups = s;
  }

  public void run()
  {
    //while th group ist in not empty
    //ITERATE OVER ALL GROUP AND NOTIFY all waiting groups
  /*  for(int i=0; i<this.studentGroups.size(); i++){
      if(this.studentGroups.get(i).getTakingStudents()){
        //this.studentGroups.get(i).setClearToParade();
        this.studentGroups.get(i).parade();
      }
        //create group
        //GROUP BLOCKS ON SAME OBJECT
        //studentGroups.get(i).returnBlueStudent().setParadeDuration(1000);
        //studentGroups.get(i).returnBlueStudent().incParadeCount();
        //studentGroups.get(i).notifyAll();
        //NOTIFY THE GROUP
      }
    //signal a waiting student
    //Parade 1
    //Parade 2
    //Parade 3
    //Parade 4
    //Parade 5
    //Parade 6
    //synchronized block
*/
    System.out.println("Parade ran" + ++i);
    if(i == 6)
    {
      synchronized(MClock.clockObject)
      {
        MClock.clockObject.notify();
      }
    }
  }

}
