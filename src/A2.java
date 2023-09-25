import java.io.*;
import java.util.*;
import java.math.*;

public class A2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));
		/**/
		
		int ans = 0;
		int l3 = sc.nextInt();
		int l2 = sc.nextInt();
		int l1 = sc.nextInt();
		while (sc.hasNextInt()) {
			int curr = sc.nextInt();
			if (curr>l3) {
				++ans;
			}
			l3 = l2;
			l2 = l1;
			l1 = curr;
		}
		System.out.println(ans);
	}
}