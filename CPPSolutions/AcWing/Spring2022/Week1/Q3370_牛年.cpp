using namespace std;

#include <iostream>
#include <map>

long long n, i;
const string YEAR[13] = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig",
                         "Rat"};
string s[8];
map<string, long long> idxMap;

int main() {
    idxMap["Bessie"] = 0;
    cin >> n;
    while (n--) {
        for (i = 0; i < 8; i++) cin >> s[i];
        if ("previous" == s[3]) {
            for (i = idxMap[s[7]] - 1;; i--) {
                if (YEAR[(i % 12 + 12) % 12] == s[4]) {
                    break;
                }
            }
            idxMap[s[0]] = i;
        } else {
            for (i = idxMap[s[7]] + 1;; i++) {
                if (YEAR[(i % 12 + 12) % 12] == s[4]) {
                    break;
                }
            }
            idxMap[s[0]] = i;
        }
    }

    cout << abs(idxMap["Elsie"]) << endl;

    return 0;
}
