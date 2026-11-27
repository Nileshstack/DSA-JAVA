class Solution {
    public boolean freq(String s){
        int arr[]= new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr[ch-97]++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>1) return true;
        }
        return false;
    }
    public boolean check(ArrayList<Integer> list, String s, String goal){
        char[] arr = s.toCharArray();
        char [] arr2= goal.toCharArray();
       char temp = arr[list.get(0)];
       arr[list.get(0)]=arr[list.get(1)];
       arr[list.get(1)]=temp;
        if(Arrays.equals(arr, arr2)){
            return true;
        }
        return false;

    }
    public boolean buddyStrings(String s, String goal) {
     if(s.length() != goal.length()) return false;
     if(s.equals(goal)){
        if(freq(s)){
            return true;
        }
     } 
     ArrayList<Integer> list = new ArrayList<>();
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)!=goal.charAt(i)){
            list.add(i);
        }
     }  
     if(list.size()!=2) return false;
      if(check(list,s,goal)){
        return true;
      }
      return false;
    }
}