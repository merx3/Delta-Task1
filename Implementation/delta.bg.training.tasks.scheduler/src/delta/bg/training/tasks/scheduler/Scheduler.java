package delta.bg.training.tasks.scheduler;

import java.util.LinkedList;

import delta.bg.training.tasks.scheduler.Employee;

public class Scheduler {
	// TODO: Task 3
	// declare private static variables: workdays , numWorkplaces , etc.

	// create get-ers and set-ers for every private variable.
	// Add necessary verifications for correct values on the set-ers
	// Use the variables ONLY with the get-ers and set-ers
	
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
