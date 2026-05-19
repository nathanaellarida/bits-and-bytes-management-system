package BMS;

public abstract class FileIOBudgetPlanner {
   protected String filename;
   public abstract void writeToFile(String value);
   public abstract double readFromFile();
   
   public FileIOBudgetPlanner(String filename) {
      this.filename = filename;
   }
}