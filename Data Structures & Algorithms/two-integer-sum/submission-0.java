class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            if(indices.containsKey(diff)){
                return new int[]{indices.get(diff), i};
            }
            indices.put(num, i);
        }
        return new int[0];
    }
}
