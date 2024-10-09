import java.io.FileWriter;

public class SearchEngineLogger {
    public static void main(String[] args) {
       try{
           FileWriter fileWriter = new FileWriter("log.txt");
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
