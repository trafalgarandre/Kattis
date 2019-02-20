#include <bits/stdc++.h>
#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int s, c;
    long k;
    cin >> s >> c >> k;
    long total = 0;
    long temp = 0;
    int a[s];
    if (c == 1) {
        total = s;
    } else {
        for (int i = 0; i < s; i++) {
            cin >> a[i];
        }
        sort(a, a + s);
        long diff;
        for (int i = 0; i < s; i++) {
            if (temp == 0) {
                total++;
                temp++;
                diff = a[i] + 2 * k;
            } else {
                if (a[i] <= diff) {
                    temp++;
                    if (temp == c) {
                        temp = 0;
                    }
                } else {
                    total++;
                    temp = 1;
                    diff = a[i] + 2 * k;
                }
            }
        }
    }
    cout << total;
    return 0;
}
