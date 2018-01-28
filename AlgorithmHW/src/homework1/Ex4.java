package homework1;

import java.util.*;

public class Ex4 {
	private double[] A;
	private double[] B;
	private double[] T;
	private Random rand;
	private int L;
	
	// generate two random arrays A[N], B[N]
	// as an simulation of two sets of integer 
	// from two separate database
	// generate an array T[2N]  for testing purpose, 
	// T[] have all elements of A[], B[]
	// sort A[], B[], T[]
	Ex4(int N, int range){
		A = new double[N];
		B = new double[N];
		T = new double[2 * N];
		L = N;
		
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(range);
			B[i] = rand.nextInt(range);
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		System.arraycopy(A, 0, T, 0, N);
		System.arraycopy(B, 0, T, N, N);
		Arrays.sort(T);
	}
	// find the median of T[] for testing purpose
	// notice, T[] is sorted
	// generally, there are 2 case: 
	// case 1: when 2L is even, the median is the average of the two middle elements of T[]
	// 		median = ( [2L/2] + [2L/2 - 1] )/2
	// case 2: when 2L is odd, the median is the middle elements of T[]
	// 		median = [2L/2]
	// but no matter N is odd or even
	// 2N is even
	// so we only need to think of case 1 for T[];
	// that is, 
	// median = ( [2L/2] + [2L/2 - 1] )/2
	double tMedian() {
		int m = 2 * L / 2;
		
		return (T[m] + T[m-1])/2.0;
	}
	
	// find the median of each set A[], B[],
	
	// there are three cases:
	// case 1: Set A is the smaller portion
	// 			
	// case 2: Set B is the smaller portion
	// case 3: Set A and Set B are mix.
	// we need to consider whether N is odd or even
	// to simplify the solution,
	// if N is odd, we will take even number of element as the sub-portion. 
	// then 
	// compare median of A[] = am , with median of B[] = bm, 
	// if am > bm 
	// As = [
	
	double findMedian() {
		int mid = L / 2;
		double am = 0, bm = 0;
		if ((L % 2 ) != 0) {
			am = A[mid];
			bm = B[mid];
			System.out.println("mid : " + mid + " median A: " + am + " median B: " + bm);
		}
		if (am > bm) {
			
		}
		return 0.0;
	}
	// find median of the numbers, N is even.
	@SuppressWarnings("unused")
	private double median(double[] a, int start, int end) {
		
		return 0.0;
	}

	
	void displayT() {
		System.out.print("\nT: ");
		for (double t : T) {
			System.out.print(t + ", ");
		}
		System.out.print("\n");
	}
	
	void display(String s) {
		System.out.println(s);
		System.out.print("A: ");
		for(double a : A) {
			System.out.print(a + ", ");
		}
		System.out.print("\nB: ");
		for(double b: B) {
			System.out.print(b + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Ex4 a = new Ex4(11,30);
		a.display("original");
		double median = 0;
		median = a.findMedian();
		median = a.tMedian();
		System.out.print(median);
		a.displayT();
		
		
	}
}
