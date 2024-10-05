class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        String str = new String();
        ans(num, target, list, str, 0, 0, 0);
        return list;
    }

    static void ans(String num, int target, List<String> list, String str, long temp, int idx, long mul) {
        if (idx == num.length()) {
            // If we've reached the end of the number, check if the calculated value matches the target
            if (temp == target) {
                list.add(str);
            }
            return;
        }

        // Iterate through each index in the input string 'num' to form different numbers
        for (int i = idx; i < num.length(); i++) {
            // If the current index is not the starting index 'idx' and the character at 'idx' is '0', break out of the loop
            if (i != idx && num.charAt(idx) == '0')
                break;

            // Extract the substring from 'num' starting at 'idx' up to the current index 'i'
            long numVal = Long.parseLong(num.substring(idx, i + 1));

            // If 'idx' is 0 (indicating the start of the string), consider only addition
            if (idx == 0) {
                ans(num, target, list, str + numVal, numVal, i + 1, numVal);
            } else {
                // Consider addition, subtraction, and multiplication operations recursively
                ans(num, target, list, str + "+" + numVal, temp + numVal, i + 1, numVal);
                ans(num, target, list, str + "-" + numVal, temp - numVal, i + 1, -numVal);
                ans(num, target, list, str + "*" + numVal, temp - mul + mul * numVal, i + 1, mul * numVal);
            }
        }
    }
}