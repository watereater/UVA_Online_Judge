#include<iostream>
#include<algorithm>

using namespace std;

int main(){
	int cases, inputs, in;
	cin >> cases;
	while(cases-- > 0){
		cin >> inputs;
		bool arr [2][25001] = {0};
		arr[0][0] = 1;
		int i, j;
		for(i = 0; i < inputs; i++){
			cin >> in;
			for(j = 0; j <= 25000; j++){
				if(arr[i&1][j]){
					int temp = j + in > 25000 ? 25000 : j + in;
					arr[(i+1)&1][temp] = 1;
					arr[(i+1)&1][abs(j-in)] = 1;
					arr[i&1][j] = 0;
				}
			}
		}
		for(j = 0; j <= 25000; j++){
			if(arr[i&1][j]) break;
		}
		cout << j << '\n';
	}
	return 0;
}