class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        if(n==0){
            return tasks.size();
        }

        n++;
        int freq[26]={};
        for(auto i:tasks){
            freq[i-'A']++;
        }
        int max_freq=0,count=0;
        for(auto i:freq){
            if(i>max_freq){
                max_freq=i;
                count=1;
            }else if(i==max_freq){
                count++;
            }
        }
        int ans = n*(max_freq-1) + 1 + (count-1);
        return max(ans,(int)tasks.size());
    }
};
