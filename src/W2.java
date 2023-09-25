import java.io.*;
import java.util.*;
import java.math.*;

public class W2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/w.in"))));
		/**/
		
		long[] pow5 = new long[27];
		pow5[0] = 1;
		for (int i = 1; i < 27; ++i)
			pow5[i] = pow5[i-1]*5;
		
		long start = 0;
		start += pow5[18]*1;
		start += pow5[21]*1;
		start += pow5[17]*2;
		start += pow5[20]*2;
		start += pow5[16]*3;
		start += pow5[22]*3;
		start += pow5[15]*4;
		start += pow5[19]*4;
		
		/*start += pow5[23]*1;
		start += pow5[26]*1;
		start += pow5[11]*2;
		start += pow5[13]*2;
		start += pow5[12]*3;
		start += pow5[25]*3;
		start += pow5[14]*4;
		start += pow5[24]*4;*/
		
		start += pow5[13]*1;
		start += pow5[24]*1;
		start += pow5[14]*2;
		start += pow5[23]*2;
		start += pow5[11]*3;
		start += pow5[26]*3;
		start += pow5[12]*4;
		start += pow5[25]*4;
		
		/*long start = 15*19+18;
		start = (start*19+11)*19+13;
		start = (start*19+12)*19+17;
		start = (start*19+14)*19+16;*/
		
		/*long start = 13*19+16;
		start = (start*19+14)*19+15;
		start = (start*19+11)*19+18;
		start = (start*19+12)*19+17;*/
		
		long e = 0;
		e += pow5[11]*1;
		e += pow5[12]*2;
		e += pow5[13]*3;
		e += pow5[14]*4;
		e += pow5[15]*1;
		e += pow5[16]*2;
		e += pow5[17]*3;
		e += pow5[18]*4;
		e += pow5[19]*1;
		e += pow5[20]*2;
		e += pow5[21]*3;
		e += pow5[22]*4;
		e += pow5[23]*1;
		e += pow5[24]*2;
		e += pow5[25]*3;
		e += pow5[26]*4;
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		HashMap<Long, Integer> dists = new HashMap<>();
		pq.add("000000000 "+ start);
		dists.put(start, 0);
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < 27; ++i) {
			g.add(new ArrayList<>());
		}
		g.get(0).add(1);
		g.get(10).add(9);
		for (int i = 1; i <= 9; ++i) {
			g.get(i).add(i-1);
			g.get(i).add(i+1);
		}
		g.get(2).add(11);
		g.get(4).add(12);
		g.get(6).add(13);
		g.get(8).add(14);
		g.get(11).add(2);
		g.get(12).add(4);
		g.get(13).add(6);
		g.get(14).add(8);
		for (int i = 15; i < 27; ++i) {
			g.get(i-4).add(i);
			g.get(i).add(i-4);
		}
		while (!pq.isEmpty()) {
			String pqs = pq.poll();
			long pq0 = Long.parseLong(pqs.split(" ")[1]);
			int dist = dists.get(pq0);
			if (dists.size()%1000==0)
				System.out.println(dist + " " + pq.size()+" "+dists.size());
			if (dist != Integer.parseInt(pqs.split(" ")[0]))
				continue;
			if (pq0==e) {
				System.out.println(dist);
				return;
			}
			int[] us = new int[27];
			for (int i = 0; i < 27; ++i) {
				us[i] = (int)(pq0/pow5[i]%5);
			}
			
			int imin = 0;
			int imax = 26;
			for (int i = 2; i <= 8; i+=2) {
				if (us[i]!=0) {
					imin = i;
					imax = i;
				}
			}
			if (imin!=imax) {
				for (int i = 15; i <= 26; ++i) {
					if (us[i]!=0&&us[i]!=(i+1)%4+1&&us[i-4]==0) {
						imin = i;
						imax = i;
					}
				}
			}
			if (imin!=imax) {
				for (int i = 11; i <= 14; ++i) {
					if (us[i]==(i+1)%4+1&&us[i+4]==0&&us[i+8]==0&&us[i+12]==0) {
						imin = i;
						imax = i;
					}
				}
				for (int i = 15; i <= 18; ++i) {
					if (us[i]==(i+1)%4+1&&us[i+4]==0&&us[i+8]==0) {
						imin = i;
						imax = i;
					}
				}
				for (int i = 19; i <= 22; ++i) {
					if (us[i]==(i+1)%4+1&&us[i+4]==0) {
						imin = i;
						imax = i;
					}
				}
			}
			for (int u = imin; u <= imax; ++u) {
				int type = us[u];
				if (type==0)
					continue;
				ArrayList<Integer> pv = new ArrayList<>();
				int[] ds = new int[27];
				if (u==2||u==4||u==6||u==8) {
					ArrayDeque<Integer> q = new ArrayDeque<>();
					q.add(u);
					boolean[] vis = new boolean[27];
					vis[u] = true;
					while (!q.isEmpty()) {
						int uu = q.removeFirst();
						for (int vv : g.get(uu)) {
							if (us[vv]==0&&!vis[vv]) {
								ds[vv] = ds[uu]+1;
								vis[vv] = true;
								q.add(vv);
							}
						}
					}
					for (int v = 0; v <= 10; ++v) {
						if (vis[v] && v!=2&&v!=4&&v!=6&&v!=8)
							pv.add(v);
					}
				} else if (u<=10) {
					int v = 10+type;
					ArrayDeque<Integer> q = new ArrayDeque<>();
					q.add(u);
					boolean[] vis = new boolean[27];
					vis[u] = true;
					while (!q.isEmpty()) {
						int uu = q.removeFirst();
						for (int vv : g.get(uu)) {
							if (us[vv]==0&&!vis[vv]) {
								ds[vv] = ds[uu]+1;
								vis[vv] = true;
								q.add(vv);
							}
						}
					}
					if (vis[v])
						pv.add(v);
				} else {
					pv.addAll(g.get(u));
				}
				for (int v : pv) {
					if (us[v] != 0)
						continue;
					if (v>=11&&v<=14&&u<v) {
						if (v!=10+type)
							continue;
						if (us[v+4]!=0&&us[v+4]!=type)
							continue;
						if (us[v+8]!=0&&us[v+8]!=type)
							continue;
						if (us[v+12]!=0&&us[v+12]!=type)
							continue;
					}
					if (v>=15&&v<=18&&u<v) {
						if (v!=14+type)
							continue;
						if (us[v+4]!=0&&us[v+4]!=type)
							continue;
						if (us[v+8]!=0&&us[v+8]!=type)
							continue;
					}
					if (v>=19&&v<=22&&u<v) {
						if (v!=18+type)
							continue;
						if (us[v+4]!=0&&us[v+4]!=type)
							continue;
						if (us[v-8]!=0&&us[v-8]!=type)
							continue;
					}
					if (v>=23&&v<=26&&u<v) {
						if (v!=22+type)
							continue;
						if (us[v-8]!=0&&us[v-8]!=type)
							continue;
						if (us[v-12]!=0&&us[v-12]!=type)
							continue;
					}
					int cost = 1000;
					if (type==3)
						cost=100;
					if (type==2)
						cost=10;
					if (type==1)
						cost=1;
					cost *= Math.max(1, ds[v]);
					int nd = dist+cost;
					long vv = pq0-pow5[u]*type+pow5[v]*type;
					if (nd < dists.getOrDefault(vv, 10000000)) {
						dists.put(vv, nd);
						pq.add(String.format("%09d %d", nd, vv));
					}
				}
			}
		}
		System.out.println("PIKA");
	}
}