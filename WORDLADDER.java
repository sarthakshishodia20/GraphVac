class Solution {
    static class Pair{
        String word;
        int steps;
        public Pair(String word,int s){
            this.word=word;
            this.steps=s;
        }
    }
    public int wordLadderLength(String startWord, String targetWord,String[] wordList) {
        // Code here
        HashSet<String> set=new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        set.remove(startWord);
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String currWord=curr.word;
            int currStep=curr.steps;
            if(currWord.equals(targetWord)){
                return currStep;
            }
            for(int i=0;i<currWord.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=currWord.toCharArray();
                    arr[i]=ch;
                    String newString=new String(arr);
                    if(set.contains(newString)==true){
                        set.remove(newString);
                        q.add(new Pair(newString,currStep+1));
                    }
                }
            }
        }
        return 0;
    }
}
