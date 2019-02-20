#include <iostream>

using namespace std;


typedef long long ll;
int n, t;
int a[500][4];
ll f[500];

ll exec(int x) {
    if (f[x] != -1) {
        return f[x];
    } else if (a[x][3] == 1) {
        f[x] = 1;
        return f[x];
    } else if (a[x][3] == -1) {
        f[x] = 0;
        return f[x];
    } else {
        f[x] = exec(a[x][0]) + exec(a[x][1]) + exec(a[x][2]);
        return f[x];
    }
}

int main()
{

    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; i++) {
            int p;
            cin >> p;
            string s;
            cin >> s;
            p--;
            f[p] = -1;
            if (s[0] == 'f') {
                a[p][3] = 1;
            } else if (s[0] == 'c') {
                a[p][3] = -1;
            } else {
                a[p][3] = 0;
                a[p][0] = stoi(s) - 1;
                cin >> a[p][1] >> a[p][2];
                a[p][1]--;
                a[p][2]--;
            }
        }
        cout << exec(0) << '\n';
    }
    return 0;
}
