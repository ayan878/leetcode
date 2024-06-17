package Medium._633.SumofSquareNumbers;

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        long left = 0;
        long right = (int) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int c=10;
        Solution solution=new Solution();
        System.out.println(solution.judgeSquareSum(c));
    }
}