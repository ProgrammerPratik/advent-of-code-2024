import java.util.*;

public class advent1p2 {
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

        for(Integer num: leftList){
            int occ = Collections.frequency(rightList,num);
            totalDistance += (long) occ*num;
        }
        System.out.println("Total distance: " + totalDistance);
    }
}