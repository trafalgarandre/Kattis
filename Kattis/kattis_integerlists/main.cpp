#include <iostream>
#include <list>
#include <sstream>
using namespace std;

int main()
{
    //ios_base::sync_with_stdio(false);
    //cin.tie(NULL);
    int t, n;
    string p;
    list<int> l;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> p;
        string s;
        int temp;
        cin >> n;
        cin.ignore();
        getline(cin, s);
        stringstream ss(s);
        ss.ignore();
        while (ss >> temp) {
            l.push_back(temp);
            if (ss.peek() == ',' || ss.peek() == ']') {
                ss.ignore();
            }
        }
        bool is_front = true;
        bool error = false;
        for (char& c: p) {
            if (c == 'R') {
                is_front = !is_front;
            } else {
                if (l.empty()) {
                    error = true;
                    break;
                }
                if (is_front) {
                    l.pop_front();
                } else {
                    l.pop_back();
                }
            }
        }
        if (error) {
            cout << "error\n";
        } else {
            printf("[");
            if (!l.empty()) {
                if (is_front) {
                    printf("%i", l.front());
                    l.pop_front();
                    while (!l.empty()) {
                        printf(",%i", l.front());
                        l.pop_front();
                    }
                } else {
                    printf("%i", l.back());
                    l.pop_back();
                    while (!l.empty()) {
                        printf(",%i", l.back());
                        l.pop_back();
                    }
                }
            }
            printf("]\n");
        }
    }
    return 0;
}
