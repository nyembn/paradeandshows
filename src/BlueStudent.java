public class BlueStudent implements Runnable{
public static long time = System.currentTimeMillis();
private Parade p;
  private String name;
  private int number;
  private int paradeCompleted = 0; //decide where it belongs
  private int showsWatched = 0;
private long paradeDuration;
private List<Group> groupList;
  //array of parade time with 3 cells
  //array of shows time with 3 cells
  //Terminate after last show or watched 3 shows did 3 parades
  //1.Student (thread) name, what parade he participated in by giving its starting time,
  //what shows he watched by giving its starting time.
  //ParadeGround paradeGround;  //can be in Group
  //Group g;
//elapsed time
public joinGroup(){
	synchronized(Group.groupObject){
		Iterator<Group> groupIterator = groupIterator.iterator();
		while(//%%it is nor assigned}

			this.group = group
Group.groupObject.notify();
}
//??what happens afetr assignment
	//iterate untill null
	//join first available grop
	//Group must be synchronized since multiple threads ill try to access
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

  BlueStudent(int number, List<Group> groupList){
    name = ("Blue Student " + String.valueOf(number));
    this.number = number;
    this.groupList = groupList;
  }

  public String getName(){return name;}

public void setParadeDuration(long duration){
	this.paradeDuration = duration;
}

  public void run(){
	while(paradeCompleted < 3 /*&& showsWatched < 4) || time == lastParadeTime*/){
		//try to sync with parades
		//try to sync with shows
    //wait for all the students
    this.joinGroup();
	//watch shows
synchronized (this){
try{
	//waitING FOR PARADE TO START
synchronized(Group.groupObject){
		Group.groupObject.wait();
}
}
catch(InterruptedException ie){}
}
		//parade starts
	//should have rference to parade and show
System.out.println(getName() + " is parading");
try{
	Thread.sleep(paradeDuration);
}
catch(InterruptedException ie){}
System.out.println(getName() + " is ended parading");

    //march in group
  }

}

}
