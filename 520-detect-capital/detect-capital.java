class Solution {
    public boolean detectCapitalUse(String w) {
        boolean flag = false;
        if(Character.isUpperCase(w.charAt(0))) {
            flag = true;
        }
        int c=0;
        for(int i=0;i<w.length();i++){
            char ch = w.charAt(i);
            if(Character.isLowerCase(w.charAt(i))) c++;
        }
        if(c==w.length()|| c==0) return true;
        if(flag && c==w.length()-1) return true;
        return false;
    }
}