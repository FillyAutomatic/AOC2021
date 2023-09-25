import java.io.*;
import java.util.*;
import java.math.*;

public class G2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/g.in"))));
		/**/
		
		long ans = 1000000000;
		String[] ss = sc.nextLine().split(",");
		int[] is = new int[ss.length];
		for (int i = 0; i < ss.length; ++i)
			is[i] = Integer.parseInt(ss[i]);
		for (int i = 0; i < 2000; ++i) {
			int aa = 0;
			for (int x : is) {
				long diff = Math.abs(x-i);
				aa += diff*(diff+1)/2;
			}
			ans = Math.min(ans, aa);
		}
		System.out.println(ans);
	}
}