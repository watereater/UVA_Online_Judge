import java.io.*;
import java.util.*;

class Main{
	static int arr [] = new int [31];
	static void preCalculate(){
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 0;
		for(int i = 3; i <= 30; i++){
			int pow = i - 3;
			int tot = 1 << pow--, start = 0;	
			while(pow >= 0){
				tot += ((1 << start) - arr[start++])*(1 << pow--);
			}
			arr[i] = tot;
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		preCalculate();
		int in;
		while((in = sc.nextInt())!=0){
			System.out.println(arr[in]);
		}
	}
}