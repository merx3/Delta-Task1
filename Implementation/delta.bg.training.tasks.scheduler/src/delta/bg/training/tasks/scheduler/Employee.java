package delta.bg.training.tasks.scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Scanner;

public class Employee implements Comparable<Employee>{
	// TODO: Task 1
	// declare private variables: id, workHours, etc.
	
	// create get-ers and set-ers for every private variable.
	// Add necessary verifications for correct values on the set-ers
	// Use the variables ONLY with the get-ers and set-ers
	
	
	// filename is the name of the Employee.in file. Task 2 
	// has the read functionality
	
	//GEORGI: dobavil sum workHours, s cel da testvam dali raboti sortiraneto
	private int workHours;

	public int compareTo(Employee em) {
		if(this.workHours > em.workHours) return 1; //tuk moje da trqbva da e < znaka, ne sum siguren!
		else return 0;
	}
	
	
	public Employee(int id, String filename) {
	}
	
	// TODO: Task 2
	public int readEmployeeDataFromFile(String filename){
		int counter = 0,i=0;
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
						this.startHours[i] = Integer.parseInt(splitted[1]);
						this.endHours[i++] = Integer.parseInt(splitted[2]);
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
			fileWriter.printf("Hours scheduled for the two weeks:%d\n\n",this.workHours);
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
			fileWriter.printf("Second Week");
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
	public void printSpec(int position,PrintStream fileWriter)
			{
			for (int j = 1;j < this.workShifts[position].length;j++)
				{
					fileWriter.printf("%d ",j);
				}
			}

	

	
}
