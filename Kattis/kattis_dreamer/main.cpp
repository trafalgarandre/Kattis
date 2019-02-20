#include <iostream>
#include <set>
#include <string.h>

using namespace std;

char c[8];
char d[8];
bool b[8];
int total;
set<string> database;
string minBash;
bool smaller(string s);
bool check();
void execute(int pos);


int main()
{
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        for (int j = 0; j < 8; j++) {
            b[j] = false;
        }
        database.clear();
        minBash = "31 12 9999";
        total = 0;
        string s;
        cin >> s;
        c[0] = s[0];
        c[1] = s[1];
        cin >> s;
        c[2] = s[0];
        c[3] = s[1];
        cin >> s;
        c[4] = s[0];
        c[5] = s[1];
        c[6] = s[2];
        c[7] = s[3];
        execute(0);
        if (total == 0) {
            cout << 0 << '\n';
        } else {
            cout << total << ' ' << minBash << '\n';
        }
    }
    return 0;
}

void execute(int pos) {
    if (pos == 8) {
        if (check()) {
            char result[11];
            result[0] = d[0];
            result[1] = d[1];
            result[2] = ' ';
            result[3] = d[2];
            result[4] = d[3];
            result[5] = ' ';
            result[6] = d[4];
            result[7] = d[5];
            result[8] = d[6];
            result[9] = d[7];
            result[10] = '\0';
            string temp = result;
            if (database.find(temp) == database.end()) {
                total++;
                database.insert(temp);
                if (smaller(temp)) {
                    minBash = temp;
                }
            }
        }
    } else {
        string result;
        for (int i = 0; i < 8; i++) {
            if (!b[i]) {
                b[i] = true;
                d[pos] = c[i];
                execute(pos + 1);
                b[i] = false;
            }
        }
    }
}

bool smaller(string s) {
    int year1 = stoi(s.substr(6, 4));
    int month1 = stoi(s.substr(3, 2));
    int day1 = stoi(s.substr(0, 2));
    int year2 = stoi(minBash.substr(6, 4));
    int month2 = stoi(minBash.substr(3, 2));
    int day2 = stoi(minBash.substr(0, 2));
    if (year1 == year2) {
        if (month1 == month2) {
            if (day1 < day2) {
                return true;
            } else {
                return day1 < day2;
            }
        } else {
            return month1 < month2;
        }
    } else {
        return year1 < year2;
    }
}

bool check() {
    int year = (d[4] - '0') * 1000 + (d[5] - '0') * 100
            + (d[6] - '0') * 10 + d[7] - '0';
    if (year < 2000) {
        return false;
    }
    int month = (d[3] - '0') + (d[2] - '0') * 10;
    if (month > 12 || month == 0) {
        return false;
    }
    int day = (d[1] - '0') + (d[0] - '0') * 10;
    if (day > 31 || day == 0) {
        return false;
    }
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
    || month == 10 || month == 12) {
        return true;
    } else if (month == 2) {
        bool isLeap;
        if (year % 400 == 0) {
            isLeap = true;
        } else if (year % 100 == 0) {
            isLeap = false;
        } else if (year % 4 == 0) {
            isLeap = true;
        } else {
            isLeap = false;
        }
        if (isLeap) {
            if (day <= 29) {
                return true;
            } else {
                return false;
            }
        } else {
            if (day <= 28) {
                return true;
            } else {
                return false;
            }
        }
    } else {
        if (day <= 30) {
            return true;
        } else {
            return false;
        }
    }
}
