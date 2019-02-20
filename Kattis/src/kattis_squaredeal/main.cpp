#include <iostream>

using namespace std;
int a[3][2], b[3], c[3];
bool result = false;

void check(int x) {
    if (x == 3) {
        if (b[0] == b[1] && b[1] == b[2]) {
            if (c[0] + c[1] + c[2] == b[0]) {
                result = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (2 * b[i] == b[0] + b[1] + b[2]) {
                if (c[i] + (c[(i + 1) % 3]) == b[i]) {
                    result = true;
                }
            }
        }
    } else {
        for (int i = 0; i < 2; i++) {
            b[x] = a[x][i];
            c[x] = a[x][1 - i];
            check(x + 1);
        }
    }
}

int main()
{
    for (int i = 0; i < 3; i++) {
        scanf("%d %d", &a[i][0], &a[i][1]);
    }

    check(0);

    (result) ? printf("YES") : printf("NO");
    return 0;
}
