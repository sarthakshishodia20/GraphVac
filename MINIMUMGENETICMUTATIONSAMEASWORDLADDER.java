class Solution {
    static class Pair{
        String word;
        int steps;
        public Pair(String str,int s){
            this.word=str;
            this.steps=s;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set=new HashSet<>();
        for(String str:bank){
            set.add(str);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startGene,0));
        set.remove(startGene);
        char[] choices={'A','C','G','T'};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String currWord=curr.word;
            int currSteps=curr.steps;
            if(currWord.equals(endGene)){
                return currSteps;
            }
            for(int i=0;i<currWord.length();i++){
                for(char c:choices){
                    char[] arr=currWord.toCharArray();
                    arr[i]=c;
                    String newWord=new String(arr);
                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,currSteps+1));
                    }
                }
            }
        }
        return -1;
    }
}
