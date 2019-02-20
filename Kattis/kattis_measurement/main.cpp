#include <iostream>

using namespace std;

int main()
{
    double a[8] = {1, 1000, 12, 3, 22, 10, 8, 3};
    double b[8];
    string str[8] = {"th", "in", "ft", "yd", "ch", "fur", "mi", "lea"};
    string str2[8] = {"thou", "inch", "foot", "yard", "chain", "furlong", "mile", "league"};
    b[0] = 1;
    for (int i = 1; i < 8; i++) {
        b[i] = b[i - 1] * a[i];
    }
    string s1, s2, s3;
    double result;
    cin >> result;
    cin >> s1 >> s2 >> s3;
    for (int i = 0; i < 8; i++) {
        if (s1.compare(str[i]) == 0 || s1.compare(str2[i]) == 0) {
            result *= b[i];
            break;
        }
    }
    for (int i = 0; i < 8; i++) {
        if (s3.compare(str[i]) == 0 || s3.compare(str2[i]) == 0) {
            result /= b[i];
            break;
        }
    }
    printf("%.9f", result);
    return 0;
}
