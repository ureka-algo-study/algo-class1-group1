class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);

            if(!map.containsKey(s)){
            map.put(s, new ArrayList<>());
            }
            
            map.get(s).add(str);
        }

            List<List<String>> result = new ArrayList<>(map.values());

            return result;
    }
}