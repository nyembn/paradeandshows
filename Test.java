public class Test{
  public static void main(String args[]){
    ThreadGroup myThreadGroup = new ThreadGroup("Student Group");
    BlueStudent b1 = new BlueStudent(1);
    Thread t1 = new Thread(myThreadGroup, b1);
    t1.start();
 }
}
