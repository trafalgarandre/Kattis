#include<bits/stdc++.h>

using namespace std;

typedef int it;

struct line {
    it num;
    int type;
    string s;
};

vector<line> ls;
unordered_map<it, it> hmap;
int var[26] = {0};

bool cmp(line a, line b) {
    return a.num < b.num;
}

pair<int, int> returnVal(string cur, int pos) {
    int temp = 0;
    if (cur[pos] >= 'A' && cur[pos] <= 'Z') {
        temp = var[cur[pos] - 'A'];
        pos++;
    } else {
        bool isMinus = false;
        if (cur[pos] == '-') {
            isMinus = true;
            pos++;
        }
        while (pos < cur.length() && cur[pos] >= '0' && cur[pos] <= '9') {
            temp = temp * 10 + cur[pos] - '0';
            pos++;
        }
        if (isMinus) {
            temp = -temp;
        }
    }
    return make_pair(temp, pos);
}

void print(string cur) {
    int pos = 2;
    if (cur[1] == '"') {
        while (cur[pos] != '"') {
            printf("%c", cur[pos]);
            pos++;
        }
    } else {
        printf("%d", var[cur[1] - 'A']);
    }
}


void let(string cur) {
    int pos = 1;
    int left = cur[pos] - 'A';
    int temp = 0;
    pos += 4;
    pair<int, int> temp0 = returnVal(cur, pos);
    temp = temp0.first;
    pos = temp0.second;
    if (pos == cur.length()) {
        var[left] = temp;
    } else {
        int temp2 = 0;
        char type;
        pos++;
        type = cur[pos];
        pos+= 2;

        temp0 = returnVal(cur, pos);
        temp2 = temp0.first;
        pos = temp0.second;

        if (type == '+') {
            var[left] = temp + temp2;
        } else if (type == '-') {
            var[left] = temp - temp2;
        } else if (type == '*') {
            var[left] = temp * temp2;
        } else {
            var[left] = temp / temp2;
        }
    }
}

int doIf(string cur) {
    int pos = 1;
    int temp, temp1;
    string type;
    pair<int, int> temp0 = returnVal(cur, pos);
    temp = temp0.first;
    pos = temp0.second;

    pos++;
    if (cur[pos + 1] == ' ') {
        type = cur[pos];
        pos += 2;
    } else {
        type += cur[pos];
        type += cur[pos + 1];
        pos += 3;
    }

    temp0 = returnVal(cur, pos);
    temp1 = temp0.first;
    pos = temp0.second;

    bool isTrue = false;
    if (type == "=") {
        if (temp == temp1) {
            isTrue = true;
        }
    } else if (type == ">") {
        if (temp > temp1) {
            isTrue = true;
        }
    } else if (type == "<") {
        if (temp < temp1) {
            isTrue = true;
        }
    } else if (type == ">=") {
        if (temp >= temp1) {
            isTrue = true;
        }
    } else if (type == "<=") {
        if (temp <= temp1) {
            isTrue = true;
        }
    } else if (type == "<>") {
        if (temp != temp1) {
            isTrue = true;
        }
    }
    if (!isTrue) {
        return -1;
    } else {
        pos += 11;

        temp0 = returnVal(cur, pos);
        temp1 = temp0.first;
        return hmap[temp1];
    }
}

int main()
{
    string l;
    while (getline(cin, l)) {
        line temp;

        int pos = 0;
        temp.num = 0;
        while (l[pos] >= '0' && l[pos] <= '9') {
            temp.num = temp.num * 10 + l[pos] - '0';
            pos++;
        }
        pos++;
        if (l[pos] == 'P') {
            if (l[pos + 5] == 'L') {
                temp.type = 1;
                pos += 7;
            } else {
                temp.type = 0;
                pos += 5;
            }
        } else if (l[pos] == 'L') {
            temp.type = 2;
            pos += 3;
        } else {
            temp.type = 3;
            pos += 2;
        }
        temp.s = l.substr(pos);
        ls.push_back(temp);
    }

    sort(ls.begin(), ls.end(), cmp);

    for (int i = 0; i < ls.size(); i++) {
        hmap.emplace(ls[i].num, i);
    }

    int pos = 0;
    while (pos < ls.size()) {
        line cur = ls[pos];
        int type = cur.type;
        if (type == 0) {
            print(cur.s);
        } else if (type == 1) {
            print(cur.s);
            printf("\n");
        } else if (type == 2) {
            let(cur.s);
        } else {
            int res = doIf(cur.s);
            if (res != -1) {
                pos = res;
                continue;
            }
        }
        pos++;
    }

    return 0;
}
