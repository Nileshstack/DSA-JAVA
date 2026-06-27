class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>> map= new HashMap<>();
    for(int i=0;i<strs.length;i++){
        String sort= sort(strs[i]);
        if(!map.containsKey(sort)){
            map.put(sort,new ArrayList<>());
        }
        map.get(sort).add(strs[i]);
    }
    return new ArrayList<>(map.values());
    }
    public String sort(String st){
        char[] chars = st.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}