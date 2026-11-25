class Solution {
    public boolean halvesAreAlike(String s) {
        if(s.length()%2!=0) return false;
        int c=0;
        int h =0;
     for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            c++;
        }
     } 
     for(int i=0;i<s.length()/2;i++){
        char ch = s.charAt(i);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            h++;
        }
     }
     if(c%2!=0) return false;
     return h==(c/2); 
    }
}