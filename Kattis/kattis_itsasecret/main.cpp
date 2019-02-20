#include <bits/stdc++.h>

using namespace std;

string removeSpaces(string str)
{
    str.erase(remove(str.begin(), str.end(), ' '), str.end());
    return str;
}

int main()
{
    int n;
    cin >> n;
    while (n != 0) {
        cin.ignore();
        string key;
        getline(cin, key);
        key = removeSpaces(key);
        bool check[26] = {false};
        char ca[5][5];
        int pos = 0;
        int pos2 = 0;
        vector<pair<int, int>> cpos(26);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                while (pos < key.length() && check[toupper(key[pos]) - 'A']) {
                    pos++;
                }
                if (pos < key.length()) {
                    if (toupper(key[pos]) == 'I') {
                        check['J' - 'A'] = true;
                    }
                    if (toupper(key[pos]) == 'J') {
                        check['J' - 'A'] = true;
                        ca[i][j] = 'I';
                    } else {
                        ca[i][j] = toupper(key[pos]);
                    }
                    check[ca[i][j] - 'A'] = true;
                    pos++;
                } else {
                    while (check[pos2]) {
                        pos2++;
                    }
                    ca[i][j] = (char)(pos2 + 'A');
                    check[pos2] = true;
                    pos2++;
                }
            }
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cpos[ca[i][j] - 'A'].first = i;
                cpos[ca[i][j] - 'A'].second = j;
            }
        }
        queue<pair<char, char>> q;
        for (int i = 0; i < n; i++) {
            string s;
            getline(cin, s);
            s = removeSpaces(s);
            pos = 0;
            while (pos < s.length()) {
                char first = toupper(s[pos]);
                if (first == 'J') {
                    first = 'I';
                }
                char second;
                if (pos + 1 == s.length()) {
                    second = 'X';
                    pos++;
                } else {
                    second = toupper(s[pos + 1]);
                    if (second == 'J') {
                        second = 'I';
                    }
                    if (second == first) {
                        second = 'X';
                        pos++;
                    } else {
                        pos += 2;
                    }
                }
                q.push(make_pair(first, second));
            }

            while (!q.empty()) {
                pair<char, char> cur = q.front();
                q.pop();
                if (cur.first == 'X' && cur.second == 'X') {
                    cout << "YY";
                } else {
                    int frow = cpos[cur.first - 'A'].first;
                    int fcol = cpos[cur.first - 'A'].second;
                    int srow = cpos[cur.second - 'A'].first;
                    int scol = cpos[cur.second - 'A'].second;
                    if (frow == srow) {
                        cout << ca[frow][(fcol + 1) % 5] << ca[frow][(scol + 1) % 5];
                    } else if (fcol == scol) {
                        cout << ca[(frow + 1) % 5][fcol] << ca[(srow + 1) % 5][fcol];
                    } else {
                        cout << ca[frow][scol] << ca[srow][fcol];
                    }
                }
            }
            cout << '\n';
        }
        cout << '\n';
        cin >> n;
    }
    return 0;
}
