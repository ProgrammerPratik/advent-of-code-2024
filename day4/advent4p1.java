import java.util.ArrayList;
import java.util.Scanner;
// for some reason, you have to press enter 2 times after inputting testcase. might fix
public class advent4p1 {
    private static final int[][] DIR = {
            // all directions
            {-1,-1},//TL
            {-1,0}, //T
            {-1,1}, //TR
            {0,1},  //R
            {1,1},  //BR
            {1,0},  //B
            {1,-1}, //BL
            {0,-1}, //L
    };

    public static int counter(ArrayList<ArrayList<Character>> grid){
        int count = 0;
        int rows = grid.size();
        int cols = grid.get(0).size();

        for(int r = 0;r<rows;r++){
           for(int c = 0;c<cols;c++){
               for(int[] dir: DIR){
                   if(finder(grid,r,c,dir[0],dir[1])){
                       count++;
                   }
               }
           }
        }
        return count;
    }

    public static boolean finder(ArrayList<ArrayList<Character>> grid, int startr, int startc, int dR, int dC){
        String target = "XMAS";
        int rows = grid.size();
        int cols = grid.get(0).size();

        for(int i = 0;i<target.length();i++){
            int r = startr + i * dR;
            int c = startc + i * dC;

            if(r<0||r>=rows||c<0||c>=cols){
                return false;
            }

            if(grid.get(r).get(c)!=target.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        while(sc.hasNextLine()){
            String rowInp = sc.nextLine().toUpperCase();
            if(rowInp.isEmpty()){
                break;
            }
            ArrayList<Character> row = new ArrayList<>();
            for(char c: rowInp.toCharArray()){
                row.add(c);
            }
            grid.add(row);
        }
        System.out.println(counter(grid));
    }
}
