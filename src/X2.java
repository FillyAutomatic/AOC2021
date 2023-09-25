import java.io.*;
import java.util.*;
import java.math.*;

public class X2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/x.in"))));
		/**/
		
		long ans = 0;
		ArrayList<ArrayList<String>> ps = new ArrayList<>();
		int cp = -1;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.startsWith("inp")) {
				++cp;
				ps.add(new ArrayList<>());
			}
			ps.get(cp).add(s);
		}
		long[] rs = new long[256];
		ArrayList<TreeMap<Long, Long>> poss = new ArrayList<>();
		for (int i = 0; i < 15; ++i)
			poss.add(new TreeMap<>());
		poss.get(0).put(0L, 0L);
		for (int i = 0; i < 14; ++i) {
			double pow = Math.pow(30, 14-i);
			for (long sz : poss.get(i).keySet()) {
				for (int j = 1; j <= 9; ++j) {
					rs['w'] = 0;
					rs['x'] = 0;
					rs['y'] = 0;
					rs['z'] = sz;
					for (String s : ps.get(i)) {
						String ins = s.split(" ")[0];
						char var = s.split(" ")[1].charAt(0);
						if (ins.equals("inp")) {
							rs[var] = j;
							continue;
						}
						String rem = s.split(" ")[2];
						long val = 0;
						if (rem.charAt(0)>'9') {
							val = rs[rem.charAt(0)];
						} else {
							val = Long.parseLong(rem);
						}
						if (ins.equals("add")) {
							rs[var] = rs[var]+val;
						}
						if (ins.equals("mul")) {
							rs[var] = rs[var]*val;
						}
						if (ins.equals("div")) {
							rs[var] = rs[var]/val;
						}
						if (ins.equals("mod")) {
							rs[var] = rs[var]%val;
						}
						if (ins.equals("eql")) {
							rs[var] = rs[var]==val?1:0;
						}
					}
					if (rs['z']>pow)
						continue;
					poss.get(i+1).put(rs['z'], Math.min(poss.get(i+1).getOrDefault(rs['z'], 1234567890123456L), poss.get(i).get(sz)*10+j));
				}
				if (sz%10000==0)
					System.out.println(i+" "+poss.get(i+1).size()+" "+sz);
			}
		}
		System.out.println(poss.get(14).get(0L));
	}
}