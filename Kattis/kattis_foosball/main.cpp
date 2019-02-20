#include <bits/stdc++.h>

using namespace std;

struct team {
    string f;
    string s;
    int total;

    void print() {
        cout << f << ' ' << s << '\n';
    }
};

vector<team> teams = {};
int m_total = 0;

class Side {
    private: int total = 0;
    public: string of, df, f, s;
    Side(string s1, string s2) {
        of = s1;
        df = s2;
        f = s1;
        s = s2;
    }

    void win() {
        string temp = of;
        of = df;
        df = temp;
        total++;
        if (total > m_total) {
            m_total = total;
        }
    }

    string lose(string _s) {
        team temp;
        temp.f = f;
        temp.s = s;
        temp.total = total;
        teams.push_back(temp);
        total = 0;
        string lost = df;
        df = of;
        of = _s;
        f = df;
        s = of;
        return lost;
    }
};

int main()
{
    int n;
    cin >> n;
    queue<string> q = {};
    for (int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        q.push(temp);
    }
    string t1, t2, t3, t4;
    t1 = q.front();
    q.pop();
    t2 = q.front();
    q.pop();
    t3 = q.front();
    q.pop();
    t4 = q.front();
    q.pop();
    Side w(t1, t3);
    Side b(t2, t4);
    string s;
    cin >> s;
    char last;
    for (char& c: s) {
        if (c == 'W') {
            w.win();
            string add = b.lose(q.front());
            q.pop();
            q.push(add);
        } else {
            b.win();
            string add = w.lose(q.front());
            q.pop();
            q.push(add);
        }
        last = c;
    }
    if (last == 'W') {
        w.lose(q.front());
    } else {
        b.lose(q.front());
    }

    for (team t: teams) {
        if (t.total == m_total) {
            t.print();
        }
    }
    return 0;
}
