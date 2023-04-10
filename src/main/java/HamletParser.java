import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
    private String hamletData;
    private String replacement;
    private Pattern hamletPattern;
    private Matcher matcher;
    private StringBuilder sb;
    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHamletToLeon() {
        hamletPattern = Pattern.compile("Hamlet");
        matcher = hamletPattern.matcher(hamletData);
        sb = new StringBuilder();
        replacement = "Leon";
        while (matcher.find()){
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        hamletData = sb.toString();

        hamletPattern = Pattern.compile("HAMLET");
        matcher = hamletPattern.matcher(hamletData);
        sb = new StringBuilder();
        replacement = "LEON";
        while (matcher.find()){
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        hamletData = sb.toString();
    }

    public void changeHoratioToTariq() {
        hamletPattern = Pattern.compile("Horatio");
        matcher = hamletPattern.matcher(hamletData);
        sb = new StringBuilder();
        replacement = "Tariq";
        while (matcher.find()){
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        hamletData = sb.toString();

        hamletPattern = Pattern.compile("HORATIO");
        matcher = hamletPattern.matcher(hamletData);
        sb = new StringBuilder();
        replacement = "TARIQ";
        while (matcher.find()){
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        hamletData = sb.toString();
    }

    public int findHoratio() {
        Pattern hamletPattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = hamletPattern.matcher(hamletData);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
    public int findHamlet() {
        Pattern hamletPattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = hamletPattern.matcher(hamletData);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
}
