#include <iostream>

using namespace std;

struct Node {
    int prev = -1;
    int max_height;
};

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int m;
        cin >> m;
        Node a[m + 1][1001];
        a[0][0].prev = 0;
        a[0][0].max_height = 0;
        for (int j = 0; j < m; j++) {
            int dis;
            cin >> dis;
            for (int k = 0; k < 1001; k++) {
                if (a[j][k].prev != -1) {
                    int up_height = k + dis;
                    int new_max_height = max(a[j][k].max_height, up_height);
                    if (a[j + 1][up_height].prev == -1) {
                        a[j + 1][up_height].prev = k;
                        a[j + 1][up_height].max_height = new_max_height;
                    } else if (new_max_height < a[j + 1][up_height].max_height) {
                        a[j + 1][up_height].prev = k;
                        a[j + 1][up_height].max_height = new_max_height;
                    }
                    int down_height = k - dis;
                    if (down_height >= 0) {
                        if (a[j + 1][down_height].prev == -1) {
                            a[j + 1][down_height].prev = k;
                            a[j + 1][down_height].max_height = a[j][k].max_height;
                        } else if (a[j][k].max_height < a[j + 1][down_height].max_height) {
                            a[j + 1][down_height].prev = k;
                            a[j + 1][down_height].max_height = a[j][k].max_height;
                        }
                    }
                }
            }
        }
        if (a[m][0].prev == -1) {
            cout << "IMPOSSIBLE\n";
        } else {
            char track[m];
            int j = m;
            int k = 0;
            while (j > 0) {
                if (a[j][k].prev < k) {
                    track[j - 1] = 'U';
                } else {
                    track[j - 1] = 'D';
                }
                k =  a[j][k].prev;
                j--;
            }
            for (int l = 0; l < m; l++) {
                cout << track[l];
            }
            cout << endl;
        }
    }
    return 0;
}
