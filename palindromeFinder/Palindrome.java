public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque dq = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            dq.addLast(currentChar);
        }
        return dq;
    }

    /**
    The isPalindrome method returns true if the given word
    is a palindrome, and false otherwise. A palindrome is defined as
    a word that is the same whether it is read forwards or backwards.
    For example “a”, “racecar”, and “noon” are all palindromes.
    “horse”, “rancor”, and “aaaaab” are not palindromes.
    Any word of length 1 or 0 is a palindrome.
     ‘A’ and ‘a’ should not be considered equal.
     */
    private boolean isPalindromeItter(String word) {
        Deque dq = wordToDeque(word);
        int wordSize = word.length();
        if (wordSize <= 1) {
            return true;
        }
        while (wordSize > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                return false;
            }
            wordSize = wordSize - 2;
        }
        return true;
    }


    public boolean isPalindrome(String word) {
        Deque dq = wordToDeque(word);
        return isPalindromeHelper(dq);
    }

    private boolean isPalindromeHelper(Deque dq) {
        if (dq.size() <= 1) {
            return true;
        }
        if (!dq.removeFirst().equals(dq.removeLast())) {
            return false;
        }
        return isPalindromeHelper(dq);
    }

    //Returns true for a "one-off" palindrome only.
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int wordSize = word.length();
        int i = 0;
        if (wordSize <= 1) {
            return true;
        }
        while (wordSize > 1) {
            char left = word.charAt(i);
            char right = word.charAt(word.length() - 1 - i);
            if (!cc.equalChars(left, right)) {
                return false;
            }
            i++;
            wordSize = wordSize - 2;
        }
        return true;
    }

}
