class Solution {
    public boolean judgeCircle(String moves) {
        int right = 0, left = 0, up = 0, down = 0;
        
        for (char move : moves.toCharArray()) {
            if (move == 'R') right++;
            else if (move == 'L') left++;
            else if (move == 'U') up++;
            else if (move == 'D') down++;
        }
        
        return right == left && up == down;
    }
}
