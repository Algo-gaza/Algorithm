class Solution {
    public long solution(double w, double h) {
        long answer = (long)w * (long)h;
        for(int i = 0; i < w; i++){
            double cnt = 0;
            // i * (h / w) 내림 숫자부터 (i + 1) * (h / w) 올림 숫자 사이의 숫자 개수 - 1
            // cnt = Math.ceil((double)(i + 1) * (h / w)) - Math.floor((double)i * (h / w));
            // 이렇게 하면 왜 6번 케이스가 틀릴까?
            cnt = Math.ceil((i + 1) * h / w) - Math.floor(i * h / w);
            answer -= (long)cnt;
        }
        return answer;
    }
}
