class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void subsets(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}