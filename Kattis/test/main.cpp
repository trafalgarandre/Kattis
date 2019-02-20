#include<bits/stdc++.h>

using namespace std;
int main ()
{
  int a, b, c;
  //cur.pay = cur.pay + ceil(((double)perc) / (double)100 * cm[cur.car].p);
  a = 147;
  c = 100;
  cout << ceil((double)a / (double)100 * c) << endl;
  cout << (c * a + 99) / 100;
  return 0;
}
//cur.pay + ceil(((double)perc) / (double)100 * cm[cur.car].p);
//cur.pay + (perc * cm[cur.car].p + 99) / 100;
