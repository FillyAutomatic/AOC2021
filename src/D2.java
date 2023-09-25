import java.io.*;
import java.util.*;
import java.math.*;

public class D2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/d.in"))));
		/**/
		
		String[] first = sc.nextLine().split(",");
		ArrayList<ArrayList<ArrayList<Integer>>> boards = new ArrayList<>();
		while (sc.hasNextInt()) {
			ArrayList<ArrayList<Integer>> board = new ArrayList<>();
			for (int i = 0; i < 5; ++i) {
				board.add(new ArrayList<>());
				for (int j = 0; j < 5; ++j) {
					board.get(i).add(sc.nextInt());
				}
			}
			boards.add(board);
		}
		int bi = 0;
		int[] fins = new int[boards.size()];
		int ct = 0;
		for (String sx : first) {
			++bi;
			int x = Integer.parseInt(sx);
			for (int i = 0; i < boards.size(); ++i) {
				for (int j = 0; j < 5; ++j) {
					for (int k = 0; k < 5; ++k) {
						if (boards.get(i).get(j).get(k)==x)
							boards.get(i).get(j).set(k, -1);
					}
				}
				boolean fin = false;
				for (int j = 0; j < 5; ++j) {
					int hs = 0;
					int vs = 0;
					for (int k = 0; k < 5; ++k) {
						hs += boards.get(i).get(j).get(k);
						vs += boards.get(i).get(k).get(j);
					}
					if (hs==-5||vs==-5) {
						fin = true;
					}
				}
				if (fin && fins[i]==0) {
					fins[i] = bi;
					ct++;
					if (ct==boards.size()) {
						int tot = 0;
						for (int j = 0; j < 5; ++j) {
							for (int k = 0; k < 5; ++k) {
								if (boards.get(i).get(j).get(k)>0)
									tot += boards.get(i).get(j).get(k);
							}
						}
						System.out.println(tot*x);
						return;
					}
				}
			}
		}
	}
}