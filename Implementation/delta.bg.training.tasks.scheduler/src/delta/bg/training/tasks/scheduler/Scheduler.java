package delta.bg.training.tasks.scheduler;

import java.util.Collections;

import java.util.LinkedList;



public class Scheduler {
	// TODO: Task 3
	// declare private static variables: workdays , numWorkplaces , etc.
	private static boolean[] workdays;
	private static int numWorkplaces = 0;
	private static int numEmployees = 0;
	private static int workdayStart = 0;
	private static int workdayEnd = 0;
	private static int numShifts = 0;
	private static int hoursInShift = 0;
	private static int breakBetweenShifts = 0;
	private static int [] shiftStart;
	private static int[][][] occupiedWorkplace;
	private static LinkedList<Employee> employees;
	private static int minWorkHours = 0;
	private static int maxWorkHours = 0;
	
	// create get-ers and set-ers for every private variable.
	// Add necessary verifications for correct values on the set-ers
	// Use the variables ONLY with the get-ers and set-ers
	public static boolean[] getWorkdays() {
		return workdays;
	}

	// Check that workdays.length() == 7
	public static void setWorkdays(boolean[] workdays) {
		if (workdays.length == 7) {
			Scheduler.workdays = workdays;
		}
	}

	public static int getNumWorkplaces() {
		return numWorkplaces;
	}

	public static void setNumWorkplaces(int numWorkplaces) {
		if (numWorkplaces >= 1) {
			Scheduler.numWorkplaces = numWorkplaces;
		}
	}

	public static int getNumEmployees() {
		return numEmployees;
	}

	public static void setNumEmployees(int numEmployees) {
		if (numEmployees >= 1) {
			Scheduler.numEmployees = numEmployees;
		}
	}

	public static int getWorkdayStart() {
		return workdayStart;
	}

	// check that workdayStart > 0 && workdayStart < 24
	public static void setWorkdayStart(int workdayStart) {
		if (workdayStart > 0 && workdayStart < 24) {
			Scheduler.workdayStart = workdayStart;
		}
	}

	public static int getWorkdayEnd() {
		return workdayEnd;
	}

	// check that workdayEnd > 0 && workdayEnd < 24
	public static void setWorkdayEnd(int workdayEnd) {
		if (workdayEnd > 0 && workdayEnd < 24) {
			Scheduler.workdayEnd = workdayEnd;
		}
	}

	public static int getNumShifts() {
		return numShifts;
	}

	public static void setNumShifts(int numShifts) {
		if (numShifts >= 1) {
			Scheduler.numShifts = numShifts;
		}
	}

	public static int getHoursInShift() {
		return hoursInShift;
	}

	// also hoursInShift < 24 (or 8, but let's say 24)
	public static void setHoursInShift(int hoursInShift) {
		if (hoursInShift >= 1 && hoursInShift < 24) {
			Scheduler.hoursInShift = hoursInShift;
		}
	}

	public static int getBreakBetweenShifts() {
		return breakBetweenShifts;
	}

	// should be > 0 and < 24
	public static void setBreakBetweenShifts(int breakBetweenShifts) {
		if (breakBetweenShifts > 0 && breakBetweenShifts < 24) {
			Scheduler.breakBetweenShifts = breakBetweenShifts;
		}
	}
	

	public static int[] getShiftStart() {
		return shiftStart;
	}

	public static void setShiftStart(int[] shiftStart) {
		Scheduler.shiftStart = shiftStart;
	}

	public static int[][][] getOccupiedWorkplace() {
		return occupiedWorkplace;
	}

	public static void setOccupiedWorkplace(int[][][] occupiedWorkplace) {
		Scheduler.occupiedWorkplace = occupiedWorkplace;
	}

	public static LinkedList<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(LinkedList<Employee> employees) {
		Scheduler.employees = employees;
	}

	public static int getMinWorkHours() {
		return minWorkHours;
	}

	// check minWorkHours <= maxWorkHours only if maxWorkHours > 0
	public static void setMinWorkHours(int minWorkHours) {
		if (maxWorkHours > 0) {
			if (minWorkHours <= maxWorkHours) {
				Scheduler.minWorkHours = minWorkHours;
			}
		}
	}

	public static int getMaxWorkHours() {
		return maxWorkHours;
	}

	// maxWorkHours > minWorkHours (not >= 1)
	public static void setMaxWorkHours(int maxWorkHours) {
		if (maxWorkHours > minWorkHours && maxWorkHours <= 80) {
			Scheduler.maxWorkHours = maxWorkHours;
		}
	}
	
