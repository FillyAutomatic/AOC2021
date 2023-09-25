import java.io.*;
import java.util.*;
import java.math.*;

public class E1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/e.in"))));
		/**/
		
		int[][] ct = new int[1001][1001];
		int ans = 0;
		while (sc.hasNext()) {
			String x = sc.next();
			int x1 = Integer.parseInt(x.split(",")[0]);
			int y1 = Integer.parseInt(x.split(",")[1]);
			sc.next();
			String y = sc.next();
			int x2 = Integer.parseInt(y.split(",")[0]);
			int y2 = Integer.parseInt(y.split(",")[1]);
			if (x1!=x2&&y1!=y2)
				continue;
			for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); ++i) {
				for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); ++j) {
					ct[i][j]++;
				}
			}
		}
		for (int i = 0; i <= 1000; ++i) {
			for (int j = 0; j <= 1000; ++j) {
				if (ct[i][j]>1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}