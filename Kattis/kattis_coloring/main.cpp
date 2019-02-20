#include <bits/stdc++.h>

using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;

int n;
vvi v;
int a[11][11];
int main()
{
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        string s;
        getline(cin, s);
        v.push({});

        stringstream ss(s);
        while (!ss.eof()) {
            int temp;
            ss >> temp;
            v[i].push(temp);
        }
    }

    memset(a, 0, a[0][0] * n * n);
    return 0;
}
