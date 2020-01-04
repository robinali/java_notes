class Solution {
    // 140
    // Reference: cspiration
    
    Map<Integer, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Time: O(n^3) Space: O(n^3)
        return dfs(s, wordDict, 0);
    }
    
    private List<String> dfs(String s, List<String> wordDict, int start) {
        if(map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start == s.length()) {
            res.add("");
        }
        for(int end = start + 1; end <= s.length(); end++) {
            if(wordDict.contains(s.substring(start, end))) {
                List<String> list = dfs(s, wordDict, end);
                for(String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}