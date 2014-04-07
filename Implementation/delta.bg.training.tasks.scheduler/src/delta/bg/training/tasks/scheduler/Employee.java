package delta.bg.training.tasks.scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
//import java.util.Arrays;
import java.util.Scanner;

public class Employee implements Comparable<Employee>{
	// TODO: Task 1
	// declare private variables: id, workHours, etc.
	
	// create get-ers and set-ers for every private variable.
	// Add necessary verifications for correct values on the set-ers
	// Use the variables ONLY with the get-ers and set-ers
	
	
	// filename is the name of the Employee.in file. Task 2 
	// has the read functionality
	
	private int id;
	private int workHours;
	private int [] startHours;
	private int [] endHours;
	private int [] availableHours;
	private boolean [][] availableShifts;
	private int [][] workShifts;
	
	public Employee(int id, String filename) {
		if(id>0) this.id=id;
		else return;
		workHours=0;
		int res = readEmployeeDataFromFile(filename+id+".in");//filename = Employee, id=4, FILE: Employee4.in
		if(res != 0) System.out.println("Error!");
		availableHours = new int[14];
		availableShifts = new boolean[14][Scheduler.getNumShifts()];
		setDefaultWorkShifts();
		setAvailableHoursAndAvailableShifts();
		//printEmployeeData();
	}

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		if (id>=1){
			this.id = id;
		}
		else {
			System.out.println("Invalid ID number!");
		}
	}
	public int getWorkHours(){
		return this.workHours;
	}
	public void setWorkHours(int hours){
		if (hours>=0 && hours<=(14*8)){
			this.workHours = hours;
		}
		else if(hours<0){
			System.out.println("Work Hours cannot be negative!");
		}
		else{
			System.out.println("Work Hours cannot be more than the legal value!");
		}
	}
	public int[] getStartHours() {
		return startHours;
	}
	public void setStartHours(int[] startHours) {
		for(int startHour : startHours){
			if(startHour<0 || startHour>24){
				System.out.println("Hours are between 0 and 24!");
				return;
			}
		}
		this.startHours = startHours;
	}
	public int[] getEndHours() {
		return endHours;
	}
	public void setEndHours(int[] endHours) {
		for(int endHour : endHours){
			if(endHour<0 || endHour>24){
				System.out.println("Hours are between 0 and 24!");
				return;
			}
		}
		this.endHours = endHours;
	}
	public int[] getAvailableHours() {
		return availableHours;
	}
	public void setAvailableHours(int[] availableHours) {
		for(int availableHour : availableHours){
			if(availableHour<0 || availableHour>24){
				System.out.println("Hours are between 0 and 24!");
				return;
			}
		}
		this.availableHours = availableHours;
	}
	public boolean[][] getAvailableShifts() {
		return availableShifts;
	}
	public void setAvailableShifts(boolean[][] availableShifts) {
		this.availableShifts = availableShifts;
	}
	public int[][] getWorkShifts() {
		return workShifts;
	}
	public void setWorkShifts(int[][] workShifts) {
		this.workShifts = workShifts;
	}
	public void setDefaultWorkShifts(){
		this.workShifts = new int[14][Scheduler.getNumShifts()];
		for(int i=0;i<14;i++)
			for(int j=0;j<Scheduler.getNumShifts();j++)
				this.workShifts[i][j]=0;
	}
	
	public void setAvailableHoursAndAvailableShifts(){
		int [] shiftStartTmp = Scheduler.getShiftStart();
		for(int i=0;i<14;i++){
			availableHours[i] = (endHours[i] - startHours[i]);
			for(int j=0;j<Scheduler.getNumShifts();j++){
				if(startHours[i] <= shiftStartTmp[j] && endHours[i] >= (shiftStartTmp[j] + Scheduler.getHoursInShift()))
					availableShifts[i][j] = true;
				else
					availableShifts[i][j] = false;
			}
		}
	}
	
	
	// TODO: Task 2
	public int readEmployeeDataFromFile(String filename){
		int counter = 0;
		int i=0;
		this.startHours = new int [14];
		this.endHours = new int [14];
		File file;
		Scanner reader;
		try{
		file  = new File(filename);
		reader = new Scanner(file,"windows-1251");
		while (reader.hasNext())
			{
				String s = reader.nextLine();
				if (counter!=0&&counter%9!=0)
				{
					if (s.isEmpty()==false)
					{
						String[] splitted = s.split("[ ]");
						if(splitted.length == 1){//if the employee is unavailable in this day
							this.startHours[i] = 0;
							this.endHours[i++] = 0;
						}
						else{
							this.startHours[i] = Integer.parseInt(splitted[1]);
							this.endHours[i++] = Integer.parseInt(splitted[2]);
						}
					}
				}
				counter++;
			}
		}
		catch (FileNotFoundException fnf) { System.out.println("File not found!"); return 1;}
		reader.close();
		return 0;
	}

	public int writeEmployeeScheduleToFile(String filename){
	PrintStream fileWriter;
		try{
			fileWriter = new PrintStream(filename,"windows-1251");
			fileWriter.printf("Hours scheduled for the two weeks: %d",this.workHours);
			fileWriter.println();
			fileWriter.println("First Week");
			fileWriter.printf("Monday ");
			printSpec(0,fileWriter);
			fileWriter.println();
			fileWriter.printf("Tuesday ");
			printSpec(1,fileWriter);
			fileWriter.println();
			fileWriter.printf("Wednesday ");
			printSpec(2,fileWriter);
			fileWriter.println();
			fileWriter.printf("Thirsday ");
			printSpec(3,fileWriter);
			fileWriter.println();
			fileWriter.printf("Friday ");
			printSpec(4,fileWriter);
			fileWriter.println();
			fileWriter.printf("Saturday ");
			printSpec(5,fileWriter);
			fileWriter.println();
			fileWriter.printf("Sunday ");
			printSpec(6,fileWriter);
			fileWriter.println();
			fileWriter.println("Second Week");
			fileWriter.printf("Monday ");
			printSpec(7,fileWriter);
			fileWriter.println();
			fileWriter.printf("Tuesday ");
			printSpec(8,fileWriter);
			fileWriter.println();
			fileWriter.printf("Wednesday ");
			printSpec(9,fileWriter);
			fileWriter.println();
			fileWriter.printf("Thirsday ");
			printSpec(10,fileWriter);
			fileWriter.println();
			fileWriter.printf("Friday ");
			printSpec(11,fileWriter);
			fileWriter.println();
			fileWriter.printf("Saturday ");
			printSpec(12,fileWriter);
			fileWriter.println();
			fileWriter.printf("Sunday ");
			printSpec(13,fileWriter);
			fileWriter.println();

		}
		catch (FileNotFoundException fnf) { System.out.println("File not found!"); return 1;}
		catch (UnsupportedEncodingException un) { System.out.println("Unsupported Encoding!"); return 1;}
		fileWriter.close();
		return 0;
	}
	public void printSpec(int day,PrintStream fileWriter){
		for (int i = 0;i < Scheduler.getNumShifts(); i++){
			if(this.workShifts[day][i] > 0){
				fileWriter.printf("%d ",i+1);
			}
		}
	}
	
	public int compareTo(Employee em) {
		if(this.workHours > em.workHours) return 1; //tuk moje da trqbva da e < znaka, ne sum siguren!
		else return 0;
	}

	public void printEmployeeData() {//tmp method for printing all the employee's fields
		System.out.println(id);
		System.out.println(workHours);
//		Arrays.toString(startHours);
//		Arrays.toString(endHours);
//		Arrays.toString(availableHours);
//		for(int i=0;i<14;i++){
//			for(int j=0;j<Scheduler.getNumShifts();j++){
//				System.out.print(availableShifts[i][j] +" ");
//				System.out.println(workShifts[i][j]);
//			}
//		}
	}
	

	
}
