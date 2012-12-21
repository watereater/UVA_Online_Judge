#include<iostream>
#include<string>
#include<sstream>
#include<set>
#include<map>
#include<queue>

using namespace std;

int main(){
	std::ios_base::sync_with_stdio(false); // speed up for cin/cout
	int inputs;
	while(cin >> inputs && inputs){
		string str;
		getline(cin, str);
		map<string, set<string> > complete;
		map<string, int> index;
		bool found [110] = {0}; // always declare above max and initialize
		vector<string> v;
		for(int i = 0; i < inputs; i++){
			getline(cin, str);
			stringstream ss(str);// not very efficient but easy to code
			string first, next;
			ss >> first;
			index[first] = i;
			v.push_back(first);
			while(ss >> next){
				complete[first].insert(next);
			}
		}
		for(int i = 0; i < inputs; i++){
			if(found[i]) {
				continue;
			}
			string current = v[i];
			bool def [110] = {0};
			bool dic [110] = {0};
			queue<string> q;
			q.push(current);
			while(!q.empty()){
				current = q.front();
				q.pop();
				int ind = index[current];
				dic[ind] = 1;
				set<string>:: iterator it = complete[current].begin();
				while(it != complete[current].end()){
					ind = index[*it];
					if(def[ind]) {
						it++;
						continue;
					}
					def[ind] = 1;
					q.push(*it);
					it++;
				}// it is not end
			}// q is not empty
			bool allGood = 1; // assume that dictionarys == definitions
			for(int j = 0; j < inputs; j++){
				if(dic[j] != def[j]){
					allGood = 0;
					break;
				}
			}
			if(allGood){
				for(int j = 0; j < inputs; j++){
					if(dic[j]){
						found[j] = 1;
					}
				}
			} // add to found			
		}// check all inputs
		int count = 0;
		for(int i = 0; i < inputs; i++){
			if(found[i]) count++;
		}
		cout << count << '\n';
		bool space = 0;
		for(int i = 0; i < inputs; i++){
			if(found[i]){
				if(space) cout << ' ';
				space = 1;
				cout << v[i];
			}
		}
		cout << '\n';
	}
	return 0;
}