
public class Clock {
		
		private static int tick = 0;
		
		
		public static int getClock() 
		{return tick;}
		
		public static void setClock(int t)
		{tick = t;}
		
		public static void advancedClock() 
		{tick++;}
		
		public static void restartClock() 
		{tick = 0;}

	}


