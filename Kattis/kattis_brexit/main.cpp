#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;

int main()
{
    int c, p, x, l;
    cin >> c >> p >> x >> l;
    x--;l--;
    vvi AdjList;
    bool still_in[c];
    int org[c];
    int num[c];
    fill_n(still_in, c, true);
    fill_n(org, c, 0);
    fill_n(num, c, 0);
    AdjList.assign(c, {});
    for (int i = 0; i < p; i++) {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        temp1--;
        temp2--;
        AdjList[temp1].push_back(temp2);
        num[temp1]++;
        org[temp1]++;
        AdjList[temp2].push_back(temp1);
        num[temp2]++;
        org[temp2]++;
    }
    if (l == x) {
        cout << "leave";
    } else {
        queue<int> q;
        q.push(l);
        still_in[l] = false;
        while (!q.empty()) {
            int cur = q.front();
            if (cur == x) {
                break;
            }
            q.pop();
            for (int i: AdjList[cur]) {
                if (still_in[i]) {
                    num[i]--;
                    if (num[i] <= org[i] / 2) {
                        q.push(i);
                        still_in[i] = false;
                    }
                }
            }
        }
        if (still_in[x]) {
            cout << "stay";
        } else {
            cout << "leave";
        }
    }
    return 0;
}
