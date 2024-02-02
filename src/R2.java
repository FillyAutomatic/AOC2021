import java.io.*;
import java.util.*;
import java.math.*;

public class R2 {
    static class Snail {
        public int val;
        public int level;
        Snail left;
        Snail right;
        Snail parent;
        boolean isLeft;

        public Snail(String line, int level, Snail parent, boolean isLeft) {
            this.level = level;
            this.parent = parent;
            this.isLeft = isLeft;
            if (line.charAt(0) == '[') {
                line = line.substring(1, line.length() - 1);
            } else {
                val = Integer.parseInt(line);
                return;
            }
            int comma = -1;
            int ct = 0;
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == '[')
                    ++ct;
                if (line.charAt(i) == ']')
                    --ct;
                if (line.charAt(i) == ',' && ct == 0)
                    comma = i;
            }
            left = new Snail(line.substring(0, comma), level + 1, this, true);
            right = new Snail(line.substring(comma + 1), level + 1, this, false);
        }

        public Snail(Snail left, Snail right) {
            this.level = 0;
            this.isLeft = true;
            this.left = left;
            this.right = right;
            this.left.isLeft = true;
            this.right.isLeft = false;
            left.parent = this;
            right.parent = this;
            left.increment();
            right.increment();
            boolean didSplit = true;
            // System.out.println(this);
            while (didSplit) {
                explode();
                // System.out.println(this);
                didSplit = split();
                // System.out.println(this);
            }
        }

        public void increment() {
            level += 1;
            if (left != null)
                left.increment();
            if (right != null)
                right.increment();
        }

        public void explode() {
            if (level == 4 && left != null && right != null) {
                int lval = left.val;
                int rval = right.val;
                val = 0;
                left = null;
                right = null;
                Snail pl = this;
                Snail pr = this;
                while (pl != null && pl.isLeft) {
                    pl = pl.parent;
                }
                if (pl != null)
                    pl = pl.parent;
                if (pl != null)
                    pl = pl.left;
                while (pr != null && !pr.isLeft) {
                    pr = pr.parent;
                }
                if (pr != null)
                    pr = pr.parent;
                if (pr != null)
                    pr = pr.right;
                while (pl != null && pl.right != null)
                    pl = pl.right;
                while (pr != null && pr.left != null)
                    pr = pr.left;
                if (pl != null)
                    pl.val += lval;
                if (pr != null)
                    pr.val += rval;
            }
            if (left != null)
                left.explode();
            if (right != null)
                right.explode();
        }

        public boolean split() {
            if (left != null) {
                if (left.split())
                    return true;
            }
            if (right != null) {
                if (right.split())
                    return true;
            }
            if (val < 10)
                return false;
            left = new Snail("" + (val / 2), level + 1, this, true);
            right = new Snail("" + (val - val / 2), level + 1, this, false);
            val = 0;
            return true;
        }

        public long mag() {
            if (left == null && right == null)
                return val;
            return 3 * left.mag() + 2 * right.mag();
        }

        public String toString() {
            if (left == null && right == null)
                return "" + val;
            return "[" + left.toString() + "," + right.toString() + "]";
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/r.in"))));

        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        long ans = 0;
        for (int i = 0; i < lines.size(); ++i) {
            for (int j = 0; j < lines.size(); ++j) {
                if (i == j)
                    continue;
                ans = Math.max(ans,
                        new Snail(new Snail(lines.get(i), 0, null, true), new Snail(lines.get(j), 0, null, false))
                                .mag());
            }
        }

        System.out.println(ans);
    }
}