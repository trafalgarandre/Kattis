#include<bits/stdc++.h>

using namespace std;

int main()
{
    unordered_map<string, double> hmap;
    hmap.insert({{"UTC", 0}, {"GMT", 0}, {"BST", 1}, {"IST", 1}
    , {"WET", 0}, {"WEST", 1}, {"CET", 1}, {"CEST", 2}, {"EET", 2},
    {"EEST", 3}, {"MSK", 3}, {"MSD", 4}, {"AST", -4}, {"ADT", -3},
    {"NST", -3.5}, {"NDT", -2.5}, {"EST", -5}, {"EDT", -4},
    {"CST", -6}, {"CDT", -5}, {"MST", -7}, {"MDT", -6},
    {"PST", -8}, {"PDT", -7}, {"HST", -10}, {"AKST", -9},
    {"AKDT", -8}, {"AEST", 10}, {"AEDT", 11}, {"ACST", 9.5},
    {"ACDT", 10.5}, {"AWST", 8}});
    int n;
    cin >> n;
    while (n--) {
        string s;
        cin >> s;
        int time = 24 * 60;
        if (s.compare("noon") == 0) {
            time += 12 * 60;
        } else if (s.compare("midnight") == 0) {
            time += 0;
        } else {
            string type;
            cin >> type;
            if (type.compare("p.m.") == 0) {
                time = time + 12 * 60;
            }
            int pos = 0;
            int hour = 0;
            while (s[pos] != ':') {
                hour = hour * 10 + s[pos] - '0';
                pos++;
            }
            if (hour == 12) {
                hour = 0;
            }
            pos++;
            time = time + hour * 60 + (s[pos] - '0') * 10 + (s[pos + 1] - '0');
        }
        string t1, t2;
        cin >> t1 >> t2;
        int dif = (hmap[t2] - hmap[t1]) * 60;
        time = (time + dif) % (24 * 60);
        int hour = time / 60;
        int minu = time % 60;
        if (hour == 0) {
            if (minu == 0) {
                printf("midnight\n");
            } else {
                hour = 12;
                printf("%d:%02d a.m.\n", hour, minu);
            }
        } else if (hour == 12) {
            if (minu == 0) {
                printf("noon\n");
            } else {
                printf("%d:%02d p.m.\n", hour, minu);
            }
        } else if (hour > 12) {
            hour %= 12;
            printf("%d:%02d p.m.\n", hour, minu);
        } else {
            printf("%d:%02d a.m.\n", hour, minu);
        }
    }
    return 0;
}
