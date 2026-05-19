package BMS;

public interface FileIOLogbook {
   public void saveRecordToFile(String date, String timeIn, String timeOut, String duration);
   public void readRecordFromFile();
}