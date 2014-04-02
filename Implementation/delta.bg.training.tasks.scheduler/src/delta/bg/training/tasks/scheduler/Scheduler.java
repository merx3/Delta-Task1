package delta.bg.training.tasks.scheduler;

import java.util.LinkedList;

//import delta.bg.training.tasks.scheduler.Employee;

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
	}	
	
	public void interData(){ 

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
	}
	
	
	
	
	//	TODO: Task 4
	public void arrangeHours(int day){
		for (Employee emp : employees) {

		}
	}
	

	// TODO: Task 5
	

	
	// <Task 5 - TEMPORARY DATA>, for taksk 5, until task 3 is finished
	// should have used interfaces on the skeletion...
	private class EmployeeTemp {
		public int id = -1; 
		public int workHours = -1; 
		public int [] startHours;
		public int [] endHours;
		public int [] availbaleHours;
		public boolean [][] availableShifts;
		public int [][] workShifts;
		
		public EmployeeTemp(int workHours, int[] startHours, int[] endHours, 
				int[] availableHours, boolean[][] availableShifts, int[][] workShifts) {
			this.workHours = workHours;
			this.startHours = startHours;
			this.endHours = endHours;
			this.availbaleHours = availableHours;
			this.availableShifts = availableShifts;
			this.workShifts = workShifts;
		}
		
	}
	
	LinkedList <EmployeeTemp> employees = new LinkedList<EmployeeTemp>();
	
	// for 4 employees
	private void populateTempData(){ 
		int [] workHours = {48, 40, 52, 48};
     // can be workHours = {48, 44, 64, 56};
		int [][] startHours = new int[][]{			
		 // Day: 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
				{13,13,9, 0, 4, 0, 0, 7, 8, 9,10,11, 0, 0},
				{13,0, 9, 13,4, 0, 0, 7, 8, 0,10,11, 0, 0},
				{9, 9, 9, 9, 4, 0, 0, 7, 8, 9, 0,11, 0, 0},
				{9, 9, 9, 9, 4, 0, 0, 7, 8, 9,10,11, 0, 0},
		};
		int [][] endHours = new int[][]{
		 // Day: 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
				{1, 1, 2, 0, 4, 0, 0, 7, 8, 9,10,11, 0, 0},
				{1, 0, 2, 3, 4, 0, 0, 7, 8, 0,10,11, 0, 0},
				{1, 1, 2, 3, 4, 0, 0, 7, 8, 9, 0,11, 0, 0},
				{1, 1, 2, 3, 4, 0, 0, 7, 8, 9,10,11, 0, 0},
		};
		int [][] availbaleHours = new int[][]{
		 // Day: 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13},
		};
		boolean f = false, t = true;
		boolean [][][] availableShifts = new boolean[][][]{
		  // Day: 1,	 2,   	3,     4,     5,   	 6,     7,	   8,	  9,     10,    11,    12,    13,   14
				{{f,t}, {f,t}, {t,t}, {f,f}, {t,t}, {f,f}, {f,f}, {f,t}, {f,t}, {t,t}, {t,t}, {t,f}, {f,f}, {f,f} },
				{{f,t}, {f,f}, {t,f}, {f,t}, {t,t}, {f,f}, {f,f}, {f,t}, {t,t}, {f,f}, {t,t}, {t,t}, {f,f}, {f,f} },
				{{t,t}, {t,t}, {t,t}, {t,t}, {t,t}, {f,f}, {f,f}, {t,f}, {t,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f} },
				{{t,t}, {t,t}, {t,f}, {t,t}, {f,t}, {f,f}, {f,f}, {t,f}, {t,f}, {t,t}, {t,t}, {t,t}, {f,f}, {f,f} }
		};
		
		// TODO: Discuss with Joro why this isn't bool
		boolean [][][] workShifts = new boolean[][][]{
		  // Day: 1,	 2,   	3,     4,     5,   	 6,     7,	   8,	  9,     10,    11,    12,    13,   14
				{{f,t}, {f,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f}, {f,t}, {f,t}, {t,t}, {t,t}, {t,f}, {f,f}, {f,f} },
				{{f,t}, {f,f}, {t,f}, {f,t}, {t,f}, {f,f}, {f,f}, {f,t}, {t,f}, {f,f}, {t,t}, {t,t}, {f,f}, {f,f} },
				{{t,t}, {t,t}, {f,t}, {t,t}, {f,t}, {f,f}, {f,f}, {t,f}, {t,t}, {f,t}, {f,f}, {f,t}, {f,f}, {f,f} },
				{{t,f}, {t,t}, {t,f}, {t,t}, {f,t}, {f,f}, {f,f}, {t,f}, {t,f}, {t,t}, {f,f}, {f,t}, {f,f}, {f,f} }
//		 // Optimal solution example:
//		 // Day:  1,  	 2,   	3,     4,     5,   	 6,     7,	   8,	  9,     10,    11,    12,    13,   14
//				{{f,t}, {f,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f}, {f,t}, {f,t}, {t,t}, {t,t}, {t,f}, {f,f}, {f,f} },
//				{{f,t}, {f,f}, {t,f}, {f,t}, {t,f}, {f,f}, {f,f}, {f,t}, {t,t}, {f,f}, {t,t}, {t,t}, {f,f}, {f,f} },
//				{{t,t}, {t,t}, {t,t}, {t,t}, {t,t}, {f,f}, {f,f}, {t,f}, {t,t}, {f,t}, {f,f}, {t,t}, {f,f}, {f,f} },
//				{{t,f}, {t,t}, {t,f}, {t,t}, {f,t}, {f,f}, {f,f}, {t,f}, {t,f}, {t,t}, {t,t}, {f,t}, {f,f}, {f,f} }
		};


		//employees.add(new EmployeeTemp(workHours[1], startHours[1], endHours[1], availbaleHours[1],availableShifts[1], workShifts[1]));
	}
	// </Task 5 - TEMPORARY DATA>
	
	public void addMoreHours(int day){
		
		for (Employee employee : employees) {
			
		}
		
	}
	
	// TODO: Task 6
	public int rearrangeAveraging(){
		return -1;
	}
}
