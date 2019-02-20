#include <iostream>

using namespace std;

int main()
{
    string n, m;
    cin >> n >> m;
    if (n.length() >= m.length()) {
        int pos = n.length() - m.length();
        for (int i =0 ; i <= pos; i++) {
            cout << n[i];
        }
        int pos2 = n.length() - 1;
        while (pos2 > pos && n[pos2] == '0') {
            pos2--;
        }
        if (pos != pos2) {
            cout << '.';
            for (int i = pos + 1; i <= pos2; i++) {
                cout << n[i];
            }
        }
    } else {
        cout << "0.";
        for (int i = 0; i < m.length() - n.length() - 1; i++) {
            cout << "0";
        }
        int pos = n.length() - 1;
        while (n[pos] == '0') {
            pos--;
        }
        for (int i = 0; i <= pos; i++) {
            cout << n[i];
        }
    }
    return 0;
}
