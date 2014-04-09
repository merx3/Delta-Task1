package delta.bg.training.tasks.scheduler;

public class Main {
	// Start the application.
	public static void main(String[] args){
		int i;
		for(i=0;i<7;i++){
			if(Scheduler.getWorkdays()[i]){
				Scheduler.arrangeHours(i);
				for(Employee em : Scheduler.getEmployees()){
					em.printEmployeeData();
				}
				System.out.println("DEN:"+i+" arrangeHours");
				Scheduler.arrangeHours(i+7);
				for(Employee em : Scheduler.getEmployees()){
					em.printEmployeeData();
				}
				System.out.println("DEN:"+(i+7)+" arrangeHours");
				Scheduler.addMoreHours(i);
				for(Employee em : Scheduler.getEmployees()){
					em.printEmployeeData();
				}
				System.out.println("DEN:"+i+" addMoreHours");
				Scheduler.addMoreHours(i+7);
				for(Employee em : Scheduler.getEmployees()){
					em.printEmployeeData();
				}
				System.out.println("DEN:"+(i+7)+" addMoreHours");
			}
		}
		Scheduler.rearrangeAveraging();
		Scheduler.dismissHours();
		for(Employee em : Scheduler.getEmployees()){
			em.printEmployeeData();
			em.writeEmployeeScheduleToFile("Employee" +em.getId() +".out");
		}
		for(int j=0;j<14;j++){
			for(int k=0;k<Scheduler.getNumShifts();k++){
				for(int l=0;l<Scheduler.getNumWorkplaces();l++){
					System.out.print("DAY: "+j);
					System.out.print(" SHIFT: " +k);
					System.out.print(" WORKPLACE: " +l);
					System.out.println("EMPLOYEE ID: " +Scheduler.getOccupiedWorkplace()[j][k][l]);
				}
			}
		}
	}
}
