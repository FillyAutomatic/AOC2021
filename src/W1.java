import java.io.*;
import java.util.*;
import java.math.*;

public class W1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/w.in"))));

        /*
         * long start = 15*19+18; start = (start*19+11)*19+13; start =
         * (start*19+12)*19+17; start = (start*19+14)*19+16;
         */

        long start = 13 * 19 + 16;
        start = (start * 19 + 14) * 19 + 15;
        start = (start * 19 + 11) * 19 + 18;
        start = (start * 19 + 12) * 19 + 17;

        long e = 11 * 19 + 15;
        e = (e * 19 + 12) * 19 + 16;
        e = (e * 19 + 13) * 19 + 17;
        e = (e * 19 + 14) * 19 + 18;
        long div = 1;
        for (int i = 0; i < 8; ++i)
            div *= 19;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(start);
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 19; ++i) {
            g.add(new ArrayList<>());
        }
        g.get(0).add(1);
        g.get(10).add(9);
        for (int i = 1; i <= 9; ++i) {
            g.get(i).add(i - 1);
            g.get(i).add(i + 1);
        }
        g.get(2).add(11);
        g.get(4).add(12);
        g.get(6).add(13);
        g.get(8).add(14);
        g.get(11).add(2);
        g.get(12).add(4);
        g.get(13).add(6);
        g.get(14).add(8);
        g.get(11).add(15);
        g.get(12).add(16);
        g.get(13).add(17);
        g.get(14).add(18);
        g.get(15).add(11);
        g.get(16).add(12);
        g.get(17).add(13);
        g.get(18).add(14);
        HashSet<Long> vis = new HashSet<>();
        while (!pq.isEmpty()) {
            long pq0 = pq.poll();
            long dist = pq0 / div;
            long rem = pq0 % div;
            if (vis.contains(rem))
                continue;
            vis.add(rem);
            if (rem == e) {
                System.out.println(dist);
                return;
            }

            int[] taken = new int[19];
            for (int i = 0; i < 19; ++i)
                taken[i] = -1;
            int[] us = new int[8];
            for (int i = 7; i >= 0; --i) {
                us[i] = (int) (rem % 19);
                rem /= 19;
                taken[us[i]] = i;
            }

            int imin = 0;
            int imax = 7;
            if (taken[2] > -1 || taken[4] > -1 || taken[6] > -1 || taken[8] > -1) {
                int i = Math.max(Math.max(taken[2], taken[4]), Math.max(taken[6], taken[8]));
                imin = i;
                imax = i;
            }
            for (int i = imin; i <= imax; ++i) {
                int u = us[i];
                for (int v : g.get(u)) {
                    if (taken[v] > -1)
                        continue;
                    if (v >= 11 && v <= 14 && u <= 10) {
                        if (v != 11 + i / 2)
                            continue;
                    }
                    int cost = 1000;
                    if (i == 5 || i == 4)
                        cost = 100;
                    if (i == 3 || i == 2)
                        cost = 10;
                    if (i == 1 || i == 0)
                        cost = 1;
                    long nd = dist + cost;
                    int[] vs = new int[8];
                    for (int j = 0; j < 8; ++j)
                        vs[j] = us[j];
                    vs[i] = v;
                    for (int j = 0; j < 8; j += 2) {
                        if (vs[j] > vs[j + 1]) {
                            int t = vs[j];
                            vs[j] = vs[j + 1];
                            vs[j + 1] = t;
                        }
                    }
                    long ta = 0;
                    for (int j = 0; j < 8; ++j) {
                        ta *= 19;
                        ta += vs[j];
                    }
                    if (vis.contains(ta))
                        continue;
                    pq.add(nd * div + ta);
                }
            }
        }
        System.out.println("PIKA");
    }
}