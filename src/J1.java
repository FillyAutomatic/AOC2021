import java.io.*;
import java.util.*;
import java.math.*;

public class J1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/j.in"))));

        int ans = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int ct = 0;
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
                    if (ad.isEmpty())
                        break;
                    if (!ad.removeLast().equals(cc)) {
                        if (cc == ')')
                            ans += 3;
                        if (cc == ']')
                            ans += 57;
                        if (cc == '}')
                            ans += 1197;
                        if (cc == '>')
                            ans += 25137;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}