public class BlueStudent extends Thread{
  private String name;
  private int number;
  private boolean marchComplete; //decide where it belongs
  //ParadeGround paradeGround;  //can be in Group
  Group g;

  BlueStudent(int number, ParadeGround pg){
    name = ("Blue Student " + String.valueOf(number));
    marchComplete = false;
    this.number = number;
    //paradeGround = pg;
  }

  public String studentName(){return name;}

  public void run(){
    //wait for all the students
    //join group
    System.out.println(studentName() + " is running");
    //march in group
  }

}
