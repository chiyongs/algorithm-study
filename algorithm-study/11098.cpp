//
//  main.cpp
//  algorithm-study
//
//  Created by chiyong on 2021/03/11.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    cin >> n;
    for(int i = 0; i < n ; i++) {
        int p = 0;
        cin >> p;
        long prev=0;
        string info[p];
        int key=0;
        for(int j = 0; j < p ; j++) {
            long cost;
            string name;
            cin >> cost >> name;
            info[j] = name;
            if(j==0) prev = cost;
            else {
                if(cost > prev) {
                    prev = cost;
                    key = j;
                }
            }
        }
        cout << info[key] << '\n';
    }
    return 0;
}
