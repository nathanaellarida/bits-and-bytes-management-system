package BMS;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.nio.file.Files;

import java.text.DecimalFormat;

public class CreateEmptyFile {
   private static final String ID_FORMAT = "000";
   private static final String USERNAME_FORMAT = "                         ";
   private static final String PASSWORD_FORMAT = "                         ";
   private static final String delimiter = ",";
   private static String s = ID_FORMAT + delimiter + USERNAME_FORMAT + delimiter + PASSWORD_FORMAT + System.getProperty("line.separator");
   private static final int RECSIZE = s.length();
   private static final Path usersFile = Paths.get("C:\\Users\\DELL\\Documents\\02 - Projects\\Bits & Bytes Management System\\BMS\\users.txt");
   
   public static void main(String[] args) {
      final int NUMRECS = 100;
      try {
          OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(usersFile, CREATE));
          BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));

          writer.write("000,.\\admin                  ,admin                    " + System.getProperty("line.separator"), 0, s.length());
          for(int count = 0; count < NUMRECS; ++count)
              writer.write(s, 0, s.length());

          writer.close();
      } catch(Exception e) {
          System.out.println("Error message 3: " + e);
      }
   }
}