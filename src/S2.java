import java.io.*;
import java.util.*;
import java.math.*;

public class S2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/s.in"))));

        int ans = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> scans = new ArrayList<>();
        while (sc.hasNextLine()) {
            sc.nextLine();
            scans.add(new ArrayList<>());
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.isEmpty())
                    break;
                ArrayList<Integer> al = new ArrayList<>();
                al.add(Integer.parseInt(s.split(",")[0]));
                al.add(Integer.parseInt(s.split(",")[1]));
                al.add(Integer.parseInt(s.split(",")[2]));
                scans.get(scans.size() - 1).add(al);
            }
        }
        int n = scans.size();
        int[][] locs = new int[n][3];
        for (int p = 0; p < n; ++p) {
            for (int i = 0; i < n; ++i) {
                if (i != 0 && locs[i][0] == 0 && locs[i][1] == 0 && locs[i][2] == 0)
                    continue;
                for (int j = 1; j < n; ++j) {
                    if (i == j)
                        continue;
                    if (locs[j][0] != 0 || locs[j][1] != 0 || locs[j][2] != 0)
                        continue;
                    for (int a = 0; a < scans.get(i).size(); ++a) {
                        HashSet<Long> hs1 = new HashSet<>();
                        for (int b = 0; b < scans.get(i).size(); ++b) {
                            long num = 42069 - (scans.get(i).get(b).get(0) - scans.get(i).get(a).get(0));
                            num <<= 16;
                            num += 42069 - (scans.get(i).get(b).get(1) - scans.get(i).get(a).get(1));
                            num <<= 16;
                            num += 42069 - (scans.get(i).get(b).get(2) - scans.get(i).get(a).get(2));
                            hs1.add(num);
                        }
                        for (int aa = 0; aa < scans.get(j).size(); ++aa) {
                            for (int tr = 0; tr < 48; ++tr) {
                                HashSet<Long> hs2 = new HashSet<>();
                                for (int bb = 0; bb < scans.get(j).size(); ++bb) {
                                    int x = scans.get(j).get(bb).get(0) - scans.get(j).get(aa).get(0);
                                    int y = scans.get(j).get(bb).get(1) - scans.get(j).get(aa).get(1);
                                    int z = scans.get(j).get(bb).get(2) - scans.get(j).get(aa).get(2);
                                    if (tr % 2 == 1)
                                        x = -x;
                                    if (tr / 2 % 2 == 1)
                                        y = -y;
                                    if (tr / 4 % 2 == 1)
                                        z = -z;
                                    if (tr / 16 == 1) {
                                        int t = x;
                                        x = y;
                                        y = t;
                                    } else if (tr / 16 == 2) {
                                        int t = x;
                                        x = z;
                                        z = t;
                                    }
                                    if (tr % 16 / 8 == 1) {
                                        int t = y;
                                        y = z;
                                        z = t;
                                    }
                                    long num = 42069 - x;
                                    num <<= 16;
                                    num += 42069 - y;
                                    num <<= 16;
                                    num += 42069 - z;
                                    if (hs1.contains(num))
                                        hs2.add(num);
                                }
                                if (hs2.size() >= 12) {
                                    for (int bb = 0; bb < scans.get(j).size(); ++bb) {
                                        int x = scans.get(j).get(bb).get(0);
                                        int y = scans.get(j).get(bb).get(1);
                                        int z = scans.get(j).get(bb).get(2);
                                        if (tr % 2 == 1)
                                            x = -x;
                                        if (tr / 2 % 2 == 1)
                                            y = -y;
                                        if (tr / 4 % 2 == 1)
                                            z = -z;
                                        if (tr / 16 == 1) {
                                            int t = x;
                                            x = y;
                                            y = t;
                                        } else if (tr / 16 == 2) {
                                            int t = x;
                                            x = z;
                                            z = t;
                                        }
                                        if (tr % 16 / 8 == 1) {
                                            int t = y;
                                            y = z;
                                            z = t;
                                        }
                                        scans.get(j).get(bb).set(0, x);
                                        scans.get(j).get(bb).set(1, y);
                                        scans.get(j).get(bb).set(2, z);
                                    }
                                    locs[j][0] = locs[i][0] + scans.get(i).get(a).get(0) - scans.get(j).get(aa).get(0);
                                    locs[j][1] = locs[i][1] + scans.get(i).get(a).get(1) - scans.get(j).get(aa).get(1);
                                    locs[j][2] = locs[i][2] + scans.get(i).get(a).get(2) - scans.get(j).get(aa).get(2);
                                    break;
                                }
                            }
                            if (locs[j][0] != 0 || locs[j][1] != 0 || locs[j][2] != 0)
                                break;
                        }
                        if (locs[j][0] != 0 || locs[j][1] != 0 || locs[j][2] != 0)
                            break;
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, Math.abs(locs[i][0] - locs[j][0]) + Math.abs(locs[i][1] - locs[j][1])
                        + Math.abs(locs[i][2] - locs[j][2]));
            }
        }

        System.out.println(ans);
    }
}