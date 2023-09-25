import java.io.*;
import java.util.*;
import java.math.*;

public class P1 {
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/p.in"))));
		/**/
		
		String s = sc.next();
		int[] bits = new int[s.length()*4];
		int cb = 0;
		for (char c : s.toCharArray()) {
			int num = c-'0';
			if (c>'9')
				num = (int)(c-'A')+10;
			bits[cb++] = num/8;
			num-=num/8*8;
			bits[cb++] = num/4;
			num-=num/4*4;
			bits[cb++] = num/2;
			num-=num/2*2;
			bits[cb++] = num;
		}
		cb = 0;
		parse(bits, 0);
		System.out.println(ans);
	}
	
	public static int parse(int[] bits, int start) {
		int cb = start;
		int ver = bits[cb++];
		ver = ver*2+bits[cb++];
		ver = ver*2+bits[cb++];
		ans += ver;
		int type = bits[cb++];
		type = type*2+bits[cb++];
		type = type*2+bits[cb++];
		if (type==4) {
			while (bits[cb++]==1) {
				cb += 4;
			}
			cb += 4;
		} else {
			if (bits[cb++]==1) {
				int nps = bits[cb++];
				for (int i = 0; i < 10; ++i)
					nps = nps*2+bits[cb++];
				for (int i = 0; i < nps; ++i)
					cb = parse(bits, cb);
			} else {
				int lps = bits[cb++];
				for (int i = 0; i < 14; ++i)
					lps = lps*2+bits[cb++];
				int ocb = cb;
				while (cb < ocb+lps) {
					cb = parse(bits, cb);
				}
			}
		}
		return cb;
	}
}