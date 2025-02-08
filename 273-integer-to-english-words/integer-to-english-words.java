class Solution {
    public String numberToWords(int num) {
        // Special case handling for zero
        if (num == 0) return "Zero";

        // Arrays for number conversion to words
        String[] ones = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String[] thousands = {
            "", "Thousand", "Million", "Billion"
        };

        // StringBuilder to accumulate the result
        StringBuilder result = new StringBuilder();

        // Process the number in chunks of 1000
        int groupIndex = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder temp = new StringBuilder();

                int hundreds = num % 1000;

                // Process hundreds place
                if (hundreds >= 100) {
                    temp.append(ones[hundreds / 100] + " Hundred ");
                    hundreds %= 100;
                }

                // Process tens and units place
                if (hundreds >= 20) {
                    temp.append(tens[hundreds / 10] + " ");
                    hundreds %= 10;
                }

                // Units or teens
                if (hundreds > 0) {
                    temp.append(ones[hundreds] + " ");
                }

                // Append the appropriate thousands unit
                temp.append(thousands[groupIndex] + " ");

                // Insert at the front to maintain the order from highest to lowest
                result.insert(0, temp.toString());
            }

            // Move to the next group of thousands
            num /= 1000;
            groupIndex++;
        }

        // Return the final string, trimming any excess spaces
        return result.toString().trim();
    }
}
