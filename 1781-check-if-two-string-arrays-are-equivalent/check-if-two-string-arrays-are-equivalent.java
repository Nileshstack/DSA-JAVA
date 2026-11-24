class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        int i=0;
        int j=0;
        int w1i=0;
        int w2j=0;
        while(w1i<w1.length && w2j<w2.length){
            if(w1[w1i].charAt(i)!=w2[w2j].charAt(j)) return false;
            i++;
            j++;
            if(j==w2[w2j].length()){
                j=0;
                w2j++;
            }
            if(i==w1[w1i].length()){
                i=0;
                w1i++;
            }
        }
        return w1i==w1.length && w2j==w2.length;
    }
}