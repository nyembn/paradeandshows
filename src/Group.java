import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Group{
	private int groupNumber;
	private BlueStudent blueStudent;
	private List<OrangeStudent> orangeStudentList;
	private boolean takingStudents;
	private int studentCount;
	private boolean clearToParade;
	private Object paradeLock;
	//*private boolean orangeFilled;
	private boolean blueStudentFilled;

	/*
	 *Concurrently accessed methods need to be synchronized since
	 *all student will try to join groups
	 */

	public synchronized Object getParadeLock(){
		return this.paradeLock;
	}


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

	/*public void setClearToParade(){
		this.clearToParade = true;
		this.parade();
	}
	*/

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

	/*public void parade(){
		// notify waiting students and set takingStudents true
		this.clearToParade = true;
		Random rNumber = new Random();
		int low = 3000;
		int high = 5000;
		int sleepTime = rNumber.nextInt(high - low) + low;
		//serParade time
		this.blueStudent.setParadeDuration(sleepTime);
		for(int i=0; i<this.orangeStudent.size(); i++)
			this.orangeStudent.get(i).setParadeDuration(sleepTime);
		//sleep same amount as students
		this.paradeLock.notifyAll();
		//sleep same amount as students
		this.takingStudents = true;
		this.studentCount = 0;
	}*/
}
