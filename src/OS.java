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
	final int maxMemory = 4096;
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
		int proceses[]= new int[input];
		System.out.println("Enter which scheduler you'd like to use" +"\n1:Round Robin" +"\n2:First Come First Serve" +"\n3:Shortest Job First");
		Scheduler newSched = new Scheduler();
		//TODO use the gui to pick which schduling alg. to use 
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		switch(a) {
		case 1:
		newSched.RoundRobin(proceses, quantum, proceses.length);
		break;
		case 2:
		newSched.FirstComeFistServe(proceses);
		break;
		//BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        //String s = bufferRead.readLine();
		}
	}
	private ArrayList<String> queue = new ArrayList<>();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

public void Process(String nameOfProcess,ArrayList<String> queueIn, int size)
{

memoryUsage = (int)(Math.random()*4096+1);
//Random rand = new Random();
memoryLeft = maxMemory - memoryUsage;
if(memoryUsage > memoryLeft)
 {
	System.out.println("Not enough space");
 }

	
}/*
public static int operationCycle()
{
	int cycles = (int)(Math.random()*25+25);
	return cycles;
}
public  static String state(String process)
{
	
	switch (process.toUpperCase())
	{
	case "NEW":
		return process;
	case "READY":
		return process;
	case "RUN":
		return process;
	case "WAIT":
		return process;
	case "BLOCKED":
		return process;
	case "EXIT":
		return process;
	default:
		System.out.println("Cannot do request\n");
	}
	String Error = ("Error");
	return Error;
	
}
public void Threads()
{
	Thread thread = new Thread(this);
	thread.start();
}
@Override
public void run() {
	// TODO Auto-generated method stub
	
}
/*public r userCommand(String command) 
{
	switch(command.toUpperCase())
	{
	case "CALCULATE":
		
		return command;
	case "OUT":
		return command;
	case "YIELD":
		return command;
	case "I/O":
		return command;
	default:
		System.out.println("Cannot do request\n");
	}
	String Error = ("Error");
	return Error;
}*/
}



