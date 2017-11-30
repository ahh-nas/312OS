
public class Clock {
		
		private static int tick = 0;
		
		public static void execute() {
		
		}
		public static int getClock() {
			return tick;
		}
		public static int advancedClock() {
			return tick++;
		}
		public static void restartClock() {
			tick = 0;
		}

	}


