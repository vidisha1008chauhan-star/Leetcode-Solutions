class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        int n = words[0].length();
        int count = words.length;
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i < n; i++){
            HashMap<String, Integer> curr = new HashMap<>();
            int start = i, countCheck = 0;

            for(int end = i; end + n <= s.length(); end += n){
                String word = s.substring(end, end + n);
                if(map.containsKey(word)){
                    curr.put(word, curr.getOrDefault(word, 0) + 1);
                    countCheck++;

                    while(curr.get(word) > map.get(word)){
                        String str = s.substring(start, start + n);
                        curr.put(str, curr.get(str) - 1);
                        start += n;
                        countCheck--;
                    }

                    if(count == countCheck) list.add(start);
                }
                else{
                    countCheck = 0;
                    start = end + n;
                    curr.clear();
                }
            }
        }
        return list;
    }
}