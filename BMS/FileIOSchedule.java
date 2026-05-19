package BMS;

public interface FileIOSchedule {
   public void saveScheduleToFile(String event, String contest, String month, String day, String year);
   public void readSchedulesFromFile();
   public void deleteScheduleFromFile(String schedule);
   public void deleteAllSchedulesFromFile();
}