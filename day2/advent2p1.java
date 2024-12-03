import java.util.*;
public class advent2p1 {
    public static boolean checkOrder(String numStr){
        String[] nS = numStr.split(" ");
        List<Integer> updated = new ArrayList<>();

        int[] nums = new int[nS.length];
        for(int i = 0;i< nS.length;i++){
            nums[i] = Integer.parseInt(nS[i]);
        }
        boolean inc = true;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                updated.add(nums[i]);
                inc = false;
                break;
            }
        }
        boolean dec = true;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>=nums[i-1]){
                dec = false;
                break;
            }
        }
        return inc||dec;
    }
    public static boolean checkDiff(String numStr){
        String[] nS = numStr.split(" ");

        int[] nums = new int[nS.length];
        for(int i = 0;i< nS.length;i++){
            nums[i] = Integer.parseInt(nS[i]);
        }

        for(int i = 0;i<nums.length-1;i++){
            int diff = Math.abs(nums[i]-nums[i+1]);
            if(diff<1||diff>3){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        int total = 1000;
        for (int i =0;i<total;i++){
            list.add(sc.nextLine());
        }
        int totalSafes = 0;
        for (int i =0;i<total;i++){
            if(checkOrder(list.get(i))&&checkDiff(list.get(i))){
                totalSafes++;
            }
        }
        System.out.println(totalSafes);
    }
}
