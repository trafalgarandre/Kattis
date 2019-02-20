#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> b;
int binarySearch(int val, int l, int r) {
    if (l >= r) {
        return l;
    } else {
        int mid = l + (r - l) / 2;
        if (b[mid] > val) {
            return binarySearch(val, l, mid - 1);
        } else if (b[mid] < val){
            return binarySearch(val, mid + 1, r);
        } else {
            return binarySearch (val, mid, mid);
        }
    }
}

int main()
{
    int n, c = 0;
    while (cin >> n) {
        c++;
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                b.push_back(a[i] + a[j]);
            }
        }
        sort(b.begin(), b.end());
        int m;
        cin >> m;
        cout << "Case " << c << ":\n";
        while (m--) {
            int temp;
            cin >> temp;
            int pos = binarySearch(temp, 0, b.size() - 1);
            int prev_val = 1000000000;
            if (pos > 0) {
                prev_val = abs(temp - b[pos - 1]);
            }
            int pos_val =  1000000000;
            if (pos < b.size() - 1) {
                pos_val = abs(temp - b[pos + 1]);
            }

            int cur_val = abs(temp - b[pos]);
            int mi = min(prev_val, min(cur_val, pos_val));
            if (mi == prev_val) {
                cout << "Closest sum to " << temp << " is " << b[pos - 1] << ".\n";
            } else if (mi == cur_val) {
                cout << "Closest sum to " << temp << " is " << b[pos] << ".\n";
            } else {
                cout << "Closest sum to " << temp << " is " << b[pos + 1] << ".\n";
            }
        }
    }
    return 0;
}
