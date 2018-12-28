import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class Group{
	private int groupNumber;
	private BlueStudent blueStudent;
	private List<OrangeStudent> orangeStudentList;
	private boolean takingStudents;
	private int studentCount;
	private boolean clearToParade;
	//*private Object paradeLock;
	//*private boolean orangeFilled;
	private boolean blueStudentFilled;

	/*
	 *Concurrently accessed methods need to be synchronized since
	 *all student will try to join groups
	 */
	//block untill 3 or last group
	//create #numstu/3 group objecst
	//GROUP SHOULD WAIT AFTER A GROUP IS FORMED
	public Group(int n){
		this.takingStudents = true;
		this.studentCount = 0;
		this.groupNumber = n;
		this.clearToParade = false;
		this.orangeStudentList = new ArrayList<OrangeStudent>();

	}

	public synchronized BlueStudent returnBlueStudent(){
		return this.blueStudent;
	}

	public synchronized List<OrangeStudent> returnOrangeStudentList(){
		return this.orangeStudentList;
	}


	public synchronized int getGroupNumber(){
		return this.groupNumber;
	}


	public synchronized boolean getTakingStudents(){
		return this.takingStudents;
	}

	public void setClearToParade(){
		this.clearToParade = true;
	}

	public boolean getClearToParade(){
		return clearToParade;
	}

	public synchronized void blueStudentJoinGroup(BlueStudent b){
		if(this.takingStudents && !blueStudentFilled){
			studentCount++;
			this.blueStudent = b;
			this.blueStudentFilled = true;
			blueStudent.setInGroup(this);
			blueStudent.setGroupAssigned(true);
			if(studentCount > 2){
				this.takingStudents = false;
				//@this.parade();
			}
		}
	}
	public synchronized void orangeStudentJoinGroup(OrangeStudent o){
		if(this.takingStudents && (this.orangeStudentList.size()) < 2){
			studentCount++;
			this.orangeStudentList.add(o);
			o.setInGroup(this);
			o.setGroupAssigned(true);
			if(studentCount > 2){
				this.takingStudents = false;
				//@this.parade();
			}
		}
	}

	public synchronized void parade(){
		// notify waiting students and set takingStudents true
		while(!clearToParade){
			try{
			wait();
		}
		catch(InterruptedException ie){}
		}
	}

	public synchronized void signalToParade(){
		this.takingStudents = true;
		this.blueStudentFilled = false;
		this.studentCount = 0;
		this.clearToParade = true;
		Random rNumber = new Random();
		int low = 3000;
		int high = 5000;
		int sleepTime = rNumber.nextInt(high - low) + low;
		// Set parade duration
		this.blueStudent.setParadeDuration(sleepTime);

		Iterator<OrangeStudent> orangeStudentIter = this.orangeStudentList.iterator();
		while(orangeStudentIter.hasNext()){
			OrangeStudent os = orangeStudentIter.next();
			os.setParadeDuration(sleepTime);
		}
		notifyAll();
		//sleep same amount as students?
	}
}
