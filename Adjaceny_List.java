package Code_chef;

import java.util.LinkedList;
import java.util.Scanner;

public class Adjaceny_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt(); // No. of Nodes
		int M = scn.nextInt(); // No. of Edges 
		int k = scn.nextInt();
		int val[] = new int[N+1];
		for(int i=1;i<=N;i++)
			val[i] = scn.nextInt();
		
		int AM[][] = new int[N+1][N+1];
		for(int i=1;i<=M;i++)
		{
			int A = scn.nextInt();
			int B = scn.nextInt();
			AM[A][B] = 1;
			AM[B][A] = 1; //undirected
		}
//		for(int i=1;i<=N;i++)
//		{
//			for(int j=1;j<=N;j++)
//				System.out.print(AM[i][j]+",");
//			System.out.println();
//		}

		for(int i=1;i<=N;i++) //for all nodes
		{ 
			int n[] = new int[N+1]; int t=-1;
			for(int j=1;j<=N;j++)
			{
				if(AM[i][j] == 1) //Exist
				{
					t++;
					n[t] = j;
				}
			}
			sort(n,val,t);
			int I = n[k-1] == 0 ? -1: n[k-1];
			System.out.println(I);
		}
	}

	/*
	 * 4 5 3
       2 4 5 4
       1 2
       2 3
       3 4
       1 3
       1 4
	  
	  
	  
	  7 10 3
14 7 14 22 21 51 14
1 5
1 2
2 5
5 4
5 7
4 7
6 4
3 6
2 6
2 3

	 * 
	 */
	public static void sort(int n[],int A[],int t)
	{
		for(int i=0;i<=t;i++)
		{
			//System.out.print(n[i]+" ");
			int key = i-1;
			int T = n[i];
			int X = A[n[i]];
			while(key >= 0 && A[n[key]] < X)
			{
				n[key+1] = n[key];
				key--;
			}
			n[key+1] = T;
		}
//		System.out.println();
//		for(int i=0;i<=t;i++)
//			System.out.print(n[i]+" ");
//		System.out.println();
	}
}
