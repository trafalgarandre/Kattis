#include <iostream>
#include <queue>
using namespace std;

int main()
{
    char c;
    int pos = 0;
    int r_pos = 0;
    long total = 0;
    queue<char> rest;
    string s;
    cin >> s;
    for (char c: s) {
        if (c != '0') {
            rest.push(c);
        } else {
            total = total + (pos - r_pos);
            r_pos++;
        }
        pos++;
    }
    pos = 0;
    r_pos = 0;
    while (!rest.empty()) {
        char cur = rest.front();
        rest.pop();
        if (cur == '1') {
            total = total + (pos - r_pos);
            r_pos++;
        }
        pos++;
    }
    cout << total;
    return 0;
}
