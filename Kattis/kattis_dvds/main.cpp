#include <iostream>

using namespace std;

int main()
{
    int k;
    cin >> k;
    for (int i = 0; i < k; i++) {
        long n;
        cin >> n;
        long temp = 1;
        for (long j = 0; j < n; j++) {
            long temp2;
            cin >> temp2;
            if (temp2 == temp) {
                temp++;
            }
        }
        cout << n - temp + 1 << '\n';
    }
    return 0;
}
