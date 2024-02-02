import java.io.*;
import java.util.*;
import java.math.*;

public class Y1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/y.in"))));

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
                if (lines.get(i).charAt(j) != '.')
                    vals[i][j] = lines.get(i).charAt(j) == '>' ? 1 : 2;
            }
        }
        for (int z = 1; true; ++z) {
            int ct = 0;
            int[][] nv = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (vals[i][j] == 1 && vals[i][(j + 1) % m] == 0) {
                        nv[i][j] = 0;
                        nv[i][(j + 1) % m] = 1;
                        ++ct;
                    } else {
                        nv[i][j] = nv[i][j] == 0 ? vals[i][j] : nv[i][j];
                    }
                }
            }
            vals = nv;
            nv = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (vals[i][j] == 2 && vals[(i + 1) % n][j] == 0) {
                        nv[i][j] = 0;
                        nv[(i + 1) % n][j] = 2;
                        ++ct;
                    } else {
                        nv[i][j] = nv[i][j] == 0 ? vals[i][j] : nv[i][j];
                    }
                }
            }
            vals = nv;
            if (ct == 0) {
                System.out.println(z);
                return;
            }
        }
    }
}