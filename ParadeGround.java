public class ParadeGround{
  private boolean status;

  ParadeGround(){this.status = false;}
  public synchronized void Occupy(OrangeStudent t) throws InterruptedException{
    //student is parading
    try{
    if(t.StudentNumber() != 4 )/*&& status == false)*/{
      wait();
    }

  }
    /*try{
      t.sleep(1000);
    }
*/
    catch (Exception e)
        {
            System.out.println("Thread interrupted.");
        }

        System.out.println(t.studentName() + " is parading");
        if(t.StudentNumber() == 4){
          //status = true;
          notifyAll();
        }
  }
}