	// filename is the name of the Employee.in file. Task 2 
	// has the read functionality

	// entry point of the Scheduler
	public static void start() {
		//populateTempData(); // for task 5
		addMoreHours(3);
	}	
	
	/*public void interData(){ 

		int [][] availbaleHours = new int[][]{
		 		{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
		};
		boolean correct = true, wrong = false;
		boolean [][][] availableShifts = new boolean[][][]{
				{{wrong,correct}, {wrong,correct}, {correct,correct}, {wrong,wrong}, {correct,correct}, {wrong,wrong}, {wrong,wrong}, {wrong,correct}, {wrong,correct}, {correct,correct}, {correct,correct}, {correct,wrong}, {wrong,wrong}, {wrong,wrong} },
				{{wrong,correct}, {wrong,wrong}, {correct,wrong}, {wrong,correct}, {correct,correct}, {wrong,wrong}, {wrong,wrong}, {wrong,correct}, {correct,correct}, {wrong,wrong}, {correct,correct}, {correct,correct}, {wrong,wrong}, {wrong,wrong} },
				{{correct,correct}, {correct,correct}, {correct,correct}, {correct,correct}, {correct,correct}, {wrong,wrong}, {wrong,wrong}, {correct,wrong}, {correct,correct}, {wrong,correct}, {wrong,wrong}, {correct,correct}, {wrong,wrong}, {wrong,wrong} },
				{{correct,correct}, {correct,correct}, {correct,wrong}, {correct,correct}, {wrong,correct}, {wrong,wrong}, {wrong,wrong}, {correct,wrong}, {correct,wrong}, {correct,correct}, {correct,correct}, {correct,correct}, {wrong,wrong}, {wrong,wrong} }
		};

		
		boolean [][][] workShifts = new boolean[][][]{
				{{wrong,correct}, {wrong,correct}, {wrong,correct}, {wrong,wrong}, {correct,correct}, {wrong,wrong}, {wrong,wrong}, {wrong,correct}, {wrong,correct}, {correct,correct}, {correct,correct}, {correct,wrong}, {wrong,wrong}, {wrong,wrong} },
				{{wrong,correct}, {wrong,wrong}, {correct,wrong}, {wrong,correct}, {correct,wrong}, {wrong,wrong}, {wrong,wrong}, {wrong,correct}, {correct,wrong}, {wrong,wrong}, {correct,correct}, {correct,correct}, {wrong,wrong}, {wrong,wrong} },
				{{correct,correct}, {correct,correct}, {wrong,correct}, {correct,correct}, {wrong,correct}, {wrong,wrong}, {wrong,wrong}, {correct,wrong}, {correct,correct}, {wrong,correct}, {wrong,wrong}, {wrong,correct}, {wrong,wrong}, {wrong,wrong} },
				{{correct,wrong}, {correct,correct}, {correct,wrong}, {correct,correct}, {wrong,correct}, {wrong,wrong}, {wrong,wrong}, {correct,wrong}, {correct,wrong}, {correct,correct}, {wrong,wrong}, {wrong,correct}, {wrong,wrong}, {wrong,wrong} }
		};
	}*/
	//NO IDEA WHAT THIS METHOD IS DOING ... :( BUT I AM SURE, IT'S NOT WHAT WE WANTED
	
	
	
	
	//	TODO: Task 4
	//Jorkata in the house again :D
	public void arrangeHours(int day){
		LinkedList<Employee> employeesTemp = sortEmployeesByFreeTimeInDay(employees, day);//shte se opravi tova
		for(int i=0;i<numEmployees;i++){
			for(int j=0;j<numShifts;j++){
				enrollEmployee(employeesTemp.get(i), day, j);
				if(employeesTemp.get(i).getWorkShifts()[day][j] == i)
					break;
			}
		}
	}
	

	// TODO: Task 5
	

	
	 //<Task 5 - TEMPORARY DATA>, for taksk 5, until task 3 is finished
	// should have used interfaces on the skeletion...
//	private static boolean [] workdaysTemp;
//	private static int numWorkplacesTemp;
//	private static int numEmployeesTemp;
//	private static int workdayStartTemp;
//	private static int workdayEndTemp;
//	private static int numShiftsTemp;
//	private static int hoursInShiftTemp;
//	private static int breakBetweenShiftsTemp;
//	private static int [][][] occupiedWorkplaceTemp;
//	private static LinkedList <EmployeeTemp> employeesTemp = new LinkedList<EmployeeTemp>();
//	private static int minWorkHoursTemp;
//	private static int maxWorkHoursTemp;

	

