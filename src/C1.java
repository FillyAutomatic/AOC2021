import java.io.*;
import java.util.*;
import java.math.*;

public class C1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int x = 0;
		int y = 0;
		int[] vals = new int[0];
		int tot = 0;
		while (sc.hasNext()) {
			String s = sc.next();
			++tot;
			if (vals.length==0)
				vals = new int[s.length()];
			for (int i = 0; i < vals.length; ++i) {
				vals[i] += s.charAt(i)-'0';
			}
		}
		for (int i = 0; i < vals.length; ++i) {
			if (vals[i]<=tot/2) {
				x += 1<<(vals.length-i-1);
			} else {
				y += 1<<(vals.length-i-1);
			}
		}
		System.out.println(x*y);
	}
}