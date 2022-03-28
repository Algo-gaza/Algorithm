class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        char[] c_arr = s.toCharArray();
        c_arr[0] = Character.toUpperCase(c_arr[0]);       
        for(int i=1; i<c_arr.length-1; i++) {
            if((int)c_arr[i]==32)
                c_arr[i+1] = Character.toUpperCase(c_arr[i+1]);
        }
        return String.valueOf(c_arr);
    }
}
