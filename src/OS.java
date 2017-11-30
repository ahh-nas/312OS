import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


public class OS implements Runnable{
	public static int run = 0;
	private CountDownLatch latch;
	public static int inputOutput = 0;
	final static int maxMemory = 4096;
	public static int memoryUsage;
	public static int memoryLeft;
	private static int quantum = 10;
	 

	public static void main(String[] args) throws IOException 
	{
	List<Thread>threads = new ArrayList<Thread>();
	System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());
	for(int i =0; i<4; i++)
	{
		threads.add(new Thread());
	}
	System.out.println("Enter number of processes: ");
	Scanner userInput = new Scanner(System.in);
	int input = userInput.nextInt();
	int proceses[]= new int[0];
		System.out.println("Enter which scheduler you'd like to use" +"\n1:Round Robin" +"\n2:First Come First Serve" +"\n3:Shortest Job First");
		Scheduler newSched = new Scheduler();
		//TODO use the gui to pick which schduling alg. to use 
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		
		//GUI.getValues();
		//int b = GUI.getValue(a);
		switch(a) {
		case 1:
		newSched.RoundRobin(proceses, quantum, proceses.length);
		break;
		case 2:
		newSched.FirstComeFistServe(proceses);
		break;
		case 3:
		newSched.sjf(proceses);
		break;
		//BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        //String s = bufferRead.readLine();
		
		}
		newSched.jobHandle();
	}
	private ArrayList<String> queue = new ArrayList<>();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


public static int operationCycle()
{
	int cycles = (int)(Math.random()*25+25);
	return cycles;
}

public  static String state(String process, String state,String mem)
{
	
	switch (state.toUpperCase())
	{
	case "NEW":
		memoryUsage = Integer.parseInt(mem);
		memoryLeft = maxMemory - memoryUsage;
		if(memoryLeft <= maxMemory)
		{
			state = "READY";
			System.out.println("Memory left :"+memoryLeft);
		}
		else
			state = "WAIT";
		break;
	case "READY":
		return process;
	case "RUN":
		return process;
	case "WAIT":
		
		return process;
	case "BLOCKED":
		return process;
	case "EXIT":
		memoryUsage = Integer.parseInt(mem);
		memoryLeft +=  memoryUsage;
		System.out.println("Memory left :"+ memoryLeft);
		return process;
	default:
		System.out.println("Cannot do request\n");
	}
	String Error = ("Error");
	return Error;
	
}/*
public void Threads()
{
	Thread thread = new Thread(this);
	thread.start();
}
@Override
public void run() {
	// TODO Auto-generated method stub
	
}
 Error;
}*/
}



