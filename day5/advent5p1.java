import java.util.ArrayList;
import java.util.Scanner;

public class advent5p1 {

    private static int[] convertToInt1(String inp){
        String[] parts = inp.split("\\|");
        return new int[]{Integer.parseInt(parts[0]),Integer.parseInt(parts[1])};
    }
    private static int[] convertToInt2(String inp) {
        String[] parts = inp.split(",");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        return nums;
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
            boolean valid = true;
            for(int[] xy: xylist){
                int x = xy[0],y = xy[1];
                int posx = -1, posy = -1;

                for(int i = 0;i<row.length;i++){
                    if(row[i]==x){
                        posx = i;
                    }if(row[i]==y){
                        posy = i;
                    }
                }

                if(posx!=-1&&posy!=-1&&posx>posy){
                    valid = false;
                    break;
                }
            }
            if(valid){
                int mid = row.length/2;
                sum+=row[mid];
            }
        }
        System.out.println(sum);
    }
}
