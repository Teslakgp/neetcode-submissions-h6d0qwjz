class Solution {
public:
bool checkInclusion(string s1, string s2) {
    if(s1.size()>s2.size())return 0;
    int freq[26]={};
    for(int i=0;i<s1.size();i++){
        freq[s1[i]-'a']++;
    }
    for(int j=0;j<s2.size();j++){
        freq[s2[j]-'a']--;

        if(j-(int)s1.size()>=0)freq[s2[j-s1.size()]-'a']++;
        bool is_perm=true;
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                is_perm=false;
                break;
            }
        }
        if(is_perm) return 1;
    
    }
    return 0;
}
};
