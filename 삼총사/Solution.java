class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int number_len = number.length;
        for (int i = 0; i < number_len-2; ++i) {
            for (int j = i+1; j < number_len-1; ++j) {
                for (int k = j+1; k < number_len; ++k) {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }

        return answer;
    }
}
