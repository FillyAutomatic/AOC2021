import java.io.*;
import java.util.*;
import java.math.*;

public class U2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/u.in"))));

        int p1s = 3;
        int p2s = 7;
        long[][][][][] dp = new long[43][21][21][11][11];
        dp[0][0][0][p1s][p2s] = 1;
        long p1w = 0;
        long p2w = 0;
        for (int r = 1; r <= 42; ++r) {
            for (int x = 0; x <= 20; ++x) {
                for (int y = 0; y <= 20; ++y) {
                    for (int p1 = 1; p1 <= 10; ++p1) {
                        for (int p2 = 1; p2 <= 10; ++p2) {
                            if (dp[r - 1][x][y][p1][p2] == 0)
                                continue;
                            long dpv = dp[r - 1][x][y][p1][p2];
                            for (int a = 1; a <= 3; ++a) {
                                for (int b = 1; b <= 3; ++b) {
                                    for (int c = 1; c <= 3; ++c) {
                                        int ta = a + b + c;
                                        int np1 = r % 2 == 0 ? p1 : p1 + ta;
                                        int np2 = r % 2 == 1 ? p2 : p2 + ta;
                                        np1 %= 10;
                                        np2 %= 10;
                                        if (np1 == 0)
                                            np1 = 10;
                                        if (np2 == 0)
                                            np2 = 10;
                                        int nx = r % 2 == 0 ? x : x + np1;
                                        int ny = r % 2 == 1 ? y : y + np2;
                                        if (nx >= 21) {
                                            p1w += dpv;
                                        } else if (ny >= 21) {
                                            p2w += dpv;
                                        } else {
                                            dp[r][nx][ny][np1][np2] += dpv;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(Math.max(p1w, p2w));
    }
}