package delta.bg.training.tasks.scheduler;

public class Main {
	// Start the application.
	public static void main(String[] args){
		for(Employee em : Scheduler.getEmployees()){
			em.writeEmployeeScheduleToFile("Employee" +em.getId() +".out");
		}
	}
}
