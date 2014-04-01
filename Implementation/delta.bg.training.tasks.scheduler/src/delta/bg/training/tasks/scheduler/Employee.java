package delta.bg.training.tasks.scheduler;

public class Employee {
	// TODO: Task 1
	// declare private variables: id, workHours, etc.
	
	// create get-ers and set-ers for every private variable.
	// Add necessary verifications for correct values on the set-ers
	// Use the variables ONLY with the get-ers and set-ers
	
	
	// filename is the name of the Employee.in file. Task 2 
	// has the read functionality
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
			fileWriter.println("Monday "+this.workShifts[0][1]);
			fileWriter.println("Tuesday "+this.workShifts[1][1]);
			fileWriter.println("Wednesday "+this.workShifts[2][1]);
			fileWriter.println("Thirsday "+this.workShifts[3][1]);
			fileWriter.println("Friday "+this.workShifts[4][1]);
			fileWriter.println("Saturday "+this.workShifts[5][1]);
			fileWriter.println("Sunday "+this.workShifts[6][1]);
			fileWriter.println("Second Week");
			fileWriter.println("Monday "+this.workShifts[7][1]);
			fileWriter.println("Tuesday "+this.workShifts[8][1]);
			fileWriter.println("Wednesday "+this.workShifts[9][1]);
			fileWriter.println("Thirsday "+this.workShifts[10][1]);
			fileWriter.println("Friday "+this.workShifts[4][11]);
			fileWriter.println("Saturday "+this.workShifts[12][1]);
			fileWriter.println("Sunday "+this.workShifts[13][1]);

		}
		catch (FileNotFoundException fnf) { System.out.println("File not found!"); return 1;}
		catch (UnsupportedEncodingException un) { System.out.println("Unsupported Encoding!"); return 1;}
		fileWriter.close();
		return 0;	
	}
}
