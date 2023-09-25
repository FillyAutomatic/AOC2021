import java.io.*;
import java.util.*;
import java.math.*;

public class A1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));
		/**/
		
		int ans = 0;
		int last = 100000;
		while (sc.hasNextInt()) {
			int curr = sc.nextInt();
			if (curr>last)
				++ans;
			last = curr;
		}
		System.out.println(ans);
	}
}