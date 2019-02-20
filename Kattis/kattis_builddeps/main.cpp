#include <vector>
#include <iostream>
#include <set>
#include <sstream>
#include <unordered_map>
#include <queue>

using namespace std;

struct file {
    vector<int> pars;
    int id;
    int left = 0;
    bool operator < (const file &other) const {
        if (left == other.left) {
            return id < other.id;
        } else {
        return left < other.left; }
    }
};


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    cin.ignore();
    file files[n];
    unordered_map<string, int> m1(n);
    unordered_map<int, string> m2(n);
    bool b[n];
    set<file> m;
    int id = 0;
    for (int i = 0; i < n; i++) {
        b[i] = true;
        files[i].id = i;
        string input;
        getline(cin, input);
        stringstream ss(input);
        string parent;
        ss >> parent;
        parent = parent.substr(0, parent.length() - 1);
        int p;
        if (m1.find(parent) == m1.end()) {
            m1.emplace(parent, id);
            m2.emplace(id, parent);
            p = id;
            id++;
        } else {
            p = m1[parent];
        }
        while (!ss.eof()) {
            string child;
            ss >> child;
            int c;
            if (m1.find(child) == m1.end()) {
                m1.emplace(child, id);
                m2.emplace(id, child);
                c = id;
                id++;
            } else {
                c= m1[child];
            }
            files[c].pars.push_back(p);
        }
    }
    string s;
    cin >> s;
    queue<file*> q;
    q.push(&files[m1[s]]);
    b[m1[s]] = false;
    while (!q.empty()) {
        file cur = *q.front();
        q.pop();
        m.insert(cur);
        for (auto itr: cur.pars) {
            if (b[itr]) {
                b[itr] = false;
                q.push(&files[itr]);
            }
            files[itr].left++;
        }
    }
/*
    while (!m.empty()) {
        cout << m.begin()->first << ' ' << m.begin()->second<<'\n';
        m.erase(m.begin());
    }
*/

    while (!m.empty()) {
        file cur = *m.begin();
        m.erase(m.begin());
        cout << m2[cur.id] << '\n';
        for (auto itr: cur.pars) {
            m.erase(files[itr]);
            files[itr].left--;
            m.insert(files[itr]);
        }
    }

    /*
    b[m1[s]] = true;
    while (!q.empty()) {
        file cur = *q.front();
        int temp = cur.id;
        q.pop();
        if (cur.left != 0) {
            q.push(&files[temp]);
        } else {
            cout << m2[cur.id] << '\n';
            for (auto itr: cur.pars) {
                if (!b[itr]) {
                    b[itr] = true;
                    q.push(&files[itr]);
                }
                files[itr].left--;
            }
        }

    }
    */
    return 0;
}
