#include <bits/stdc++.h>

using namespace std;

struct point {
    int x, y;
};

struct page {
    int w, h, x, y;
    point topleft;
    point topright;
    point botleft;
    point botright;
    int area;
    vector<int> cut;

    void getReady() {
        topleft.x = x;
        topleft.y = y;
        topright.x = x + w;
        topright.y = y;
        botleft.x = x;
        botleft.y = y + h;
        botright.x = x + w;
        botright.y = y + h;
        area = w * h;
    }
};

bool cut(page p1, page p2) {

    return !(p1.botleft.x >= p2.botright.x ||
     p1.botright.x <= p2.botleft.x ||
     p1.topleft.y >= p2.botleft.y ||
     p1.botleft.y <= p2.topleft.y );
}

int n;
page p[21];
//bool b[21][21];
int max_total = 0;
int max_now = 0;
bool c[21];

void greedy(int x, int total) {
    if (total > max_now) {
        max_now = total;
    }
    int i = x + 1;
    while (i < n) {

        if (max_total + total < max_now) {
            break;
        }
        if (c[i]) {
            c[i] = false;
            vector<int> change(20);
            for (int j : p[i].cut) {
                if (c[j]) {
                    c[j] = false;
                    change.push_back(j);
                    max_total -= p[j].area;
                }
            }

            max_total -= p[i].area;
            greedy(i, total + p[i].area);

            for (int j: change) {
                c[j] = true;
                max_total += p[j].area;
            }
        }
        i++;
    }
}

int main()
{
    scanf("%d", &n);
    while (n != 0) {
        max_now = 0;
        max_total = 0;
        for (int i = 0; i < n; i++) {
            scanf("%d %d %d %d", &p[i].w, &p[i].h, &p[i].x, &p[i].y);
            p[i].getReady();
            max_total += p[i].area;
        }

        for (int i = 0; i < n; i++) {
            c[i] = true;
            for (int j = i + 1; j < n; j++) {
                bool isCut = cut(p[i], p[j]);
                if (isCut) {
                    p[i].cut.push_back(j);
                }
                //b[i][j] = isCut;
                //b[j][i] = isCut;
            }
        }

        int temp = max_total;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[j] = true;
            }
            temp -= p[i].area;
            max_total = temp;

            vector<int> change(20);
            for (int j : p[i].cut) {
                c[j] = false;
                change.push_back(j);
                max_total -= p[j].area;
            }


            greedy(i, p[i].area);
        }
        printf("%d\n", max_now);
        scanf("%d", &n);
    }
    return 0;
}
