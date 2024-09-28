import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            if(isValid(numbers[i])){
                answer[i]=1;
            }
            else{
                answer[i]=0;
            }
        }
        return answer;
    }
    public boolean isValid(Long number){
        String binary = Long.toBinaryString(number);
        int length = binary.length();
        
        int height =0;
        while((1<<height)-1 < length){
            height++;
        }
        int totalNodes = (1<<height) -1;
        String fullBinary = "0".repeat(totalNodes-length) + binary;
        
        return isValidTree(fullBinary);
    }
    public boolean isValidTree(String binary){
        return checkSubTree(binary,0,binary.length()-1);
    }
    public boolean checkSubTree(String binary, int start, int end){
        if(start>end){
            return true;
        }
        int mid = (start+end)/2;
        char root = binary.charAt(mid);
        
        if(root=='0'){
            for(int i=start; i<=end; i++){
                if(binary.charAt(i)=='1'){
                    return false; 
                }
            }   
        }
        return checkSubTree(binary,start,mid-1) && checkSubTree(binary,mid+1,end);
    }
}