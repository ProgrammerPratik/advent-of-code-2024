import java.util.*;

public class advent6p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int ctr = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            if (line.contains("^")) {
                startRow = ctr;
                startCol = line.indexOf("^");
            }
            list.add(line);
            ctr++;
        }

        Set<String> visited = new HashSet<>();
        int currentRow = startRow;
        int currentCol = startCol;
        int direction = 0; // 0: up, 1: right, 2: down, 3: left

        visited.add(currentRow + "," + currentCol);

        while (true) {
            int nextRow = currentRow;
            int nextCol = currentCol;

            switch (direction) {
                case 0:
                    nextRow--;
                    break;
                case 1:
                    nextCol++;
                    break;
                case 2:
                    nextRow++;
                    break;
                case 3:
                    nextCol--;
                    break;
            }

            if (nextRow < 0 || nextRow >= list.size() ||
                    nextCol < 0 || nextCol >= list.get(0).length()) {
                break;
            }

            if (list.get(nextRow).charAt(nextCol) == '#') {
                direction = (direction + 1) % 4;
            } else {
                currentRow = nextRow;
                currentCol = nextCol;
                visited.add(currentRow + "," + currentCol);
            }
        }
        System.out.println(visited.size());
    }
}