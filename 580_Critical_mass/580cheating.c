#include<stdio.h>

int main(){
	int arr[] = {0, 0, 0, 1, 3, 8, 20, 47, 107, 238, 520, 1121, 2391, 5056, 10616, 22159, 46023, 95182, 196132, 402873, 825259, 1686408, 3438828, 6999071, 14221459, 28853662, 58462800, 118315137, 239186031, 483072832, 974791728};
	int in;
	while(scanf("%d", &in) && in){
		printf("%d\n", arr[in]);
	}	
	return 0;
}