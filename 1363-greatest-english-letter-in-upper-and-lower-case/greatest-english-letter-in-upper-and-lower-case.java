class Solution {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        
        // store all characters
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        for (char ch = 'Z'; ch >= 'A'; ch--) {
            if (set.contains(ch) && set.contains(Character.toLowerCase(ch))) {
                return String.valueOf(ch);
            }
        }
        return "";
    }
}
