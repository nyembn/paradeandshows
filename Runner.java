public class Runner{
  public static void main(String args[]){
    ParadeGround pg = new ParadeGround();
    int numOrange = 4, numBlue = 1, numSeats = 7;

    for(int i=1; i<(numOrange + 1); i++){
      OrangeStudent o = new OrangeStudent(i, pg);
      o.start();
    }

    for(int i=1; i<(numBlue + 1); i++){
      BlueStudent b = new BlueStudent(i, pg);
      b.start();
    }


  }
}
