import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null){
			int inputs = Integer.parseInt(line.trim());
			if(inputs == 0) break;
			ArrayList<String> list = new ArrayList<String>();
			HashMap<String, Integer> index = new HashMap<String, Integer>();
			HashMap<String, HashSet<String> > map = new HashMap<String, HashSet<String> >();
			for(int i = 0; i < inputs; i++){
				StringTokenizer stok = new StringTokenizer(br.readLine());
				String first = stok.nextToken();
				index.put(first, i);
				list.add(first);
				map.put(first, new HashSet<String>());
				while(stok.hasMoreTokens()){
					map.get(first).add(stok.nextToken());
				}
			}
			boolean found [] = new boolean[inputs];
			for(int i = 0; i < inputs; i++){
				if(found[i]) continue;
				// bfs
				String current = list.get(i);
				boolean dic[] = new boolean[inputs]; // dictionarys
				boolean def[] = new boolean[inputs]; // definitions
				LinkedList<String> queue = new LinkedList<String>();
				queue.add(current);
				while(!queue.isEmpty()){
					current = queue.poll();
					int ind = index.get(current);
					dic[ind] = true;
					for(String next: map.get(current)){
						ind = index.get(next);
						if(def[ind]) continue;
						def[ind] = true;
						queue.add(next);
					}
				}
				boolean allGood = true; // assume that dictionarys == definitions
				for(int j = 0; j < inputs; j++){
					if(dic[j] != def[j]){
						allGood = false;
						break;
					}
				}
				if(allGood){
						for(int j = 0; j < inputs; j++){
						if(dic[j]){
							found[j] = true;
						}
					}
				} // add to found				
			}// check all dictionaries
			StringBuilder sb2 = new StringBuilder();
			boolean nFirst = false;
			int outputs = 0;
			for(int i = 0; i < inputs; i++){
				if(found[i]){
					if(nFirst) sb2.append(' ');
					nFirst = true;
					sb2.append(list.get(i));
					outputs++;
				}
			}
			sb.append(outputs).append('\n').append(sb2).append('\n');
		}// while more inputs
		System.out.print(sb);
	}// main
}// class Main