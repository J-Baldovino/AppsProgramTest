package application.model;

public class StageCounter {
		private static int stagec;

		public static int getStagec() {
			return stagec;
		}

		public static void setStagec(int stagec) {
			StageCounter.stagec = stagec;
		}
		
		public static void incrementStage()
		{
			stagec++;
		}
}