import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.Iterator;

public class Parade extends TimerTask{
  int totalNumberOfParades = 6;
  private List<Group> studentGroups;
  public static int i = 0;
  public Parade(List<Group> s){
    this.studentGroups = s;
  }

  public void run(){
  Iterator<Group> groupIterator = studentGroups.iterator();
  while(groupIterator.hasNext()){
    Group g = groupIterator.next();
    if(!g.getTakingStudents()){
    g.signalToParade();
  }
}
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
