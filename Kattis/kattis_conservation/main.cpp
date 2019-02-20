#include <bits/stdc++.h>

using namespace std;

struct Node {
    vector<int> pars;
    int left = 0;
    int id;
};

struct CmpNode {
    bool operator()(const Node* lhs, const Node* rhs) const
    {
        if (lhs->left == rhs->left) {
            return lhs->id < rhs->id;
        } else {
        return lhs->left < rhs->left;
        }
    }
};

int main()
{
    int t;
    scanf("%d", &t);
    while (t--) {
        int n, m;
        scanf("%d %d", &n, &m);
        Node nodes[n], nodes2[n];
        bool b[n];
        set<Node*, CmpNode> pq[2], pqb[2];
        for(int i = 0; i < n; i++) {
            nodes[i].id = i;
            nodes2[i].id = i;
            int temp;
            scanf("%d", &temp);
            if (temp == 1) {
                b[i] = true;
            } else {
                b[i] = false;
            }
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            scanf("%d %d", &a, &b);
            a--;
            b--;
            nodes[a].pars.push_back(b);
            nodes[b].left++;
            nodes2[a].pars.push_back(b);
            nodes2[b].left++;
        }

        for(int i = 0; i < n; i++) {
            if (b[i]) {
                pq[0].insert(&nodes[i]);
                pqb[0].insert(&nodes2[i]);
            } else {
                pq[1].insert(&nodes[i]);
                pqb[1].insert(&nodes2[i]);
            }
        }

        int total = 0;
        int left = n;
        int id = 0;
        while (left != 0) {
            while (!pq[id].empty() && (*pq[id].begin())->left == 0) {
                Node* cur = *pq[id].begin();
                pq[id].erase(cur);
                left--;
                for (int i: cur->pars) {
                    if (b[i]) {
                        pq[0].erase(&nodes[i]);
                        nodes[i].left--;
                        pq[0].insert(&nodes[i]);
                    } else {
                        pq[1].erase(&nodes[i]);
                        nodes[i].left--;
                        pq[1].insert(&nodes[i]);
                    }
                }
            }
            if (left != 0) {
                total++;
                id = 1 - id;
            }
        }
        int minx = total;
        total = 0;
        left = n;
        id = 1;
         while (left != 0) {
            while (!pqb[id].empty() && (*pqb[id].begin())->left == 0) {
                Node* cur = *pqb[id].begin();
                pqb[id].erase(cur);
                left--;
                for (int i: cur->pars) {
                    if (b[i]) {
                        pqb[0].erase(&nodes2[i]);
                        nodes2[i].left--;
                        pqb[0].insert(&nodes2[i]);
                    } else {
                        pqb[1].erase(&nodes2[i]);
                        nodes2[i].left--;
                        pqb[1].insert(&nodes2[i]);
                    }
                }
            }
            if (left != 0) {
                total++;
                id = 1 - id;
            }
        }
        if (total < minx) {
            printf("%d\n", total);
        } else {
            printf("%d\n", minx);
        }
    }
    return 0;
}

