import java.io.*;
import java.util.*;
import java.math.*;

public class O2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/o.in"))));
		/**/
		
		int ans = 0;
		ArrayList<String> lines = new ArrayList<>();
		while (sc.hasNextLine()) {
			lines.add(sc.next());
		}
		int n = lines.size();
		int m = lines.get(0).length();
		int[][] vals = new int[n*5][m*5];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				for (int a = 0; a < 5; ++a) {
					for (int b = 0; b < 5; ++b) {
						vals[a*n+i][b*m+j] = lines.get(i).charAt(j)-'0'+a+b;
						while (vals[a*n+i][b*m+j] > 9)
							vals[a*n+i][b*m+j] -= 9;
					}
				}
			}
		}
		n *= 5;
		m *= 5;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				dp[i][j] = 1000000;
			}
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(0);
		dp[0][0] = 0;
		while (!q.isEmpty()) {
			int u = q.removeFirst();
			int uy = u/1000;
			int ux = u%1000;
			int d = dp[uy][ux];
			if (uy>0&&d+vals[uy-1][ux]<dp[uy-1][ux]){
				dp[uy-1][ux] = d+vals[uy-1][ux];
				q.add(u-1000);
			}
			if (uy<n-1&&d+vals[uy+1][ux]<dp[uy+1][ux]){
				dp[uy+1][ux] = d+vals[uy+1][ux];
				q.add(u+1000);
			}
			if (ux>0&&d+vals[uy][ux-1]<dp[uy][ux-1]){
				dp[uy][ux-1] = d+vals[uy][ux-1];
				q.add(u-1);
			}
			if (ux<m-1&&d+vals[uy][ux+1]<dp[uy][ux+1]){
				dp[uy][ux+1] = d+vals[uy][ux+1];
				q.add(u+1);
			}
		}
		
		System.out.println(dp[n-1][m-1]);
	}
}