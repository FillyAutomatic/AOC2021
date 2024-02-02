import java.io.*;
import java.util.*;
import java.math.*;

public class N2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/n.in"))));

        String s = sc.nextLine();
        sc.nextLine();
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, ArrayList<Integer>> hm20 = new HashMap<>();
        while (sc.hasNextLine()) {
            String s2 = sc.nextLine();
            hm.put(s2.substring(0, 2), s2.substring(s2.length() - 1));
        }
        for (String key : hm.keySet()) {
            String ok = key;
            for (int i = 0; i < 20; ++i) {
                StringBuilder key2 = new StringBuilder("" + key.charAt(0));
                for (int j = 1; j < key.length(); ++j) {
                    if (hm.containsKey("" + key.charAt(j - 1) + key.charAt(j)))
                        key2.append(hm.get("" + key.charAt(j - 1) + key.charAt(j)));
                    key2.append(key.charAt(j));
                }
                key = key2.toString();
            }
            int[] cts = new int[256];
            for (char c : key.toCharArray())
                cts[c]++;
            cts[key.charAt(0)]--;
            cts[key.charAt(key.length() - 1)]--;
            ArrayList<Integer> counts = new ArrayList<>();
            for (int x : cts)
                counts.add(x);
            hm20.put(ok, counts);
            System.out.println(ok);
        }
        for (int i = 0; i < 20; ++i) {
            StringBuilder s2 = new StringBuilder("" + s.charAt(0));
            for (int j = 1; j < s.length(); ++j) {
                if (hm.containsKey("" + s.charAt(j - 1) + s.charAt(j)))
                    s2.append(hm.get("" + s.charAt(j - 1) + s.charAt(j)));
                s2.append(s.charAt(j));
            }
            s = s2.toString();
            System.out.println(i);
        }
        long[] cts = new long[256];
        for (char c : s.toCharArray())
            cts[c]++;
        HashMap<String, Long> ct2 = new HashMap<>();
        for (int i = 1; i < s.length(); ++i) {
            if (!hm20.containsKey("" + s.charAt(i - 1) + s.charAt(i)))
                continue;
            ct2.put("" + s.charAt(i - 1) + s.charAt(i), ct2.getOrDefault("" + s.charAt(i - 1) + s.charAt(i), 0L) + 1);
            if (i % 100000 == 0)
                System.out.println(i + " " + s.length());
        }
        for (String ss : ct2.keySet()) {
            for (int j = 0; j < 256; ++j) {
                cts[j] += hm20.get(ss).get(j) * ct2.get(ss);
            }
        }
        long min = 1234567890123456L;
        long max = 0;
        for (long x : cts) {
            if (x > 0) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
        }

        System.out.println(max - min);
    }
}