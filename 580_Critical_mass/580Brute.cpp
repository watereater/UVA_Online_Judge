#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
	int in;
	while(cin >> in && in){
        int out = 0;
		for(int i = 0; i <= in; i++){
            vector<int> v;
            int j;
            for(j = 0; j < i; j++){
                v.push_back(0);
            }
            for(int k = j; k < in; k++){
                v.push_back(1);
            }
            do{
                int row = 0;
                for(int j = 0; j < in; j++){
                    if(v[j]) {
                        row++;
                        if(row == 3){
                            out++;
                            break;
                        }
                    }
                    else row = 0;
                }
            }
            while(next_permutation(v.begin(), v.end()));
            
		}
        cout << out << endl;
	}
	return 0;
}