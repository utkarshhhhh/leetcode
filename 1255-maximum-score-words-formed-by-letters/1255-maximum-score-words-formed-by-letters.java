class Solution {
    
    public static int solution(String[] words, int[] freq, int[] score, int idx) {
		//write your code here
		
		if(idx == words.length){
		    return 0;
		}
		
		int noCall = solution( words, freq, score, idx+1  );
		
		int yesCall = 0;
		
		int curScore = 0;
		boolean flag = false;
		for( int i=0 ;  i<words[idx].length() ; i++ ){
		    int c = words[idx].charAt(i) - 'a';
		    curScore += score[c];
		    
		    if( freq[c] == 0 ){
		        flag = true;
		    }
		    
		    freq[c]--;
		}
		
		if( !flag ){
		    yesCall = curScore + solution( words, freq, score, idx+1  );
		}
		
		for( int i=0 ;  i<words[idx].length() ; i++ ){
		    int c = words[idx].charAt(i) - 'a';
		    freq[c]++;
		}
		
		return Math.max(noCall, yesCall);
	}
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] fArr = new int[26];
        for(char c : letters){
            fArr[c-'a']++;
        }
        
        return solution(words, fArr, score, 0);
    }
}