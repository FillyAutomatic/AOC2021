import java.io.*;
import java.util.*;
import java.math.*;

public class C2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int x = 0;
		int y = 0;
		ArrayList<String> ss = new ArrayList<>();
		while (sc.hasNext()) {
			String s = sc.next();
			ss.add(s);
		}
		ArrayList<String> ls = new ArrayList<>();
		ArrayList<String> os = new ArrayList<>();
		for (String s : ss) {
			ls.add(s);
			os.add(s);
		}
		int i = 0;
		while (ls.size() != 1) {
			int o = 0;
			int z = 0;
			for (String s : ls) {
				if (s.charAt(i)=='1')
					o++;
				else
					z++;
			}
			char c = '0';
			if (o>=z) {
				c = '1';
			}
			ArrayList<String> nls = new ArrayList<>();
			for (String s : ls) {
				if (s.charAt(i)==c)
					nls.add(s);
			}
			ls = nls;
			++i;
		}
		for (char c : ls.get(0).toCharArray()) {
			x*=2;
			x+=c-'0';
		}
		i = 0;
		while (os.size() != 1) {
			int o = 0;
			int z = 0;
			for (String s : os) {
				if (s.charAt(i)=='1')
					o++;
				else
					z++;
			}
			char c = '1';
			if (o>=z) {
				c = '0';
			}
			ArrayList<String> nos = new ArrayList<>();
			for (String s : os) {
				if (s.charAt(i)==c)
					nos.add(s);
			}
			os = nos;
			++i;
		}
		for (char c : os.get(0).toCharArray()) {
			y*=2;
			y+=c-'0';
		}
		System.out.println(x*y);
	}
}