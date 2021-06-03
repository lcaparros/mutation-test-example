package lcaparros.examples.mutation;

public class Palindrome {
    public boolean isPalindrome(String inputString) {
        if (inputString.length() == 0) {
            return true;
        } else {
            if (inputString.length() > 1) {
                var firstChar = inputString.charAt(0);
                var lastChar = inputString.charAt(inputString.length() - 1);
                var mid = inputString.substring(1, inputString.length() - 1);
                return (firstChar == lastChar) && isPalindrome(mid);
            } else {
                return true;
            }
        }
    }
}
