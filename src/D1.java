import java.io.*;
import java.util.*;
import java.math.*;

public class D1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/d.in"))));

        String[] first = sc.nextLine().split(",");
        ArrayList<ArrayList<ArrayList<Integer>>> boards = new ArrayList<>();
        while (sc.hasNextInt()) {
            ArrayList<ArrayList<Integer>> board = new ArrayList<>();
            for (int i = 0; i < 5; ++i) {
                board.add(new ArrayList<>());
                for (int j = 0; j < 5; ++j) {
                    board.get(i).add(sc.nextInt());
                }
            }
            boards.add(board);
        }
        for (String sx : first) {
            int x = Integer.parseInt(sx);
            for (int i = 0; i < boards.size(); ++i) {
                for (int j = 0; j < 5; ++j) {
                    for (int k = 0; k < 5; ++k) {
                        if (boards.get(i).get(j).get(k) == x)
                            boards.get(i).get(j).set(k, -1);
                    }
                }
                boolean fin = false;
                int d1 = 0;
                int d2 = 0;
                for (int j = 0; j < 5; ++j) {
                    int hs = 0;
                    int vs = 0;
                    for (int k = 0; k < 5; ++k) {
                        hs += boards.get(i).get(j).get(k);
                        vs += boards.get(i).get(k).get(j);
                    }
                    if (hs == -5 || vs == -5) {
                        fin = true;
                    }
                    d1 += boards.get(i).get(j).get(j);
                    d2 += boards.get(i).get(j).get(4 - j);
                }
                if (fin) {
                    int tot = 0;
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 0; k < 5; ++k) {
                            if (boards.get(i).get(j).get(k) > 0)
                                tot += boards.get(i).get(j).get(k);
                        }
                    }
                    System.out.println(tot * x);
                    return;
                }
            }
        }
    }
}