	//LinkedList <EmployeeTemp> employees = new LinkedList<EmployeeTemp>();
	//GEORGI: tova mai ne trqbva da e taka??????? Imame ve4e podoben spisak, zatova go preimenuvam toq
	//LinkedList <EmployeeTemp> employees1 = new LinkedList<EmployeeTemp>(); ???

	
	// for 4 employees
//	private static void populateTempData(){ 
//		int [] workHours = {48, 40, 52, 48};
//     // can be workHours = {48, 44, 64, 56};
//		int [][] startHours = new int[][]{			
//		 // Day: 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
//				{13,13,9, 0, 9, 0, 0,13,13, 9, 9, 9, 0, 0},
//				{13,0, 9,13, 9, 0, 0,13, 9, 0, 9, 9, 0, 0},
//				{9, 9, 9, 9, 9, 0, 0, 9, 9, 9, 0, 9, 0, 0},
//				{9, 9, 9, 9,13, 0, 0, 9, 9, 9, 9, 9, 0, 0},
//		};
//		int [][] endHours = new int[][]{
//		 // Day: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14
//				{18,18,18, 0,18, 0, 0,18,18,18,18,13, 0, 0},
//				{18, 0,13,18,18, 0, 0,18,18, 0,18,18, 0, 0},
//				{18,18,18,18,18, 0, 0,13,18,18, 0,18, 0, 0},
//				{18,18,13,18,18, 0, 0,13,13,18,18,18, 0, 0},
//		};
//		int [][] availbaleHours = new int[][]{
//		 // Day: 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
//				{4, 4, 8, 0, 8, 0, 0, 4, 4, 8, 8, 4, 0, 0},
//				{4, 0, 4, 4, 8, 0, 0, 4, 8, 0, 8, 8, 0, 0},
//				{8, 8, 8, 8, 8, 0, 0, 4, 8, 4, 0, 8, 0, 0},
//				{8, 8, 4, 8, 4, 0, 0, 4, 4, 8, 8, 8, 0, 0},
//		};
//		// The available shifts are the shifts where he doesn't
//		boolean f = false, t = true;
//		boolean [][][] availableShifts = new boolean[][][]{
//		  // Day: 1,	 2,   	3,     4,     5,   	 6,     7,	   8,	  9,     10,    11,    12,    13,   14
//				{{f,t}, {f,t}, {t,t}, {f,f}, {t,t}, {f,f}, {f,f}, {f,t}, {f,t}, {t,t}, {t,t}, {t,f}, {f,f}, {f,f} },
//				{{f,t}, {f,f}, {t,f}, {f,t}, {t,t}, {f,f}, {f,f}, {f,t}, {t,t}, {f,f}, {t,t}, {t,t}, {f,f}, {f,f} },
//				{{t,t}, {t,t}, {t,t}, {t,t}, {t,t}, {f,f}, {f,f}, {t,f}, {t,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f} },
//				{{t,t}, {t,t}, {t,f}, {t,t}, {f,t}, {f,f}, {f,f}, {t,f}, {t,f}, {t,t}, {t,t}, {t,t}, {f,f}, {f,f} }
//		};
//		
//		// TODO: Discuss with Joro why this isn't bool
//		int [][][] workShifts = new int[][][]{
//		  // Day: 1,	 2,   	3,     4,     5,   	 6,     7,	   8,	  9,     10,    11,    12,    13,   14
//				{{0,1}, {0,1}, {0,2}, {0,0}, {1,1}, {0,0}, {0,0}, {0,1}, {0,1}, {1,1}, {1,1}, {1,0}, {0,0}, {0,0} },
//				{{0,2}, {0,0}, {1,0}, {0,1}, {2,0}, {0,0}, {0,0}, {0,2}, {1,0}, {0,0}, {2,2}, {2,1}, {0,0}, {0,0} },
//				{{1,3}, {1,2}, {0,3}, {1,2}, {0,2}, {0,0}, {0,0}, {1,0}, {2,2}, {0,2}, {0,0}, {0,2}, {0,0}, {0,0} },
//				{{2,0}, {2,3}, {2,0}, {2,3}, {0,3}, {0,0}, {0,0}, {2,0}, {3,0}, {2,3}, {0,0}, {0,3}, {0,0}, {0,0} }
////		 // Optimal solution example:
////		 // Day:  1,  	 2,   	3,     4,     5,   	 6,     7,	   8,	  9,     10,    11,    12,    13,   14
////				{{f,t}, {f,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f}, {f,t}, {f,t}, {t,t}, {t,t}, {t,f}, {f,f}, {f,f} },
////				{{f,t}, {f,f}, {t,f}, {f,t}, {t,f}, {f,f}, {f,f}, {f,t}, {t,t}, {f,f}, {t,t}, {t,t}, {f,f}, {f,f} },
////				{{t,t}, {t,t}, {t,t}, {t,t}, {t,t}, {f,f}, {f,f}, {t,f}, {t,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f} },
////				{{t,f}, {t,t}, {t,f}, {t,t}, {f,t}, {f,f}, {f,f}, {t,f}, {t,f}, {t,t}, {t,t}, {f,t}, {f,f}, {f,f} }
//		};
		
