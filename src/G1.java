import java.io.*;
import java.util.*;
import java.math.*;

public class G1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/g.in"))));

        int ans = 1000000000;
        String[] ss = sc.nextLine().split(",");
        int[] is = new int[ss.length];
        for (int i = 0; i < ss.length; ++i)
            is[i] = Integer.parseInt(ss[i]);
        for (int i = 0; i < 2000; ++i) {
            int aa = 0;
            for (int x : is)
                aa += Math.abs(x - i);
            ans = Math.min(ans, aa);
        }
        System.out.println(ans);
    }
}