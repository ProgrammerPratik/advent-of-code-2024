import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class advent3p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for(int i =0;i<6;i++){
            list.add(sc.nextLine());
        }

        Pattern instructionPattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*\\)");

        boolean mul = true;
        long totalSum = 0;

        for(int i =0;i<6;i++){

            Matcher matcher = instructionPattern.matcher(list.get(i));
        while (matcher.find()) {
            String match = matcher.group();

            if(match.equals("do()")){
                mul = true;
            } else if (match.equals("don't()")){
                mul = false;
            } else if (match.startsWith("mul(")&&mul) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            totalSum += ((long) x * y);
            }
        }
        }

        System.out.println("Total sum: " + totalSum);
    }
}
