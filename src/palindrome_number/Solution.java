package palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        // Convert the integer to a string
        String strX = Integer.toString(x);

        // Use two pointers to check if the string is a palindrome
        int left = 0, right = strX.length() - 1;
        while (left < right) {
            // Compare characters from both ends of the string
            if (strX.charAt(left) != strX.charAt(right)) {
                return false; // Not a palindrome
            }
            // Move the pointers towards the center
            left++;
            right--;
        }

        return true; // Palindrome
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPalindrome(121));   // Output: true
        System.out.println(solution.isPalindrome(-121));  // Output: false
        System.out.println(solution.isPalindrome(10));    // Output: false
    }
}
