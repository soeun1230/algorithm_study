import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int width = (int)Math.ceil(brown/4);width<=(brown-2)/2;width++){
            int bh = (int)Math.ceil((brown-(width*2))/2);
            int yw = width-2;
            if(yellow==bh*yw){
                if(width>=bh+2){
                    answer[0]=width;
                    answer[1]=bh+2;
                }
                else{
                    answer[1]=width;
                    answer[0]=bh+2;
                }
                break;
            }
        }
        
        return answer;
    }
}