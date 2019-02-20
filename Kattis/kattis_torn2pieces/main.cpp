#include <iostream>
#include <unordered_map>
#include <vector>
#include <sstream>

using namespace std;
typedef unordered_map<string, int> mi;
typedef unordered_map<int, string> im;
typedef pair<int, int> ii;
typedef vector<int> vi;
typedef vector<vi> vvi;

vi dfs_num;
vvi AdjList;
const int UNVISITED = -1;
const int VISITED = 1;
const int ROOT = -2;

bool ac = false;
int des;
int org;
mi s2i;
im i2s;

void dfs(int u, int prev);
void print(int cur);

int main()
{
    int n;
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        string l;
        getline(cin, l);
        stringstream ss(l);
        string first;
        ss >> first;
        int s;
        if (s2i.find(first) == s2i.end()) {
            s = s2i.size();
            AdjList.push_back({});
            s2i.emplace(first, s);
            i2s.emplace(s, first);
        } else {
            s = s2i[first];
        }

        while (!ss.eof()) {
            string cur;
            ss >> cur;
            int e;
            if (s2i.find(cur) == s2i.end()) {
                AdjList.push_back({});
                e = s2i.size();
                s2i.emplace(cur, e);
                i2s.emplace(e, cur);

            } else {
                e = s2i[cur];
            }
            AdjList[s].push_back(e);
            AdjList[e].push_back(s);
        }
    }
    dfs_num.assign(s2i.size(), UNVISITED);
    string l;
    getline(cin, l);
    stringstream ss(l);
    string s_org, s_des;
    ss >> s_org >> s_des;
    if (s2i.find(s_org) == s2i.end() || s2i.find(s_des) == s2i.end()) {
        cout << "no route found";
    } else {
        org = s2i[s_org];
        des = s2i[s_des];
        dfs(org, ROOT);
        if (!ac) {
            cout << "no route found";
        } else {
            print(des);
        }
    }
    return 0;
}

void dfs(int u, int prev) {
    if (!ac) {
        dfs_num[u] = prev;
        if (u == des) {
            ac = true;
            return;
        }
        for (int j = 0; j < AdjList[u].size(); j++) {
            int v = AdjList[u][j];
            if (dfs_num[v] == UNVISITED)
                dfs(v, u);
        }
    }
}

void print(int cur) {
    if (cur != org) {
        print(dfs_num[cur]);
        cout << " " << i2s[cur];
    } else {
        cout << i2s[cur];
    }
}
