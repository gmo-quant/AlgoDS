package homework1;


import java.util.*;


public class Ex5 {
	private int[] A;
	private Random rand;

	Ex5(int N, int range){
		A = new int[N];
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(range);
		}
	}
	
	void findSum() {
		Arrays.sort(A);
		display("sorted");
		int a, b, c;
		for (c = A.length - 1; c > 0; c--) {
			for (a = c-1; a > 0; a--) {
				b = Arrays.binarySearch(A,0, a, A[c] - A[a]);
				if (b > 0) {
					System.out.print(A[c] + " = " + A[a] + " + " + A[b] + " index of " + a + ", " + b + " , " + c);
					System.out.println();
				}
			}
		}
		
	}
	
	void display(String s) {
		System.out.println(s);
		for(int n : A) {
			System.out.print(n + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Ex5 a = new Ex5(100,100);
		a.display("original");
		a.findSum();
		
	}
}
