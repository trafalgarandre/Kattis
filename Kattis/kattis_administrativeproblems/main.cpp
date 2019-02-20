#include <bits/stdc++.h>

using namespace std;

struct car {
    int p, q, k;
};

struct per {
    bool pick = false;
    string car;
    bool inc = false;
    long long pay = 0;
};

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        unordered_map<string, car> cm(n);
        for (int i = 0; i < n; i++) {
            string name;
            car temp;
            cin >> name >> temp.p >> temp.q >> temp.k;
            cm.emplace(name, temp);
        }
        map<string, per> pm;
        for (int i = 0; i < m; i++) {
            int time;
            char e;
            string s;
            cin >> time >> s >> e;
            if (pm.find(s) == pm.end()) {
                per temp;
                pm.emplace(s, temp);
            }
            per& cur = pm[s];
            if (!cur.inc) {
                if (e == 'p') {
                    string C;
                    cin >> C;
                    if (cur.pick) {
                        cur.inc = true;
                    } else {
                        cur.car = C;
                        cur.pay += cm[C].q;
                        cur.pick = true;
                    }
                } else if (e == 'r') {
                    int d;
                    cin >> d;
                    if (!cur.pick) {
                        cur.inc = true;
                    } else {
                        cur.pay = cur.pay + cm[cur.car].k * d;
                        cur.pick = false;
                    }
                } else {
                    int perc;
                    cin >> perc;
                    if (!cur.pick) {
                        cur.inc = true;
                    } else {
                        cur.pay = cur.pay + (perc * cm[cur.car].p + 99) / 100;
                    }
                }
            } else {
                string temp;
                cin >> temp;
            }
        }
        for (map<string, per>::iterator it = pm.begin(); it != pm.end(); ++it) {
            cout << it->first << ' ';

            if (it->second.inc) {
                cout << "INCONSISTENT\n";
            } else {
                if (it->second.pick) {
                    cout << "INCONSISTENT\n";
                } else {
                    cout << it->second.pay << '\n';
                }
            }
        }
    }
    return 0;
}
