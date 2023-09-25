import java.io.*;
import java.util.*;
import java.math.*;

public class V1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/v.in"))));
		/**/
		
		int ans = 0;
		ArrayList<String> lines = new ArrayList<>();
		int[][][] grid = new int[101][101][101];
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			int num = 0;
			if (s.split(" ")[0].equals("on"))
				num = 1;
			s = s.split(" ")[1];
			String[] three = s.split(",");
			int x1 = Integer.parseInt(three[0].substring(2, three[0].indexOf('.')));
			int x2 = Integer.parseInt(three[0].substring(three[0].lastIndexOf('.')+1));
			int y1 = Integer.parseInt(three[1].substring(2, three[1].indexOf('.')));
			int y2 = Integer.parseInt(three[1].substring(three[1].lastIndexOf('.')+1));
			int z1 = Integer.parseInt(three[2].substring(2, three[2].indexOf('.')));
			int z2 = Integer.parseInt(three[2].substring(three[2].lastIndexOf('.')+1));
			for (int a = Math.max(x1, -50); a <= Math.min(x2, 50); ++a) {
				for (int b = Math.max(y1, -50); b <= Math.min(y2, 50); ++b) {
					for (int c = Math.max(z1, -50); c <= Math.min(z2, 50); ++c) {
						grid[a+50][b+50][c+50] = num;
					}
				}
			}
		}
		for (int a = -50; a <= 50; ++a) {
			for (int b = -50; b <= 50; ++b) {
				for (int c = -50; c <= 50; ++c) {
					ans += grid[a+50][b+50][c+50];
				}
			}
		}
		
		System.out.println(ans);
	}
}