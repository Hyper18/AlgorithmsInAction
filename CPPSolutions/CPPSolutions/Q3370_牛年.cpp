using namespace std;
#include <iostream>
#include <map>

long long n, i, x;
const string an[13] = { "Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat" };
string s[8];
map<string, long long> year;

int main()
{
    year["Bessie"] = 0;
    cin >> n;
    while (n--) {
        for (i = 0; i < 8; i++) cin >> s[i];
        if ("previous" == s[3]) {
            for (i = year[s[7]] - 1;; i--)   if (an[(i % 12 + 12) % 12] == s[4]) break;
            year[s[0]] = i;
        }
        else {
            for (i = year[s[7]] + 1;; i++)   if (an[(i % 12 + 12) % 12] == s[4]) break;
            year[s[0]] = i;
        }
    }
    cout << abs(year["Elsie"]) << endl;

    return 0;
}
