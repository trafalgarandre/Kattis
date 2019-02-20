#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    long long start = 2;
    for (int i = 0; i < n; i++) {
        start = (2 * start - 1);
    }
    cout << start * start;
    return 0;
}
