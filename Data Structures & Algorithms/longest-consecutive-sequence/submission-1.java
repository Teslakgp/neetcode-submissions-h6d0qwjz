class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> lcs = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            lcs.add(nums[i]);
        }
        for(int x : lcs){
            if(!lcs.contains(x - 1)){
                int current = x;
                int streak = 1;
                while(lcs.contains(current + 1)){
                    current++;
                    streak++;
                }
                ans = Math.max(streak, ans);
            }    
        }
        return ans;
    }
}
