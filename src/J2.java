import java.io.*;
import java.util.*;
import java.math.*;

public class J2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/j.in"))));

        ArrayList<Long> al = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            long score = 0;
            ArrayDeque<Character> ad = new ArrayDeque<>();
            for (char cc : s.toCharArray()) {
                if (cc == '(')
                    ad.add(')');
                else if (cc == '[')
                    ad.add(']');
                else if (cc == '{')
                    ad.add('}');
                else if (cc == '<')
                    ad.add('>');
                else {
                    if (!ad.removeLast().equals(cc)) {
                        while (!ad.isEmpty())
                            ad.remove();
                        break;
                    }
                }
            }
            while (!ad.isEmpty()) {
                char c = ad.removeLast();
                score *= 5;
                if (c == ')')
                    score += 1;
                if (c == ']')
                    score += 2;
                if (c == '}')
                    score += 3;
                if (c == '>')
                    score += 4;
            }
            if (score > 0) {
                al.add(score);
            }
        }
        Collections.sort(al);
        System.out.println(al.get(al.size() / 2));
    }
}