class Solution {
    public int[] reduce= {10,20,30,40};
    public int newUser=0;
    public int sold=0;
    public int totalSold=0;
    public int emo, buyer;
    public int[] decidedRate;
    public int[][] Users; 
    public int[] Emoticons;
    public int[] answer = {0,0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        Users=users;
        Emoticons = emoticons;
        
        buyer = users.length;
        emo = emoticons.length;
        decidedRate = new int[emo];
        
        decideRate(0);
        
        return answer;
    }
    public void decideRate(int depth){
        if(depth==emo){
            // for(int i=0;i<emo;i++){
            //     System.out.print(decidedRate[i]+" ");
            // }
            // System.out.println();
            calPrice();
            if(newUser>answer[0]){
                answer[0]=newUser;
                answer[1]=totalSold;
            }
            else if(newUser==answer[0]){
                if(totalSold>answer[1]){
                    answer[0]=newUser;
                    answer[1]=totalSold;
                }
            }
            totalSold=0;
            newUser=0;
            return;
        }
        for(int i=0;i<4;i++){
            decidedRate[depth]=reduce[i];
            decideRate(depth+1);
        }
    }
    public void calPrice(){
        for(int i=0;i<buyer;i++){
            //System.out.println("Buyer"+i);
            int curBuyerRate = Users[i][0];
            int curBuyerMoney = Users[i][1];
            
            for(int j=0;j<emo;j++){
                int curEmoRate = decidedRate[j];
                int curEmoPrice = Emoticons[j];
                
                if(curEmoRate>=curBuyerRate){
                    sold=sold+(curEmoPrice*(100-curEmoRate)/100);
                }
            }
            
            if(sold>=curBuyerMoney){
                //System.out.println(sold);
                newUser++;
            }
            else{
                totalSold+=sold;
            }
            sold=0;
        }
    }
}