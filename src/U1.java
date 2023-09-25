import java.io.*;
import java.util.*;
import java.math.*;

public class U1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/u.in"))));
		/**/
		
		int p1 = 3;
		int p2 = 7;
		int die = 1;
		int x = 0;
		int y = 0;
		int rolls = 0;
		while (x<1000&&y<1000) {
			p1 += die;
			die++;
			rolls++;
			if (die==101)
				die-=100;
			p1 += die;
			die++;
			rolls++;
			if (die==101)
				die-=100;
			p1 += die;
			die++;
			rolls++;
			if (die==101)
				die-=100;
			p1 %= 10;
			if (p1==0)
				p1=10;
			x+=p1;
			if (x>=1000)
				break;
			p2 += die;
			die++;
			rolls++;
			if (die==101)
				die-=100;
			p2 += die;
			die++;
			rolls++;
			if (die==101)
				die-=100;
			p2 += die;
			die++;
			rolls++;
			if (die==101)
				die-=100;
			p2 %= 10;
			if (p2==0)
				p2=10;
			y+=p2;
		}
		
		System.out.println(Math.min(x, y)*rolls);
	}
}