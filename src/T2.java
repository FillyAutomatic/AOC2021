import java.io.*;
import java.util.*;
import java.math.*;

public class T2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/t.in"))));

        int ans = 0;
        String algo = sc.nextLine();
        sc.nextLine();
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.next());
        }
        int n = lines.size();
        int m = lines.get(0).length();
        int[][] vals = new int[n + 1000][m + 1000];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                vals[i + 500][j + 500] = lines.get(i).charAt(j) == '#' ? 1 : 0;
            }
        }
        for (int p = 0; p < 50; ++p) {
            int[][] v2 = new int[n + 1000][m + 1000];
            for (int i = 1; i < n + 999; ++i) {
                for (int j = 1; j < m + 999; ++j) {
                    int num = vals[i - 1][j - 1];
                    num <<= 1;
                    num += vals[i - 1][j];
                    num <<= 1;
                    num += vals[i - 1][j + 1];
                    num <<= 1;
                    num += vals[i][j - 1];
                    num <<= 1;
                    num += vals[i][j];
                    num <<= 1;
                    num += vals[i][j + 1];
                    num <<= 1;
                    num += vals[i + 1][j - 1];
                    num <<= 1;
                    num += vals[i + 1][j];
                    num <<= 1;
                    num += vals[i + 1][j + 1];
                    v2[i][j] = algo.charAt(num) == '#' ? 1 : 0;
                }
            }
            vals = v2;
        }
        for (int i = 0; i < n + 100; ++i) {
            for (int j = 0; j < m + 100; ++j) {
                ans += vals[i + 450][j + 450];
            }
        }

        System.out.println(ans);
    }
}