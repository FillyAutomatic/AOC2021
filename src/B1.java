import java.io.*;
import java.util.*;
import java.math.*;

public class B1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));
		/**/
		
		int x = 0;
		int y = 0;
		while (sc.hasNext()) {
			String s = sc.next();
			int n = sc.nextInt();
			if (s.equals("forward"))
				x+=n;
			if (s.equals("down"))
				y+=n;
			if (s.equals("up"))
				y-=n;
		}
		System.out.println(x*y);
	}
}