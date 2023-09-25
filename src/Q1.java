import java.io.*;
import java.util.*;
import java.math.*;

public class Q1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/q.in"))));
		/**/
		
		int ans = 0;
		int x1 = 138;
		int x2 = 184;
		int y1 = -125;
		int y2 = -71;
		
		for (int i = -500; i <= 500; ++i) {
			for (int j = -500; j <= 500; ++j) {
				int dx = i;
				int dy = j;
				int x = 0;
				int y = 0;
				int ym = 0;
				boolean pass = false;
				for (int z = 0; z < 5000; ++z) {
					x += dx;
					y += dy;
					ym = Math.max(ym, y);
					if (x1<=x&&x<=x2&&y1<=y&&y<=y2)
						pass = true;
					dy--;
					if (dx<0)
						dx++;
					if (dx>0)
						dx--;
				}
				if (pass)
					ans = Math.max(ans, ym);
			}
		}
		
		System.out.println(ans);
	}
}