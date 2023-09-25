import java.io.*;
import java.util.*;
import java.math.*;

public class H2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/h.in"))));
		/**/
		
		int ans = 0;
		while (sc.hasNextLine()) {
			String[] sp = sc.nextLine().split(" ");
			String[] strs = new String[10];
			int[] cts = new int[10];
			for (int i = 0; i < 10; ++i) {
				int l = sp[i].length();
				if (l==2)
					strs[1] = sp[i];
				if (l==3)
					strs[7] = sp[i];
				if (l==4)
					strs[4] = sp[i];
				if (l==7)
					strs[8] = sp[i];
				for (char c : sp[i].toCharArray()) {
					cts[c-'a']++;
				}
			}
			for (int i = 0; i < 10; ++i) {
				int l = sp[i].length();
				if (l==5||l==6) {
					int tot = 0;
					for (char c : sp[i].toCharArray()) {
						tot += cts[c-'a'];
					}
					if (tot==42)
						strs[0] = sp[i];
					if (tot==34)
						strs[2] = sp[i];
					if (tot==39)
						strs[3] = sp[i];
					if (tot==37)
						strs[5] = sp[i];
					if (tot==41)
						strs[6] = sp[i];
					if (tot==45)
						strs[9] = sp[i];
				}
			}
			for (int i = 0; i < 10; ++i) {
				char[] ii = strs[i].toCharArray();
				Arrays.sort(ii);
				strs[i] = new String(ii);
			}
			int pa = 0;
			for (int i = 11; i <= 14; ++i) {
				char[] ss = sp[i].toCharArray();
				Arrays.sort(ss);
				String s = new String(ss);
				pa *= 10;
				for (int j = 0; j < 10; ++j) {
					if (strs[j].equals(s))
						pa+=j;
				}
			}
			ans+=pa;
		}
		
		System.out.println(ans);
	}
}