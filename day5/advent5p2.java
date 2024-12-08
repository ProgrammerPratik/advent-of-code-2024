import java.util.ArrayList;
import java.util.Scanner;

public class advent5p2 {
    private static int[] convertToInt1(String inp){
        String[] parts = inp.split("\\|");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    private static int[] convertToInt2(String inp) {
        String[] parts = inp.split(",");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        return nums;
    }

    private static boolean mustComeAfter(int a, int b, ArrayList<int[]> xylist) {
        for (int[] xy : xylist) {
            if (xy[1] == a && xy[0] == b) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidOrder(int[] row, ArrayList<int[]> xylist) {
        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (mustComeAfter(row[i], row[j], xylist)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] reorderUpdate(int[] row, ArrayList<int[]> xylist) {
        int[] row2 = row.clone();
        for (int i = 0; i < row2.length; i++) {
            for (int j = 0; j < row2.length - 1; j++) {
                if (mustComeAfter(row2[j], row2[j+1], xylist)) {
                    int temp = row2[j];
                    row2[j] = row2[j+1];
                    row2[j+1] = temp;
                }
            }
        }
        return row2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> xylist = new ArrayList<>();

        while(sc.hasNextLine()){
            String rowInp = sc.nextLine();
            if(rowInp.isEmpty()){
                break;
            }
            xylist.add(convertToInt1(rowInp));
        }

        ArrayList<int[]> numslist = new ArrayList<>();
        while(sc.hasNextLine()){
            String rowInp = sc.nextLine();
            if(rowInp.isEmpty()){
                break;
            }
            numslist.add(convertToInt2(rowInp));
        }

        int sum = 0;

        for(int[] row : numslist){
            if (!isValidOrder(row, xylist)) {
                int[] reorderedRow = reorderUpdate(row, xylist);
                int mid = reorderedRow.length / 2;
                sum += reorderedRow[mid];
            }
        }

        System.out.println(sum);
    }
}