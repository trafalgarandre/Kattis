#include<bits/stdc++.h>

using namespace std;

int a[5];

void print() {
    cout << a[0];
    for (int i = 1; i < 5; i++) {
        cout << ' ' << a[i];
    }
    cout << '\n';
}

bool check() {
    for (int i = 0; i < 5; i++) {
        if (a[i] != i + 1) {
            return false;
        }
    }
    return true;
}

void op(int i, int j) {
    if (a[i] > a[j]) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
        print();
    }
}
int main()
{
    for (int i = 0; i < 5; i++) {
        cin >> a[i];
    }
    int i = 0;
    while (!check()) {
        op(i, i + 1);
        i = (i + 1) % 4;
    }
    return 0;
}
