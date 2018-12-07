public class OrangeStudent extends Thread{
  private String name;
  private int number;
  private boolean marchComplete;
  //Object group;
  //ParadeGround paradeGround;
  Group g;

  OrangeStudent(int number, ParadeGround pg){
    name = ("Orange Student " + String.valueOf(number));
    //paradeGround = pg;
    this.number = number;
    marchComplete = false;
  }

  public int StudentNumber(){return this.number;}

  public boolean marchStatus(){return marchComplete;}

  public void parade(){
    try{
    paradeGround.Occupy(this);
  }

  catch (Exception e)
      {
          System.out.println("Thread interrupted.");
      }

  }

  public String studentName(){return name;}

  public void run(){
    System.out.println(studentName() + " is running");
    this.parade();
    marchComplete = true;
    //arrive
    //form group
    //block on untill nofified by clock
    //relation between march and clock
    //march in group
  }

}
