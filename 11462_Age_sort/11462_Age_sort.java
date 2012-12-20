import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException{
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null){
			int inputs = Integer.parseInt(line);
			if(inputs == 0) break;
			StringTokenizer stok = new StringTokenizer(br.readLine());
			int list [] = new int[inputs];
			for(int i = 0; i < inputs; i++){
				list[i] = Integer.parseInt(stok.nextToken());
			}
			Arrays.sort(list);
			for(int i = 0; i < inputs; i++){
				if(i > 0) sb.append(' ');
				sb.append(list[i]);
			}
			sb.append('\n');
		}// while no more input
		System.out.print(sb);
	}// main
}// Class Main