		// imame v tozi sluchai dni=14, broi na smenite = 2, mesta v smqna = 3
		// izpolzvam samo occupiedWorkplace, za tova ne inicializiram drugi promenlivi
//		numShiftsTemp = 2;
//		numWorkplacesTemp = 3;
//		occupiedWorkplaceTemp = new int[14][numShiftsTemp][numWorkplacesTemp];
//		for (int i = 0; i < workHours.length; i++) {
//			employeesTemp.add(new EmployeeTemp(i, workHours[i], startHours[i], endHours[i], availbaleHours[i],availableShifts[i], workShifts[i]));
//			for (int day = 0; day < workShifts[i].length; day++) { // the day (1-14, or in the arrray 0-13)
//				for (int shift = 0; shift < numShiftsTemp; shift++) { // the shift (1-2, or in the arrray 0-1)
//					if (workShifts[i][day][shift] != 0) {
//						int workPlaceNumber = workShifts[i][day][shift] - 1; // this is the work place number, which the student has
//						// i is the id of the employee
//						occupiedWorkplaceTemp[day][shift][workPlaceNumber] = i;
//					}
//				}
//			}
//		}
//	}
	// </Task 5 - TEMPORARY DATA>
	
	public static void addMoreHours(int day){
		// occupiedWorkplace[day][rabotna smqna][rabotno mqsto] 
		day--; // days array start from 0	WE SHOULD INPUT THE DAY AS IT IS INDEXED, SO THIS IS NOT NEEDED AND HAS TO BE DELETED
		for (int shift = 0; shift < numShifts; shift++) {
			addMoreHoursForShift(day, shift);
		}	
	}

	private static void addMoreHoursForShift(int day, int shift) {
		// find the workplaces in the current shift that are occupied
		int occupiedCount = 0;
		for (int workplace = 0; workplace < numWorkplaces; workplace++) {
			if (occupiedWorkplace[day][shift][workplace] != 0) {
				occupiedCount++;
			}
		}
		
		if (occupiedCount < numWorkplaces) {
			LinkedList<Employee> orderedByFreeTime = sortEmployeesByFreeTimeInDay(employees, day);
			for (int i =  orderedByFreeTime.size() - 1; i >= 0; i--) {
				Employee emp = orderedByFreeTime.get(i);
				if (emp.getWorkShifts()[day][shift] == 0 && emp.getAvailableShifts()[day][shift]) {
					enrollEmployee(emp, day, shift);
					addMoreHoursForShift(day,shift);
					break;
				}
			}
		}
	}
	
	private static void enrollEmployee(Employee employee, int day, int shift) {
		for (int workPlaceNum = 0; workPlaceNum < numWorkplaces; workPlaceNum++) { // the shift (1-2, or in the arrray 0-1)
			if (occupiedWorkplace[day][shift][workPlaceNum] == 0) {
				employee.getWorkShifts()[day][shift] = workPlaceNum + 1;
				occupiedWorkplace[day][shift][workPlaceNum] = employee.getId();
				return;
			}
		}
		
	}

	private static LinkedList<Employee> sortEmployeesByFreeTimeInDay(
			LinkedList<Employee> employees, int day) {
		int currentFreeHours, nextFreeHours;
		LinkedList<Employee> orderedEmployees = new LinkedList<Employee>(employees);
		for (int i = 0; i < orderedEmployees.size(); i++) {
			currentFreeHours = orderedEmployees.get(i).getAvailableHours()[day];
			for (int j = i + 1; j < orderedEmployees.size(); j++) {
				nextFreeHours = orderedEmployees.get(j).getAvailableHours()[day];
				if (currentFreeHours > nextFreeHours) {
					Employee swap = orderedEmployees.get(i);
					orderedEmployees.set(i, orderedEmployees.get(j));
					orderedEmployees.set(j, swap);
					currentFreeHours = nextFreeHours;
				}
			}
		}
		return orderedEmployees;
	}

