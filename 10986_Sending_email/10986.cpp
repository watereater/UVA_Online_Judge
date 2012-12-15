#include<cstdio>
#include<vector>
#include<queue>
#include<map>
#include<set>
#include<utility>

using namespace std;

typedef pair<int, int> P;
typedef set<pair<int, int> >::iterator SI;
#define MP(x, y) make_pair(x,y)
#define max 2000000000

class comparator{
    public:
        bool operator() (const P &lhs, const P &rhs){
			return lhs.second > rhs.second;
		}
};

int main(){
	int worst[20000];
	int Cases;
	scanf("%d", &Cases);
	for(int C = 1; C <= Cases; C++){
		int N, M, S, T;
		scanf("%d %d %d %d", &N, &M, &S, &T);
		map<int, set<P> > m;
		for(int i = 0; i < N; i++){
			worst [i] = max;
		}
		for(int i = 0; i < M; i++){
			int to, from, cost;
			scanf("%d %d %d", &to, &from, &cost);
			m[to].insert(MP(from, cost));
			m[from].insert(MP(to, cost));
		}
		priority_queue<P, vector<P>, comparator> pq;
		worst[S] = 0;
		pq.push(MP(S, 0));
		while(!pq.empty()){
			P node = pq.top();
			pq.pop();
			int cur = node.first;
			int cost = node.second;
			if(worst[cur] < cost) continue;
			if(cur == T) break;		
			SI it = m[cur].begin();
			while(it != m[cur].end()){
				P other = *it;
				int newcost = other.second + cost;
				int temp = other.first;
				if(worst[temp] > newcost){
					worst[temp] = newcost;
					pq.push(MP(temp, newcost));
				}
				it++;
			}
		}
		printf("Case #%d: ", C);
		if(worst[T] == max) printf("unreachable");
		else printf("%d", worst[T]);
		putchar('\n');
	}// cases

}