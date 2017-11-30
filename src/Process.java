
public class Process {
	
	public static String name;
	public String strings;
	
	public int bursttime;
	public int arrivaltime;
	public int waittime;
	public int completiontime;
	public int numberOfCycles;
	
	public String getStrings() {
		return strings;
	}

	public void setStrings(String strings) {
		this.strings = strings;
	}
	public Process(String name) {
		
		this.numberOfCycles = numberOfCycles;
		this.name = name;
		this.strings = strings;
		
		
	}
	
	public int getNumberOfCycles() {
		return numberOfCycles;
	}
	public void setNumberOfCycles(int numberOfCycles) {
		this.numberOfCycles = numberOfCycles;
	}
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBursttime() {
		return bursttime;
	}
	public void setBursttime(int bursttime) {
		this.bursttime = bursttime;
	}
	public int getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(int arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public int getWaittime() {
		return waittime;
	}
	public void setWaittime(int waittime) {
		this.waittime = waittime;
	}
	public int getCompletiontime() {
		return completiontime;
	}
	public void setCompletiontime(int completiontime) {
		this.completiontime = completiontime;
	}
	
	
	
	
	
	
	
	
}
