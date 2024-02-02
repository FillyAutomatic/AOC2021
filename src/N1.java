import java.io.*;
import java.util.*;
import java.math.*;

public class N1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/n.in"))));

        String s = sc.nextLine();
        sc.nextLine();
        HashMap<String, String> hm = new HashMap<>();
        while (sc.hasNextLine()) {
            String s2 = sc.nextLine();
            hm.put(s2.substring(0, 2), s2.substring(s2.length() - 1));
        }
        for (int i = 0; i < 10; ++i) {
            String s2 = "" + s.charAt(0);
            for (int j = 1; j < s.length(); ++j) {
                if (hm.containsKey("" + s.charAt(j - 1) + s.charAt(j)))
                    s2 += hm.get("" + s.charAt(j - 1) + s.charAt(j));
                s2 += s.charAt(j);
            }
            s = s2;
        }
        int[] cts = new int[256];
        for (char c : s.toCharArray())
            cts[c]++;
        int min = 1000000;
        int max = 0;
        for (int x : cts) {
            if (x > 0) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
        }

        System.out.println(max - min);
    }
}