#include<bits/stdc++.h>

using namespace std;

struct lane {
    int o, i, s;
    bool toR;
};

int l, w, pos, row, t;
vector<lane> lanes;


bool clash() {
    bool b[w] = {false};
    lane cur = lanes[row];
    if (cur.toR) {
        int posf = cur.o;
        for (int i = 0; i < t; i++) {
            posf += cur.s;
            if (posf >= cur.i) {
                posf -= cur.i;
            }
        }
        while (posf < w) {
            if (cur.s == 0) {
                b[posf] = true;
            } else {
                for (int i = 1; i <= cur.s; i++) {
                    if (posf + i >= w) {
                        continue;
                    }
                    b[posf + i] = true;
                }
            }
            posf += cur.i;
        }
    } else {
        int posf = w - cur.o - 1;
        for (int i = 0; i < t; i++) {
            posf -= cur.s;
            if (w - posf - 1 >=  cur.i) {
                posf += cur.i;
            }
        }
        while (posf >= 0) {
            if (cur.s == 0) {
                b[posf] = true;
            } else {
                for (int i = 1; i <= cur.s; i++) {
                    if (posf - i < 0) {
                        continue;
                    }
                    b[posf - i] = true;
                }
            }
            posf -= cur.i;
        }
    }
    return b[pos];
}

int main()
{
    cin >> l >> w;
    for (int i = 0; i < l ;i++) {
        lane temp;
        cin >> temp.o >> temp.i >> temp.s;
        if (i % 2 == 0) {
            temp.toR = true;
        } else {
            temp.toR = false;
        }
        lanes.push_back(temp);
    }

    row = l;
    cin >> pos;
    string dir;
    cin >> dir;
    bool result = false;
    t = 0;
    for (char c: dir) {
        if (c == 'U') {
            if (row == 0) {
                result = true;
                break;
            } else {
                row--;
                if (clash()) {
                    break;
                }
            }
        } else if (c == 'R') {
            if (pos != w - 1) {
                pos++;
            }
            if (row != l) {
                if (clash()) {
                    break;
                }
            }
        } else if (c == 'L') {
            if (pos != 0) {
                pos--;
            }
            if (row != l) {
                if (clash()) {
                    break;
                }
            }
        } else if (c == 'D') {
            if (row != l) {
                row++;
                if (clash()) {
                    break;
                }
            }
        }
        t++;
    }
    if (result) {
        cout << "safe";
    } else {
        cout << "squish";
    }
    return 0;
}
