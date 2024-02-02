import java.io.*;
import java.util.*;
import java.math.*;

public class E2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/e.in"))));

        int[][] ct = new int[1001][1001];
        int ans = 0;
        while (sc.hasNext()) {
            String x = sc.next();
            int x1 = Integer.parseInt(x.split(",")[0]);
            int y1 = Integer.parseInt(x.split(",")[1]);
            sc.next();
            String y = sc.next();
            int x2 = Integer.parseInt(y.split(",")[0]);
            int y2 = Integer.parseInt(y.split(",")[1]);
            int dx = x2 - x1;
            int dy = y2 - y1;
            if (dx > 0)
                dx = 1;
            if (dx < 0)
                dx = -1;
            if (dy > 0)
                dy = 1;
            if (dy < 0)
                dy = -1;
            int xx = x1;
            int yy = y1;
            while (xx != x2 || yy != y2) {
                ct[xx][yy]++;
                xx += dx;
                yy += dy;
            }
            ct[xx][yy]++;
        }
        for (int i = 0; i <= 1000; ++i) {
            for (int j = 0; j <= 1000; ++j) {
                if (ct[i][j] > 1)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}