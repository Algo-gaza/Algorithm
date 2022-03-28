class Solution {
    public int solution(int n) {
        
        int answer_count = find_one(Integer.toString(n, 2));
        
        while(find_one(Integer.toString(++n, 2))!=answer_count) {};
        
        return n;
    }
    
    int find_one(String s) {
        int count=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='1') count++;
        }
        return count;
    }
}
