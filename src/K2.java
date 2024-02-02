import java.io.*;
import java.util.*;
import java.math.*;

public class K2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/k.in"))));

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
        for (int z = 0; z < 10000; ++z) {
            ans = 0;
            boolean[][] flashed = new boolean[n][m];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    vals[i][j]++;
                    if (vals[i][j] > 9) {
                        flashed[i][j] = true;
                        ++ans;
                        q.add(i * m + j);
                    }
                }
            }
            while (!q.isEmpty()) {
                int u = q.removeFirst();
                int uy = u / m;
                int ux = u % m;
                for (int a = -1; a <= 1; ++a) {
                    for (int b = -1; b <= 1; ++b) {
                        int vy = uy + a;
                        int vx = ux + b;
                        if (vy < 0 || vx < 0 || vy >= n || vx >= m || flashed[vy][vx])
                            continue;
                        ++vals[vy][vx];
                        if (vals[vy][vx] > 9) {
                            flashed[vy][vx] = true;
                            ++ans;
                            q.add(vy * m + vx);
                        }
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (flashed[i][j])
                        vals[i][j] = 0;
                }
            }
            if (ans == n * m) {
                System.out.println(z + 1);
                break;
            }
        }
        // System.out.println(ans);
    }
}