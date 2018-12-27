import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList;
public class MClock{
  public static MClock clockObject;
  //**public static Group groupObject;
  public static List<Group> groupList;
  public static void main(String[] args) throws InterruptedException
  {
    int blueStudent = 3, orangeStudent = 6;
    int totalStudent = (blueStudent + orangeStudent);
    int numberOfGroups = (totalStudent/3);

    // Create group and add to group list
    groupList = new ArrayList<Group>();
    for(int i=1; i < (numberOfGroups+1); i++){
      Group group = new Group(i);
      groupList.add(group);
    }
    clockObject = new MClock();

    // Creating an instance of Timer class
    Timer timer = new Timer();

    //create student threads
    for(int i=1; i < (blueStudent+1); i++){
      BlueStudent b = new BlueStudent(i, groupList);
      new Thread(b).start();
    }

    for(int i=1; i < (orangeStudent+1); i++){
      OrangeStudent o = new OrangeStudent(i, groupList);
      new Thread(o).start();
    }

    // Creating instances of tasks to be scheduled

    TimerTask parade = new Parade(groupList); //%%notify all waiting groups
    TimerTask show = new Show();//%%then only one group parades at a time

    // scheduling the timer instances
    timer.schedule(parade, 1000, 6000);
    timer.schedule(show, 5500, 9000);
    // fetching the scheduled execution time of
    // the most recent actual execution of the task
    System.out.println(parade.scheduledExecutionTime());

    synchronized(clockObject)
    {
      // wait untill parade and shows are complete
      clockObject.wait();
    }

    //canceling the task assigned
    System.out.println("End of parade: " + parade.cancel());
    // System.out.println("End of show: " + show.cancel());

    // timer is still running
    // so need to cancel it
    timer.cancel();
  }
}
