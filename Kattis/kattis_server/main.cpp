#include <iostream>

using namespace std;

int main()
{
    int t, n;
    cin >> n >> t;
    int total = 0;
    bool stop = false;
    int c = 0;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        if (!stop) {
            if (total + temp > t) {
                stop = true;
            } else {
                c++;
                total += temp;
            }
        }
    }
    cout << c;
    return 0;
}
