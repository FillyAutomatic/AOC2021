import java.io.*;
import java.util.*;
import java.math.*;

public class O1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/o.in"))));

        int ans = 0;
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.next());
        }
        int n = lines.size();
        int m = lines.get(0).length();
        int[][] vals = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                vals[i][j] = lines.get(i).charAt(j) - '0';
            }
        }
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = vals[n - 1][m - 1];
        for (int i = m - 2; i >= 0; --i) {
            dp[n - 1][i] = dp[n - 1][i + 1] + vals[n - 1][i];
        }
        for (int i = n - 2; i >= 0; --i) {
            dp[i][m - 1] = dp[i + 1][m - 1] + vals[i][m - 1];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + vals[i][j];
            }
        }

        System.out.println(dp[0][0] - vals[0][0]);
    }
}