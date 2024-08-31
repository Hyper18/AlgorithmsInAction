using namespace std;

#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>

class Solution {
public:
    string mostCommonWord(string paragraph, vector<string> &banned) {
        unordered_set <string> bannedSet;
        for (auto &word: banned) {
            bannedSet.emplace(word);
        }
        int maxF = 0;
        unordered_map<string, int> res;
        string word;
        int len = paragraph.length();
        for (int i = 0; i <= len; i++) {
            if (i < len && isalpha(paragraph[i])) {
                word.push_back(tolower(paragraph[i]));
            } else if (word.size() > 0) {
                if (!bannedSet.count(word)) {
                    res[word]++;
                    maxF = max(maxF, res[word]);
                }
                word = "";
            }
        }
        string mostF = "";
        for (auto &[word, frequency]: res) {
            if (frequency == maxF) {
                mostF = word;
                break;
            }
        }

        return mostF;
    }
};