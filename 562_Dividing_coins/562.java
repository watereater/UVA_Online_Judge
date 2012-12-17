import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
			while(cases-- > 0){
			int inputs = sc.nextInt();
			boolean arr [][] = new boolean [2][25001];
			arr[0][0] = true;
			int i, j;
			for(i = 0; i < inputs; i++){
				int in = sc.nextInt();
				for(j = 0; j <= 25000; j++){
					if(arr[i&1][j]){
						int temp = j + in > 25000 ? 25000 : j + in;
						arr[(i+1)&1][temp] = true;
						arr[(i+1)&1][Math.abs(j-in)] = true;
						arr[i&1][j] = false;
					}
				}
			}
			for(j = 0; j <= 25000; j++){
				if(arr[i&1][j]) break;
			}
			System.out.println(j);
		}
	}
}