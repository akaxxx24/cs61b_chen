

public class Palindrome {
    public Deque<Character> wordToDeque(String word){

        Deque<Character> dq = new ArrayDeque<>();
        int length = word.length();
        char tmp;
        for (int i = 0; i < length; i++){
            tmp = word.charAt(i);
            dq.addLast(tmp);
        }
        return dq;
    }

    private int isPalindromeHelp(Deque d){
        int tmp = 0;
        if ((d.size() == 0) || (d.size() == 1))
        {
            tmp = 1;
            return tmp;
        }
        if (d.removeFirst() == d.removeLast())
        {
            tmp = isPalindromeHelp(d);
        }
        return tmp;
    }

    public boolean isPalindrome(String word){

        Deque dq = wordToDeque(word);
        int tmp = isPalindromeHelp(dq);
        return tmp == 1;
    }

    public int isOffByOnePalindromeHelp(Deque<Character> d, CharacterComparator c){
        int tmp = 0;
        if ((d.size() == 0) || (d.size() == 1))
        {
            tmp = 1;
            return tmp;
        }
        if (c.equalChars(d.removeFirst(), d.removeLast()))
        {
            tmp = isOffByOnePalindromeHelp(d, c);
        }
        return tmp;

    }


    public boolean isPalindrome(String word, CharacterComparator cc){

        Deque<Character> dq = wordToDeque(word);
        int tmp = isOffByOnePalindromeHelp(dq, cc);
        return tmp == 1;
    }





}
