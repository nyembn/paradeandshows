import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList;
public class MClock{
  public static MClock obj;
  public static Group groupObject;
  private static List<Group> groupList;
  public static void main(String[] args) throws InterruptedException
  {
    int blueStudent = 16, orangeStudent = 7;
    int totalStudent = (blueStudent + orangeStudent);
    int numberOfGroups = (totalStudent/3);

    //create group and add to group list
    groupList = new ArrayList<Group>();
    for(int i=0; i < numberOfGroups; ++){
      Group group = new Group(i);
      groupList.add(group);
    }
    //lock objects
    obj = new MClock();
    groupObject = new Group();


    // creating an instance of Timer class
    Timer timer = new Timer();

    //create student threads
    for(int i=1; i < blueStudent; i++){
      BlueStudent b = new BlueStudent(i, groupList);
      new Thread(b).start();
      groupList.add(b);
      //%%RANDOM BECAUSE SNACK BREAK
    }
    //%%wait for parade
    // creating instances of tasks to be scheduled
    TimerTask parade = new Parade(group); //%%ENTER AS A GROUP NOT INDIVIDUAL
    TimerTask show = new Show();//%%then only one group parades at a time

    // scheduling the timer instances
    timer.schedule(parade, 1000, 6000);
    timer.schedule(show, 5500, 9000);
    // fetching the scheduled execution time of
    // the most recent actual execution of the task
    System.out.println(parade.scheduledExecutionTime());

    synchronized(obj)
    {
      // wait untill parade and shows are complete
      obj.wait();
    }

    //canceling the task assigned
    System.out.println("End of parade: " + parade.cancel());
    // System.out.println("End of show: " + show.cancel());

    // time is still running
    // so need to cancel it
    timer.cancel();
  }
}
