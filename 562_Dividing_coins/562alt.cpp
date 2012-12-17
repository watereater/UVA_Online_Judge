#include<cstdio>
#include<set>
#include<algorithm>

using namespace std;

typedef set<int> S;
typedef set<int>::iterator SI;

int main(){
	int cases, inputs, in;
	scanf("%d", &cases);
	while(cases-- > 0){
		scanf("%d", &inputs);
		S set1;
		set1.insert(0);
		while(inputs-- > 0){
			scanf("%d", &in);
			S set2;
			SI it = set1.begin();
			while(it != set1.end()){
				set2.insert(*it+in);
				set2.insert(abs(*it-in));
				it++;
			}
			set1.swap(set2);
		}
		SI it = set1.begin();
		printf("%d\n", *it);
	}
	return 0;
}