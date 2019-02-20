#include <iostream>

using namespace std;

int main()
{
    int p;
    cin >> p;
    while (p--) {
        int k, b, n;
        cin >> k >> b >> n;
        int total = 0;
        while (n != 0) {
            int mod = n % b;
            total += (mod * mod);
            n /= b;
        }
        cout << k << " " << total << '\n';
    }
    return 0;
}
