import java.io.*;
import java.util.*;
import java.math.*;

public class F1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/f.in"))));

        int ans = 0;
        int[] ct = new int[9];
        String[] s = sc.nextLine().split(",");
        for (String ss : s) {
            ct[ss.charAt(0) - '0']++;
        }
        for (int i = 0; i < 80; ++i) {
            int[] nct = new int[9];
            for (int j = 1; j < 9; ++j) {
                nct[j - 1] = ct[j];
            }
            nct[8] += ct[0];
            nct[6] += ct[0];
            ct = nct;
        }
        for (int i = 0; i < 9; ++i)
            ans += ct[i];
        System.out.println(ans);
    }
}