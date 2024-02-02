import java.io.*;
import java.util.*;
import java.math.*;

public class M2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/m.in"))));

        boolean[][] show = new boolean[2000][2000];
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty())
                break;
            show[Integer.parseInt(s.split(",")[0])][Integer.parseInt(s.split(",")[1])] = true;
        }
        while (sc.hasNextLine()) {
            String s = sc.nextLine().split(" ")[2];
            int div = Integer.parseInt(s.split("=")[1]);
            for (int i = 0; i < 2000; ++i) {
                for (int j = 0; j < 2000; ++j) {
                    int mi = s.charAt(0) == 'y' ? i : 2 * div - i;
                    int mj = s.charAt(0) == 'x' ? j : 2 * div - j;
                    if (mi < 0 || mj < 0)
                        continue;
                    if (show[i][j]) {
                        if (!show[mi][mj]) {
                            show[mi][mj] = true;
                        }
                        show[i][j] = false;
                    }
                }
            }
        }

        String ans = "";
        for (int i = 0; i < 40; ++i) {
            for (int j = 0; j < 40; ++j) {
                ans += show[j][i] ? "O" : ".";
            }
            ans += "\n";
        }

        System.out.println(ans);
    }
}