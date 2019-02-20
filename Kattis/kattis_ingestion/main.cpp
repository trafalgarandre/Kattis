#include <iostream>

using namespace std;
int n, m;
int a[102], b[102], f[200][200][2];

int main()
{
    cin >> n >> m;
    int order = 0;
    while (m != 0) {
        a[order] = m;
        m = m * 2 / 3;
        order++;
    }
    a[order] = 0;
    for (int i = 0; i < n; i++) {
        cin >> b[i];
    }

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= order; j++) {
            for (int k = 0; k < 2; k++) {
                f[i][j][k] = -1;
            }
        }
    }
    f[0][0][0] = 0;
    int ma = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= order; j++) {
            for (int k = 0; k < 2; k++) {
                if (k == 0) {
                    if (j == 0) {
                        f[i][j][k] = f[i - 1][j][k];
                        for (int l = 0; l <= order; l++) {
                            f[i][j][k] = max(f[i - 1][l][1], f[i][j][k]);
                        }
                    } else {
                        if (f[i - 1][j - 1][0] != -1) {
                            f[i][j][k] = f[i - 1][j - 1][0] + min(a[j - 1], b[i - 1]);
                        }
                        if (f[i - 1][j - 1][1] != -1) {
                            f[i][j][k] = max(f[i][j][k], f[i - 1][j - 1][1] + min(a[j - 1], b[i - 1]));
                        }
                    }
                } else if (k == 1) {
                    f[i][j][k] = f[i - 1][j + 1][0];
                }
                if (f[i][j][k] > ma) {
                    ma = f[i][j][k];
                }
            }
        }
    }
    cout << ma;
    return 0;
}
