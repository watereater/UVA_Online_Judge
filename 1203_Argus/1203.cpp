#include<iostream>
#include<queue>
#include<vector>
#include<string>

using namespace std;

struct Register{
	int r, s, t;
	Register(int r, int s){
		this-> r = r;
		this-> s = s;
		t = s;
	}
};

class comp{
	public:
	bool operator() (const Register &lhs, const Register &rhs){
		if(lhs.t > rhs.t) return true;
		else if(lhs.t == rhs.t){
			if(lhs.r > rhs.r){
				return true;
			}
		}
		return false;
	}
};

int main(){
	ios_base::sync_with_stdio(false);
	string str;
	int r, s, output;
	priority_queue<Register, vector<Register>, comp> pq;
	while(cin >> str && str!="#"){
		cin >> r >> s;
		Register R(r, s);
		pq.push(R);
	}
	cin >> output;
	while(output-- > 0){
		Register R = pq.top();
		cout << R.r << '\n';
		R.t += R.s;
		pq.pop();
		pq.push(R);
	}
	return 0;
}