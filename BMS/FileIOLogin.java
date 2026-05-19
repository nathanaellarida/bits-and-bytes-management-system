package BMS;

public interface FileIOLogin {
   public boolean searchUsernameAndPassword(String searchUsername);
   public boolean isCorrectPassword(String enteredPassword);
}