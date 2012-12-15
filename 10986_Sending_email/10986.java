import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Cases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int worst [] = new int[20000];
		for(int C = 1; C <= Cases; C++){
			StringTokenizer stok = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stok.nextToken()); // # of nodes
			int M = Integer.parseInt(stok.nextToken());	// # of cables
			int S = Integer.parseInt(stok.nextToken()); // start
			int T = Integer.parseInt(stok.nextToken()); // end
			HashMap<Integer, HashSet<Node> > map = new HashMap<Integer, HashSet<Node> >();			
			for(int i = 0; i < N; i++){
				worst [i] = Integer.MAX_VALUE;
				map.put(i, new HashSet<Node>());
			} // not very efficient but :/
			for(int i = 0; i < M; i++){
				stok = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(stok.nextToken()); // # to
				int from = Integer.parseInt(stok.nextToken());	// # from
				int cost = Integer.parseInt(stok.nextToken()); // # cost
				map.get(to).add(new Node(cost, from));
				map.get(from).add(new Node(cost, to));
			}			
			PriorityQueue<Node> pq = new PriorityQueue<Node>(); // this requires dijkstra
			pq.add(new Node(0, S));
			worst[S] = 0;
			while(!pq.isEmpty()){
				Node node = pq.poll();
				int cur = node.current;
				int cost = node.cost;
				if(worst[cur] < cost) continue; // if you don't do this it will be really slow
				if(cur == T) break; // also needed for speed up
				for(Node other: map.get(cur)){
					int newcost = other.cost + cost;
					int temp = other.current;
					if(worst[temp] > newcost){
						worst[temp] = newcost;
						pq.add(new Node(newcost, temp));
					}
				}
			}// while more left in priority queue
			sb.append("Case #").append(C).append(": ");
			if(worst[T] == Integer.MAX_VALUE) sb.append("unreachable");
			else sb.append(worst[T]);
			sb.append('\n');
		}// while cases left
		System.out.print(sb);
	}// main
}

class Node implements Comparable<Node>{
	int cost;
	int current;
	public Node(int cost, int current){
		this.cost = cost;
		this.current = current;
	}
	public int compareTo(Node other){
		return cost - other.cost;
	}
	public int hashCode(){
		return (current << 46) | cost;
	}
	public boolean equals(Object o){
		Node other = (Node)o;
		return other.current == current && other.cost == cost;
	}
}