#include<iostream>
#include<algorithm>

using namespace std;

int main(){
	std::ios_base::sync_with_stdio(false); // speed up for cin/cout
	int array[2000010];
	int in;
	while(cin >> in && in){
		for(int i = 0; i < in; i++){
			cin >> array[i];
		}
		sort(array, array + in);
		cout << array[0];
		for(int i = 1; i < in; i++){
			cout << ' ' << array[i];
		}
		cout << '\n';
	}
	return 0;
}