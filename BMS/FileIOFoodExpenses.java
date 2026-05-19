package BMS;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileIOFoodExpenses extends FileIOBudgetPlanner {

   public FileIOFoodExpenses(String filename) {
      super(filename);
   }
   
   @Override
   public void writeToFile(String content) {
      try {
         FileWriter fileWriter = new FileWriter(super.filename);
         BufferedWriter writer = new BufferedWriter(fileWriter);
         writer.write(content);
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   @Override
   public double readFromFile() {
      double doubleValue = 0.0;
      try (BufferedReader reader = new BufferedReader(new FileReader(super.filename))) {
         String content = reader.readLine();
         doubleValue = Double.parseDouble(content);
      } catch (IOException | NumberFormatException e) {
         e.printStackTrace();
      }
      return doubleValue;
   }
}