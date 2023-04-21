class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int index = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<array.length;i++){
            if(Math.abs(array[i]-n) <min){
                index = array[i];
                min = Math.abs(array[i]-n);
            }
            if(Math.abs(array[i]-n) == min && array[i]<index){
                index = array[i];
                min = Math.abs(array[i]-n);
            }
            
        }
        answer = index;
        
        return answer;
    }
}