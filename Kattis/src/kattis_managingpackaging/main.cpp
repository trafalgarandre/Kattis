#include <bits/stdc++.h>

using namespace std;

typedef vector<int> vi;
typedef vector<vector<int>> vvi;

struct Node {
    int id;
    string name;
    int in = 0;
    bool operator<(const Node& rhs) const
    {
        if (in == rhs.in) {
            return name < rhs.name;
        } else {
            return in < rhs.in;
        }
    }
};

int main()
{
    int n;
    cin >> n;
    unordered_map<string, int> hmap;

    while (n != 0) {
        vvi v(n);
        bool b[n];
        cin.ignore();
        int order = 0;
        Node node[n];
        string input;
        hmap.clear();
        //v.assign(n, {});
        for (int i = 0; i < n; i++) {
            v.push_back({});
        }

        for (int i = 0; i < n; i++) {
            getline(cin, input);
            stringstream ss(input);
            string s1, s2;
            ss >> s1;
            int i1, i2;
            if (hmap.find(s1) == hmap.end()) {
                hmap.emplace(s1, order);
                node[order].id = order;
                node[order].name = s1;
                b[order] = false;
                order++;
            }
            i1 = hmap[s1];
            while (!ss.eof()) {
                ss >> s2;
                if (hmap.find(s2) == hmap.end()) {
                    hmap.emplace(s2, order);
                    node[order].id = order;
                    node[order].name = s2;
                    b[order] = false;
                    order++;
                }
                i2 = hmap[s2];
                v[i2].push_back(i1);
                node[i1].in++;
            }
        }
        set<Node> pq;
        for (int i = 0; i < order; i++) {
            pq.insert(node[i]);
        }

        queue<string> q;
        while (!pq.empty() && (*pq.begin()).in == 0) {
            Node cur = *pq.begin();
            q.push(cur.name);
            b[cur.id] = true;
            pq.erase(pq.begin());
            for (int i: v[cur.id]) {
                if (!b[i]) {
                    pq.erase(node[i]);
                    node[i].in--;
                    pq.insert(node[i]);
                }
            }
        }
        if (!pq.empty()) {
            cout << "cannot be ordered\n";
        } else {
            while (!q.empty()) {
                cout << q.front() << '\n';
                q.pop();
            }
        }
        cin >> n;
        if (n != 0) {
            cout << '\n';
        }
    }
    return 0;
}
