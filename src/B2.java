import java.io.*;
import java.util.*;
import java.math.*;

public class B2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));
		/**/
		
		long x = 0;
		long y = 0;
		int aim = 0;
		while (sc.hasNext()) {
			String s = sc.next();
			int n = sc.nextInt();
			if (s.equals("forward")) {
				x+=n;
				y+=n*aim;
			}
			if (s.equals("down"))
				aim+=n;
			if (s.equals("up"))
				aim-=n;
		}
		System.out.println(x*y);
	}
}