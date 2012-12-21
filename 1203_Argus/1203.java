import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException{
		//solverJavaPriorityQueue();
		solverBinaryHeap();
	}
	static void solverJavaPriorityQueue() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		PriorityQueue<Register2> pq = new PriorityQueue<Register2>();
		//PriorityQueue<Register> pq = new PriorityQueue<Register>(1000, new Compare());
		// try out both Comparable and Comparator using Register and Register2
		while(!(line = br.readLine()).equals("#")){
			StringTokenizer stok = new StringTokenizer(line);
			stok.nextToken();
			pq.add(new Register2(Integer.parseInt(stok.nextToken()), Integer.parseInt(stok.nextToken())));
		}
		int output = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		while(output-- > 0){
			Register2 temp = pq.poll();
			sb.append(temp);
			temp.total += temp.step;
			pq.add(temp);
		}
		System.out.print(sb);
	} // solve using java priority queue
	
	static void solverBinaryHeap() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		//BinaryHeap<Register2> bh = new BinaryHeap<Register2>();
		BinaryHeap<Register> bh = new BinaryHeap<Register>(new Compare());
		// try out both Comparable and Comparator using Register and Register2
		while(!(line = br.readLine()).equals("#")){
			StringTokenizer stok = new StringTokenizer(line);
			stok.nextToken();
			bh.add(new Register(Integer.parseInt(stok.nextToken()), Integer.parseInt(stok.nextToken())));
		}
		int output = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		while(output-- > 0){
			Register temp = bh.poll();
			sb.append(temp);
			temp.total += temp.step;
			bh.add(temp);
		}
		System.out.print(sb);
	} // solve using java priority queue
	
}

class Register2 extends Register implements Comparable<Register2> {

	public Register2(int r, int s){
		super(r, s);
	}
	
	public int compareTo(Register2 other){
		if(total < other.total) return -1;
		else if(total == other.total){
			if(reg <= other.reg) return - 1;
		}
		return 1;
	}

}

class Register {
	String ID;
	int step, total, reg;
	public Register(int r, int s){
		step = s;
		total = s;
		reg = r;
		ID = r + "\n";
	}
	public String toString(){
		return ID;
	}
}

class Compare implements Comparator{
    public int compare(Object o1, Object o2) {
        Register lhs = (Register) o1;
        Register rhs = (Register) o2; 
        if(lhs.total < rhs.total) return -1;
		else if(lhs.total == rhs.total){
			if(lhs.reg <= rhs.reg) return - 1;
		}
		return 1;
    }
}

class BinaryHeap<AnyType>{
	AnyType heap [] = (AnyType[])new Object[1100]; // 1000 inputs at most
	int size = 0;
	Comparator cmp;
	public BinaryHeap(){
		cmp = null;
	}
	public BinaryHeap(Comparator cmp){
		this.cmp = cmp;
	}
	int compare(AnyType lhs, AnyType rhs){
		if(cmp == null){
			 return ((Comparable<? super AnyType>)lhs).compareTo(rhs);
		}
		return cmp.compare(lhs, rhs);
	}
	void add(AnyType in){
		heap[++size] = in;
		int temp = size;
		while(temp > 1){
			if(compare(in, heap[temp/2]) > 0) break;
			heap[temp] = heap[temp/2];
			temp/=2;
			heap[temp] = in;
		}
	}
	
	AnyType poll(){
		AnyType out = heap[1];
		heap[1] = heap[size--];
		int start = 1;
		while(start < size){
			int lhs = start * 2;
			int rhs = lhs + 1;
			if(rhs <= size){
				int left = compare(heap[lhs], heap[rhs]);
				if(left < 0){
					int down = compare(heap[lhs], heap[start]);
					if(down < 0){
						heap[start] = heap[lhs];
						start = lhs;
						heap[start] = heap[size+1];
					}
					else break;
				}
				else{
					int down = compare(heap[rhs], heap[start]);
					if(down < 0){
						heap[start] = heap[rhs];
						start = rhs;
						heap[start] = heap[size+1];
					}
					else break;
				}
			}
			else if(lhs <= size){
				int down = compare(heap[lhs], heap[start]);
				if(down < 0){
					heap[start] = heap[lhs];
					start = lhs;
					heap[start] = heap[size+1];
				}
				break;
			}
			else{
				break;
			}
		}// while
		return out;
	}
	
}

