class Solution {
    // 204
    // Reference: cspiration
    public int countPrimes(int n) {
        // Time: O(loglogn) Space: O(n)
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for(int i = 2; i < n; i++) {
            if(notPrime[i] == false) {
                res++;
                for(int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
}