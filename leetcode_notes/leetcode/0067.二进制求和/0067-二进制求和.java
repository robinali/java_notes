class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int reminder = 0;
        while(i >= 0 || j >= 0){
            int sum = reminder;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            reminder = sum / 2;
        }
        if(reminder != 0) {
            sb.append(reminder);
        }
        return sb.reverse().toString();
    }
}