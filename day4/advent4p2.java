import java.util.ArrayList;
import java.util.Scanner;
public class advent4p2 {
    private static final int[][] DIR = {
            // only diagonal directions
            {-1,-1},//TL
//            {-1,0}, //T
            {-1,1}, //TR
//            {0,1},  //R
            {1,1},  //BR
//            {1,0},  //B
            {1,-1}, //BL
//            {0,-1}, //L
    };

    public static int counter(ArrayList<ArrayList<Character>> grid){
        int count = 0;
        int rows = grid.size();
        int cols = grid.get(0).size();

        for(int r = 1;r<rows-1;r++){
            for(int c = 1;c<cols-1;c++){
                if(grid.get(r).get(c) == 'A'){
                    StringBuilder s = new StringBuilder();
                    for(int[] dir: DIR){
                        s.append(grid.get(r+dir[0]).get(c+dir[1]));
                    }
                    String patter  = s.toString();
                    if(patter.equals("MMSS")||patter.equals("MSSM")||patter.equals("SSMM")||patter.equals("SMMS")){
                    count++;

                    }

                }
            }
        }
        return count;
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
