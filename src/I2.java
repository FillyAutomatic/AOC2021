import java.io.*;
import java.util.*;
import java.math.*;

public class I2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/i.in"))));

        long ans = 1;
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        int n = lines.size();
        int m = lines.get(0).length();
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<Integer> bs = new PriorityQueue<>();
        bs.add(-1);
        bs.add(-1);
        bs.add(-1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (vis[i][j] || lines.get(i).charAt(j) == '9')
                    continue;
                int num = 1;
                vis[i][j] = true;
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(i * 1000 + j);
                while (!q.isEmpty()) {
                    int u = q.removeFirst();
                    int uy = u / 1000;
                    int ux = u % 1000;
                    if (uy > 0 && !vis[uy - 1][ux] && lines.get(uy - 1).charAt(ux) != '9') {
                        q.add(u - 1000);
                        ++num;
                        vis[uy - 1][ux] = true;
                    }
                    if (uy < n - 1 && !vis[uy + 1][ux] && lines.get(uy + 1).charAt(ux) != '9') {
                        q.add(u + 1000);
                        ++num;
                        vis[uy + 1][ux] = true;
                    }
                    if (ux > 0 && !vis[uy][ux - 1] && lines.get(uy).charAt(ux - 1) != '9') {
                        q.add(u - 1);
                        ++num;
                        vis[uy][ux - 1] = true;
                    }
                    if (ux < m - 1 && !vis[uy][ux + 1] && lines.get(uy).charAt(ux + 1) != '9') {
                        q.add(u + 1);
                        ++num;
                        vis[uy][ux + 1] = true;
                    }
                }
                bs.add(-num);
            }
        }
        ans *= -bs.poll();
        ans *= -bs.poll();
        ans *= -bs.poll();

        System.out.println(ans);
    }
}