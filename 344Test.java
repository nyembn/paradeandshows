public class Test{
  public static void main(String args[]){
    ThreadGroup myThreadGroup = new ThreadGroup("Student Group");
    BlueStudent b1 = new BlueStudent(1);
     new Thread(b1).start();
 }
}
