class Solution {
    // 202
    // Reference: cspiration
    public boolean isHappy(int n) {
        // Time: Unknown Space: O(n)
        HashSet<Integer> set = new HashSet<>();
        int squareSum, remain;
        while(set.add(n)) {
            squareSum = 0;
            while(n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n/= 10;
            }
            if(squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }
}