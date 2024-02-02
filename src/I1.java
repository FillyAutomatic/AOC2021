import java.io.*;
import java.util.*;
import java.math.*;

public class I1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/i.in"))));

        int ans = 0;
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        for (int i = 0; i < lines.size(); ++i) {
            for (int j = 0; j < lines.get(0).length(); ++j) {
                if (i > 0 && lines.get(i).charAt(j) >= lines.get(i - 1).charAt(j))
                    continue;
                if (i < lines.size() - 1 && lines.get(i).charAt(j) >= lines.get(i + 1).charAt(j))
                    continue;
                if (j > 0 && lines.get(i).charAt(j) >= lines.get(i).charAt(j - 1))
                    continue;
                if (j < lines.get(0).length() - 1 && lines.get(i).charAt(j) >= lines.get(i).charAt(j + 1))
                    continue;
                ans += lines.get(i).charAt(j) - '0' + 1;
            }
        }

        System.out.println(ans);
    }
}