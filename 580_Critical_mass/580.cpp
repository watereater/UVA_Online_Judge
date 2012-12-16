#include<iostream>
#include<vector>

using namespace std;

int main(){
    int in, arr[31];
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
	while(cin >> in && in){
		cout << arr[in] << '\n';
	}
	return 0;
}