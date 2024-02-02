import java.io.*;
import java.util.*;
import java.math.*;

public class L1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/l.in"))));

        int ans = 0;
        HashMap<String, ArrayList<String>> g = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] two = sc.nextLine().split("-");
            if (!g.containsKey(two[0]))
                g.put(two[0], new ArrayList<>());
            if (!g.containsKey(two[1]))
                g.put(two[1], new ArrayList<>());
            g.get(two[0]).add(two[1]);
            g.get(two[1]).add(two[0]);
        }
        ArrayDeque<String> q = new ArrayDeque<>();
        q.add("start start");

        while (!q.isEmpty()) {
            String q0 = q.removeFirst();
            String u = q0.split(" ")[0];
            if (u.equals("end")) {
                ++ans;
                continue;
            }
            TreeSet<String> vis = new TreeSet<>();
            for (int i = 1; i < q0.split(" ").length; ++i)
                vis.add(q0.split(" ")[i]);
            for (String v : g.get(u)) {
                if (v.equals(v.toLowerCase()) && vis.contains(v))
                    continue;
                TreeSet<String> nts = (TreeSet<String>) vis.clone();
                if (v.equals(v.toLowerCase()))
                    nts.add(v);
                String ta = v;
                for (String s : nts)
                    ta += " " + s;
                q.add(ta);
            }

        }

        System.out.println(ans);
    }
}