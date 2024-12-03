import java.util.*;

public class advent1p1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int total =1000;
        for (int i = 0; i < total; i++) {
            leftList.add(scan.nextInt());
            rightList.add(scan.nextInt());
        }

        // Sort both lists
        Collections.sort(leftList);
        Collections.sort(rightList);

        // Calculate total distance
        long totalDistance = 0;

        for(int i = 0; i<total;i++){
            totalDistance += Math.abs(leftList.get(i)-rightList.get(i));
        }

        System.out.println("Total distance: " + totalDistance);
    }
}