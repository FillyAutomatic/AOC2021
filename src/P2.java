import java.io.*;
import java.util.*;
import java.math.*;

public class P2 {
    static int cb = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/p.in"))));

        String s = sc.next();
        int[] bits = new int[s.length() * 4];
        cb = 0;
        for (char c : s.toCharArray()) {
            int num = c - '0';
            if (c > '9')
                num = (int) (c - 'A') + 10;
            bits[cb++] = num / 8;
            num -= num / 8 * 8;
            bits[cb++] = num / 4;
            num -= num / 4 * 4;
            bits[cb++] = num / 2;
            num -= num / 2 * 2;
            bits[cb++] = num;
        }
        cb = 0;
        System.out.println(parse(bits));
    }

    public static long parse(int[] bits) {
        int ver = bits[cb++];
        ver = ver * 2 + bits[cb++];
        ver = ver * 2 + bits[cb++];
        int type = bits[cb++];
        type = type * 2 + bits[cb++];
        type = type * 2 + bits[cb++];
        if (type == 4) {
            long val = 0;
            while (bits[cb++] == 1) {
                val = val * 2 + bits[cb++];
                val = val * 2 + bits[cb++];
                val = val * 2 + bits[cb++];
                val = val * 2 + bits[cb++];
            }
            val = val * 2 + bits[cb++];
            val = val * 2 + bits[cb++];
            val = val * 2 + bits[cb++];
            val = val * 2 + bits[cb++];
            return val;
        } else {
            ArrayList<Long> vals = new ArrayList<>();
            if (bits[cb++] == 1) {
                int nps = bits[cb++];
                for (int i = 0; i < 10; ++i)
                    nps = nps * 2 + bits[cb++];
                for (int i = 0; i < nps; ++i)
                    vals.add(parse(bits));
            } else {
                int lps = bits[cb++];
                for (int i = 0; i < 14; ++i)
                    lps = lps * 2 + bits[cb++];
                int ocb = cb;
                while (cb < ocb + lps) {
                    vals.add(parse(bits));
                }
            }
            if (type == 0) {
                long val = 0;
                for (long x : vals)
                    val += x;
                return val;
            } else if (type == 1) {
                long val = 1;
                for (long x : vals)
                    val *= x;
                return val;
            } else if (type == 2) {
                long val = 123456789012345678L;
                for (long x : vals)
                    val = Math.min(val, x);
                return val;
            } else if (type == 3) {
                long val = 0;
                for (long x : vals)
                    val = Math.max(val, x);
                return val;
            } else if (type == 5) {
                if (vals.get(0) > vals.get(1))
                    return 1;
                return 0;
            } else if (type == 6) {
                if (vals.get(0) < vals.get(1))
                    return 1;
                return 0;
            } else if (type == 7) {
                if (vals.get(0).equals(vals.get(1)))
                    return 1;
                return 0;
            }
            return 0L;
        }
    }
}