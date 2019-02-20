#include <iostream>
#include <string.h>

using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string str;
        getline(cin, str);
        cout << str.length();
    }
    return 0;
}
