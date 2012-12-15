#include<algorithm>
#include<iostream>
#include<vector>


using namespace std;

int main(){
	int inputs, in, pLine = 0;
	while(cin >> inputs && inputs){
		if(pLine++) cout << '\n';
		vector<int> list;
		vector<int> combination;
		for(int i = 0; i < inputs; i++){
		cin >> in;
		list.push_back(in);
		if(i < 6) combination.push_back(0);
		else combination.push_back(1);
		}
		do{
			int first = 0;
			for(int i = 0; i < inputs; i++){
				if(!combination[i]){
					if(first++){
						cout << ' ';
					}
					cout << list[i];
				}
			}
			cout << '\n';
		}
		while(next_permutation(combination.begin(), combination.end()));
	}
	return 0;
}