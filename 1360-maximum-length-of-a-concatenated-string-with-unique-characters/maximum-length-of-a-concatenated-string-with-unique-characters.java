class Solution {
    public boolean hasDuplicate(String s1, String s2){
        int arr[]= new int[26];
        
        for(char ch : s1.toCharArray()){
            if(arr[ch-'a']>0) return true;
            arr[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            if(arr[ch-'a']>0) return true;
        }
        return false;
    }
    public int solve(int i,List<String> arr, String sb,int n,Map<String,Integer> map){
        if(i>=n) return sb.length();
        int inc=0;
        int exc=0;
        String key = i + "|" + sb;
         if (map.containsKey(key)) {
            return map.get(key);
        }
        if(hasDuplicate(arr.get(i),sb.toString())){
             exc= solve(i+1,arr,sb,n,map);
        }else{
             exc=solve(i+1,arr,sb,n,map);
             inc = solve(i+1,arr,sb+arr.get(i),n,map);
        }
        int ans = Math.max(inc, exc);
             map.put(key, ans);
        return ans;
    }
    public int maxLength(List<String> arr) {
        int n = arr.size();
        Map<String,Integer> map = new HashMap<>();
        return solve(0,arr,"",n,map);
    }
}