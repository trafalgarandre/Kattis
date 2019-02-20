#include <iostream>
#include <string.h>
#include <math.h>
using namespace std;

int findGCD(int num1, int num2) {
    if (num2 == 0) {
        return num1;
    }
    return findGCD(num2, num1 % num2);
}

int main()
{
    int n;
    cin >> n;
    while (n != 0) {
        int l = -1;
        int g = 0;
        int d = 1;
        for (int i = 0; i < n; i++) {
            string s;
            cin >> s;
            string t;
            cin >> t;
            cin >> t;
            if (s[0] == 'l') {
                int temp = stoi(t);
                if (temp < l || l == -1) {
                    l = temp;
                }
            } else if (s[0] == 'g') {
                int temp = stoi(t);
                if (temp > g) {
                    g = temp;
                }
            } else {
                int temp = stoi(t);
                int n1 = findGCD(temp, d);

                d = (d * temp) / n1;
            }
        }
        if (l == -1) {
            cout << "infinite\n";
        } else {
            int low = (int)floor((double)g / (double)d) + 1;
            int high = (int)ceil((double)l / (double)d) - 1;
            if (low > high) {
                cout << "none\n";
            } else {
                for (int j = low; j <= high; j++) {
                    cout << d * j << " ";
                }
                cout <<'\n';
            }
        }
        cin >> n;
    }
    return 0;
}
