#include <iostream>
#include <vector>
using namespace std;

typedef vector<char> vc;
typedef vector<vc> vcc;

struct ascii {
    vcc art = {{}, {}, {}, {}, {}, {}, {}};
};

bool cmp_ascii(ascii a, ascii b) {
    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 5; j++) {
            if (a.art[i][j] != b.art[i][j]) {
                return false;
            }
        }
    }
    return true;
}

void add_ascii(ascii a, ascii *b) {
    for (int i = 0; i < 7; i++) {
        b->art[i].insert(b->art[i].begin(), a.art[i].begin(), a.art[i].end());
    }
}

ascii all[11];

int main()
{
    vc row = {'x', 'x', 'x', 'x', 'x'};
    vc left = {'x', '.', '.', '.', '.'};
    vc right = {'.', '.', '.', '.', 'x'};
    vc both = {'x', '.', '.', '.', 'x'};
    vc emp = {'.', '.', '.', '.', '.'};
    vc mid = {'.', '.', 'x', '.', '.'};
    all[0].art = {row, both, both, both, both, both, row};
    all[1].art = {right, right, right, right, right, right, right};
    all[2].art = {row, right, right, row, left, left, row};
    all[3].art = {row, right, right, row, right, right, row};
    all[4].art = {both, both, both, row, right, right, right};
    all[5].art = {row, left, left, row, right, right, row};
    all[6].art = {row, left, left, row, both, both, row};
    all[7].art = {row, right, right, right, right, right, right};
    all[8].art = {row, both, both, row, both, both, row};
    all[9].art = {row, both, both, row, right, right, row};
    all[10].art = {emp, mid, mid, row, mid, mid, emp};
    ascii space;
    space.art = {{'.'}, {'.'}, {'.'}, {'.'}, {'.'}, {'.'}, {'.'}};
    string line[7];
    for (int i = 0; i < 7; i++) {
        cin >> line[i];
    }
    int pos = 0;
    int firstnum = 0;
    int secondnum = 0;
    bool isFirst = true;
    while (pos < line[0].length()) {
        ascii temp;
        for (int i = 0; i < 7; i++) {
            string str = line[i].substr(pos, pos + 5);
            for (int j = 0; j < 5; j++)
            temp.art[i].push_back(str[j]);
        }
        int val;
        for (int i = 0; i < 11; i++) {
            if (cmp_ascii(temp, all[i])) {
                val = i;
                break;
            }
        }
        if (val == 10) {
            isFirst = false;
        } else {
            if (isFirst) {
                firstnum = firstnum * 10 + val;
            } else {
                secondnum = secondnum * 10 + val;
            }
        }
        pos += 6;
    }
    firstnum += secondnum;
    ascii result;
    bool hasAdd = false;
    while (firstnum != 0) {
        int cur = firstnum % 10;
        add_ascii(all[cur], &result);
        if (firstnum / 10 != 0) {
            add_ascii(space, &result);
        }
        firstnum /= 10;
    }
    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < result.art[i].size(); j++) {
            cout << result.art[i][j];
        }
        if (i != 6) {
            cout << '\n';
        }
    }
    return 0;
}

