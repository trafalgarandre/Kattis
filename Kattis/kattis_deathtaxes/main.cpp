#include <iostream>

using namespace std;

int main()
{
    string s;
    double shares = 0;
    double cost = 0;
    while (cin >> s) {
        if (s.compare("buy") == 0) {
            double x, y;
            cin >> x >> y;
            double temp = shares;
            shares += x;
            cost = (x * y + temp * cost) / shares;
        } else if (s.compare("sell") == 0) {
            double x, y;
            cin >> x >> y;
            shares -= x;
            if (shares == 0) {
                cost = 0;
            }
        } else if (s.compare("split") == 0) {
            double x;
            cin >> x;
            shares *= x;
            cost /= x;
        } else if (s.compare("merge") == 0) {
            int x;
            double temp = shares;
            cin >> x;
            shares = (int)shares / x;
            cost *= x;
            if (shares == 0) {
                cost = 0;
            }
        } else if (s.compare("die") == 0){
            double y;
            cin >> y;
            if (y <= cost) {
                cout << shares * y;
            } else {
                cout << fixed;
                cout.precision(3);
                cout << shares * (y - (y - cost) * 0.3);
            }
        }
    }
    return 0;
}
