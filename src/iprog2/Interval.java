package iprog2;

/* ************ HOW TO USE **************
 * 
 * new Interval(canvas, 2000,5).start(); -> 2000ms pauses. 5 iterations
 * new Interval(canvas, 4000,null).start(); -> 4000ms pauses. infinite iterations (DEFAULT)
 * new Interval(canvas, null,null).start(); -> 1000ms (DEFAULT) pauses. infinite iterations (DEFAULT)
 * 
 * ************************************/

public class Interval extends Thread {
	
	private Integer repetitions;
	private int timeToSleep = _CONFIG.DEFAULT_INTERVAL_PAUSE_IN_MILLIS;

	// If you don't want to specify timeToSleep or repetitions, use null instead. 
	// default values will be used (defined in _CONFIG)

	public Interval( Integer timeToSleep, Integer repetitions) {
		this.setDaemon(true);
		
		// if Time to sleep is null, default value (DEFINED in _CONFIG class will be picked)  
		if (timeToSleep!=null) 
			this.timeToSleep = timeToSleep;
		else 
			this.timeToSleep = _CONFIG.DEFAULT_INTERVAL_PAUSE_IN_MILLIS;

		// if repetitions to sleep is null, default value (DEFINED in _CONFIG class will be picked)
		if (repetitions!=null) 	
			this.repetitions = repetitions;
		else 
			this.repetitions = _CONFIG.DEFAULT_INTERVAL_REPETITIONS;
	}


	public void run(){
			if (repetitions==null) {
				while (true){
					sequenceOfActions();
				}
			} else {
				for (int i=0; i<repetitions; i++) {
					sequenceOfActions();
				}
			}

	}
	
	protected void sequenceOfActions() {
		try {
			// This is the sequence of Actions that is taking place for every iteration of our interval
			actualActionsBefore();
			sleep(timeToSleep);
			actualActionsAfter();
			
		} catch (InterruptedException e) {
			System.out.println("sleep interrupted");
			e.printStackTrace();
		}
	}
	protected void actualActionsBefore() {
		System.out.println("actions before sleeping..");
	}
	protected void actualActionsAfter() {
		System.out.println("actions after sleeping");
	}

	
	
}
