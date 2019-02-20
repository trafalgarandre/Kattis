#include <bits/stdc++.h>

using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;

class UnionFind {
    private:
        vi p, mrank, setSize;
        int numSets;
    public:
        UnionFind(int N) {
            setSize.assign(N, 1); numSets = N; mrank.assign(N, 0);
            p.assign(N, 0); for(int i = 0; i < N; i++) p[i] = i; }
       int findSet(int i) { return (p[i] == i) ? i : (p[i] = findSet(p[i])); }
        bool isSameSet(int i, int j) { return findSet(i) == findSet(j); }
        void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                numSets--;
                int x = findSet(i), y = findSet(j);
                if (mrank[x] > mrank[y]) { p[y] = x; setSize[x] += setSize[y]; }
                else                     { p[x] = y; setSize[y] += setSize[x];
                                            if (mrank[x] == mrank[y]) mrank[y]++; }
            }
        }
        int numDisjointSets() { return numSets;}
        int sizeOfSet(int i) { return setSize[findSet(i)]; }
};

unordered_map<string, int> hmap;
unordered_map<int, string> hmap2;
int order = 0;
vvi v(30000);
int b[30000];
bool c[30000];
int n;
UnionFind u(30000);

void dfs(int x) {
    for (int j: v[x]) {
        if (b[j] != - 1) {
            int cur = x;
            while (cur != j) {
                u.unionSet(cur, j);
                cur = b[cur];
            }
        } else if (!c[j]) {
            c[j] = true;
            b[j] = x;
            dfs(j);
            b[j] = -1;
        } else {
            int cur = x;
            bool same = false;
            while (cur != -2) {
                if (u.findSet(cur) == u.findSet(j)) {
                    same = true;
                    break;
                }
                cur = b[cur];
            }
            int cur2 = x;
            if (same) {
                while (cur2 != cur) {
                    u.unionSet(cur2, cur);
                    cur2 = b[cur2];
                }
            }
        }
    }
}

int main()
{
    cin >> n;

    for (int i = 0; i < n; i++) {
        string s1, s2;
        int i1, i2;
        cin >> s1 >> s2;
        if (hmap.find(s1) == hmap.end()) {
            hmap.emplace(s1, order);
            hmap2.emplace(order, s1);
            b[order] = -1;
            c[order] = false;
            order++;
        }
        if (hmap.find(s2) == hmap.end()) {
            hmap.emplace(s2, order);
            hmap2.emplace(order, s2);
            b[order] = -1;
            c[order] = false;
            order++;
        }
        i1 = hmap[s1];
        i2 = hmap[s2];
        v[i1].push_back(i2);
    }

    for (int i = 0; i < order; i++) {
        if (!c[i]) {
            c[i] = true;
            b[i] = -2;
            dfs(i);
            b[i] = -1;
        }
    }

    vector<string> ok;
    vector<string> avoid;
    vvi group(order);

    for (int i = 0; i < order; i++) {
        group[u.findSet(i)].push_back(i);
    }

    for (int i = 0; i < order; i++) {
        if (group[i].size() == 1) {
            avoid.push_back(hmap2[group[i][0]]);
        } else if (group[i].size() != 0) {
            vector<string> vs;
            for (int j: group[i]) {
                vs.push_back(hmap2[j]);
            }
            sort(vs.begin(), vs.end());
            vector<char> vc(20000);
            for (string j: vs) {
                vc.push_back(' ');
                for (char ch: j) {
                    vc.push_back(ch);
                }
            }

            string s(vc.begin(), vc.end());
            ok.push_back(s);
        }
    }
    sort(ok.begin(), ok.end());
    sort(avoid.begin(), avoid.end());
    for (int i = 0; i < ok.size(); i++) {
        cout << "okay" << ok[i];
        if (i != ok.size() - 1) {
            cout << "\n";
        }
    }
    if (!avoid.empty()) {
        if (!ok.empty()) cout << "\n";
        cout << "avoid";
        for (string s: avoid) {
            cout << " " << s;
        }
    }
    return 0;
}
