import java.io.*;
import java.util.*;
import java.math.*;

public class H1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/h.in"))));

        int ans = 0;
        while (sc.hasNextLine()) {
            String[] sp = sc.nextLine().split(" ");
            for (int i = 10; i <= 14; ++i) {
                int l = sp[i].length();
                if (l == 2 || l == 3 || l == 4 || l == 7)
                    ++ans;
            }
        }

        System.out.println(ans);
    }
}