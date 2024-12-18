import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class advent3p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.isEmpty()){
                break;
            }
            list.add(line);
        }

        Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        long totalSum = 0;
        for(int i = 0;i<list.size();i++){
            Matcher matcher = mulPattern.matcher(list.get(i));


            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                totalSum += ((long)x * y);
            }
        }

        System.out.println("Total sum: " + totalSum);
    }
}
