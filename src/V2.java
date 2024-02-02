import java.io.*;
import java.util.*;
import java.math.*;

public class V2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/v.in"))));

        ArrayList<Integer> x1s = new ArrayList<>();
        ArrayList<Integer> x2s = new ArrayList<>();
        ArrayList<Integer> y1s = new ArrayList<>();
        ArrayList<Integer> y2s = new ArrayList<>();
        ArrayList<Integer> z1s = new ArrayList<>();
        ArrayList<Integer> z2s = new ArrayList<>();
        ArrayList<Integer> oos = new ArrayList<>();
        TreeSet<Integer> xs = new TreeSet<>();
        TreeSet<Integer> ys = new TreeSet<>();
        TreeSet<Integer> zs = new TreeSet<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int num = 0;
            if (s.split(" ")[0].equals("on"))
                num = 1;
            s = s.split(" ")[1];
            String[] three = s.split(",");
            int x1 = Integer.parseInt(three[0].substring(2, three[0].indexOf('.')));
            int x2 = Integer.parseInt(three[0].substring(three[0].lastIndexOf('.') + 1));
            int y1 = Integer.parseInt(three[1].substring(2, three[1].indexOf('.')));
            int y2 = Integer.parseInt(three[1].substring(three[1].lastIndexOf('.') + 1));
            int z1 = Integer.parseInt(three[2].substring(2, three[2].indexOf('.')));
            int z2 = Integer.parseInt(three[2].substring(three[2].lastIndexOf('.') + 1));
            oos.add(num);
            x1s.add(x1);
            x2s.add(x2);
            y1s.add(y1);
            y2s.add(y2);
            z1s.add(z1);
            z2s.add(z2);
            xs.add(x1);
            xs.add(x2 + 1);
            ys.add(y1);
            ys.add(y2 + 1);
            zs.add(z1);
            zs.add(z2 + 1);
        }

        long ans = 0;
        for (int x : xs) {
            if (x == xs.last())
                continue;
            int xn = xs.higher(x);
            ArrayList<Integer> xp = new ArrayList<>();
            for (int i = 0; i < x1s.size(); ++i) {
                if (x1s.get(i) <= x && x <= x2s.get(i))
                    xp.add(i);
            }
            for (int y : ys) {
                if (y == ys.last())
                    continue;
                int yn = ys.higher(y);
                ArrayList<Integer> yp = new ArrayList<>();
                for (int i : xp) {
                    if (y1s.get(i) <= y && y <= y2s.get(i))
                        yp.add(i);
                }
                for (int z : zs) {
                    if (z == zs.last())
                        continue;
                    int zn = zs.higher(z);
                    long diff = xn - x;
                    diff *= yn - y;
                    diff *= zn - z;
                    int num = 0;
                    for (int i : yp) {
                        if (z1s.get(i) <= z && z <= z2s.get(i))
                            num = oos.get(i);
                    }
                    ans += num * diff;
                }
            }
            System.out.println(x);
        }

        System.out.println(ans);
    }
}