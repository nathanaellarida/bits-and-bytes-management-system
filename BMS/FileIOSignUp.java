package BMS;

public interface FileIOSignUp {
   public void createEmptyFile(String str);
   public boolean searchUsernameAndPassword(String searchUsername);
   public String checkAvailableId();
   public void write(String username, String password);
}