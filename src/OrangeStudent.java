import java.util.List;
import java.util.Iterator;
public class OrangeStudent implements Runnable{
  public static long time = System.currentTimeMillis();
  private String name;
  private int number;
  private int paradeCompleted;
  private int showsWatched;
  private long paradeDuration;
  private List<Group> groupList;
  private Group inGroup;
  private Group groupLock;
  private boolean groupAssigned;
  //%%array of parade time with 3 cells
  //%%array of shows time with 3 cells
  //(R)1.Student (thread) name, what parade he participated in by giving its starting time,
  //(R)what shows he watched by giving its starting time.
  public boolean getGroupAssigned(){
    return groupAssigned;
  }

  public void setGroupAssigned(boolean v){
    this.groupAssigned = v;
  }

  public void setInGroup(Group g){
    this.inGroup = g;
  }

  public String getName(){return name;}
  public int getNumber(){return number;}

  public void setParadeDuration(long duration){
    this.paradeDuration = duration;
  }

  public void incParadeCount(){
    this.paradeCompleted++;
  }

  public void incShowCount(){
    this.showsWatched++;
  }
  public void msg(String m) {
    System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
  }

  public void joinGroup(){
    Iterator<Group> groupIterator = this.groupList.iterator();
    while(!this.groupAssigned && groupIterator.hasNext()){
      this.groupLock = groupIterator.next();
      this.groupLock.orangeStudentJoinGroup(this);
    }
    System.out.println(this.getName() + " is in Group -- " + this.inGroup.getGroupNumber());
  }
  //??what happens afetr assignment
  //iterate untill null
  //join first available grop
  //Group must be synchronized since multiple threads ill try to access
  OrangeStudent(int number, List<Group> groupList){
    this. name = ("Orange Student ---- " + String.valueOf(number));
    this.number = number;
    this.groupList = groupList;
    this.paradeCompleted = 0;
    this.showsWatched = 0;
    //this.inGroup = null;
    this.groupAssigned = false;

  }
  public void run(){
    this.joinGroup();
    /*
    while(paradeCompleted < 3 && showsWatched < 4) || time == lastParadeTime){
      //try to sync with parades
      //try to sync with shows
      //wait for all the students
      //WAIT UNTILL GROUP NOTIFIES TO Parade
      while(!this.inGroup.getClearToParade()){
      try{
      this.inGroup.getParadeLock().wait();
    }
    catch(InterruptedException ie){}

  }

  System.out.println(this.getName() + " is parading in group " + this.inGroup.getGroupNumber());
  System.out.println(getName() + " is ended parading");
  try{
  Thread.sleep(paradeDuration);
}
catch(InterruptedException ie){}
paradeCompleted++;
this.groupAssigned = false;
// ** get gruop temporaryGroupReference
// ** don't let them comeback her let them stay blocked on the group
// ** block on a group certain timer
//
//watch shows
/*synchronized (this){
try{
//waitING FOR PARADE TO START
//System.out.println(this.getName() + " is Parading");
this.wait();
}
catch(InterruptedException ie){}
}
System.out.println(getName() + " is ended parading");
paradeCompleted++;
this.groupAssigned = false;

//march in group
*/
}

}
