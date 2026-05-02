class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            map.computeIfPresent(t.charAt(i), (k, v) -> (v == 1) ? null : v - 1);
        }
        for(int freq : map.values()){
            if(freq > 0){
                return false;
            }
        }
        return true;
    }
}