	// TODO: Task 6
	/*public int rearrangeAveraging(){
		boolean[] workdays = Employee.workdays;

		//Promenliva, s chiyato pomosht shte prebroya rabotnite dni.
		int workdaysCounter = 0;		
		int[][][] occupiedWorkplaces = Employee.occupiedWorkplaces;

		//Prebroyavame rabotnite dni.
		for(int i = 0; i < numEmployees; i++){
			if(workdays[i]==true){
				workdaysCounter++;
			}
		}		

		//Formula za sreden broy rabotni chasove.
		int averageWeeklyHours = (workdaysCounter*numShifts*hoursInShift*numWorkplaces)/numEmployees;
		int shifts = 0;

		//Masiv, koito pomni rabotnite chasove na stazhantite.
		int[] employeesWorkHours = new int[numEmployees];

		//Namiram rabotnite chasove na vseki stazhant ot broya na smenite v occupiedWorkplace i gi vkarvam v masiv.
		for(int empl = 0; empl < numEmployees;empl++){
			for(int day = 0; day < 14;day++){
			
				shifts = shifts + occupiedWorkplaces[day][empl][0];
				
			}
		shifts = shifts*hoursInShift;
		employeesWorkHours[empl] = shifts;
		shifts = 0;
		}
		return -1;
	}*/
	
	//Task6 : Georgi
	public void rearrangeAveraging(){
		int countWorkDays=0;
		int i,j;
		for(i=0;i<7;i++){
			if(workdays[i]){
				countWorkDays++;
			}
		}
		countWorkDays *= 2; //Vsichki izchislenia sa ni za 2-te sedmici ednovremenno
		final double averageWorkHours = ( countWorkDays * numShifts * hoursInShift * numWorkplaces )/numEmployees ;
		int indexOfEmployeeWithMinHours = 0;
		int indexOfEmployeeWithMaxHours = numEmployees - 1;
		int result = -1;
		int countAvailableShifts = 0;
		boolean [][] tmpAvailableShifts = null;
		while(true){
			Collections.sort(employees);
			if((employees.get(indexOfEmployeeWithMinHours).getWorkHours() + hoursInShift) <= averageWorkHours){
				while(true){
					if((employees.get(indexOfEmployeeWithMaxHours).getWorkHours() - hoursInShift) >= averageWorkHours){
						result = exchangeHours(indexOfEmployeeWithMinHours, indexOfEmployeeWithMaxHours);
						if(result!=0){
							indexOfEmployeeWithMaxHours--;
						}
						else
							break;
					}
					else
						break;
				}
				tmpAvailableShifts = employees.get(indexOfEmployeeWithMinHours).getAvailableShifts();
				for(i=0; i<14; i++)
					for(j=0; j<numShifts;j++)
						if(tmpAvailableShifts[i][j])
							countAvailableShifts++;
				if(countAvailableShifts * hoursInShift < averageWorkHours)
					indexOfEmployeeWithMinHours++;
				else
					break;
			}
			else
				break;
		}
	}
	
	public int exchangeHours(int indexOfRecipient, int indexOfDonor){
		int i,j;
		boolean [][] tmpAvailableShiftsRecipient = employees.get(indexOfRecipient).getAvailableShifts();
		int [][] tmpWorkShiftsRecipient = employees.get(indexOfRecipient).getWorkShifts();
		int [][] tmpWorkShiftsDonor = employees.get(indexOfDonor).getWorkShifts();
		for(i=0;i<14;i++){
			for(j=0;j<numShifts;j++){
				if(tmpAvailableShiftsRecipient[i][j] && (tmpWorkShiftsRecipient[i][j]==0) && (tmpWorkShiftsDonor[i][j]>0)){
					tmpWorkShiftsRecipient[i][j] = tmpWorkShiftsDonor [i][j];
					tmpWorkShiftsDonor[i][j] = 0;
					return 0;
				}
			}
		}
		return 1;
	}
}



// <TEMPORARY DATA FOR TASK 5>
//class EmployeeTemp {
//	public int id; 
//	public int workHours = -1; 
//	public int [] startHours;
//	public int [] endHours;
//	public int [] availbaleHours;
//	public boolean [][] availableShifts;
//	public int [][] workShifts;
//	
//	public EmployeeTemp(int id, int workHours, int[] startHours, int[] endHours, 
//			int[] availableHours, boolean[][] availableShifts, int[][] workShifts) {
//		this.id = id;
//		this.workHours = workHours;
//		this.startHours = startHours;
//		this.endHours = endHours;
//		this.availbaleHours = availableHours;
//		this.availableShifts = availableShifts;
//		this.workShifts = workShifts;
//	}			
//}	
// <//TEMPORARY DATA FOR TASK 5>
