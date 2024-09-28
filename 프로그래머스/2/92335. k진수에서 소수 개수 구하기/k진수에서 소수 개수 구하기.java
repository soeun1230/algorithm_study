import java.util.*;

class Solution {
    public String changeNum;
    public int cnt =0;
    public int kk;
    
    public int solution(int n, int k) {
        changeNum="";
        kk=k;
        
        int tar=n;
        while(tar>=k){
            changeNum = String.valueOf(tar%k) + changeNum;
            tar=tar/k;
        }
        changeNum = String.valueOf(tar) + changeNum;
        
        String ch = "";
        boolean flag=true;
        for(int i=0;i<changeNum.length();i++){
            if(changeNum.charAt(i)!='0' && flag==true){
                ch+=changeNum.substring(i,i+1);
            }
            else if(changeNum.charAt(i)=='0' && flag==true){
                flag=false;
                //System.out.println(ch);
                if(!ch.equals("") && isPrime(ch)) cnt++;
                ch="";
            }
            else if(changeNum.charAt(i)!='0' && flag==false){
                flag=true;
                ch+=changeNum.substring(i,i+1);
            }
            
            if(flag==true && i==changeNum.length()-1){
                //System.out.println(ch);
                if(!ch.equals("") && isPrime(ch)) cnt++;
            }
        }
        
        return cnt;
    }
    public boolean isPrime(String num){
        int len = num.length();
        long ten = Long.parseLong(num);
        // for(int i=0;i<len;i++){
        //     ten += (Math.pow(kk,(len-i-1)) *Integer.parseInt(num.substring(i,i+1)));
        // }
        //System.out.println("JustCH " +num + "TEN "+ten);
        
        if(ten==1) return false;
        if(ten==2) {
            //System.out.println("CH " +num + "TEN "+ten);
            return true;
        }
        if(ten==3) {
           // System.out.println("CH " +num + "TEN "+ten);
            return true;
        }
        
        for(int i=2;i<=Math.sqrt(ten);i++){
            if(ten%i==0)return false;
        }
        //System.out.println("CH " +num + "TEN "+ten);
        return true;
    }
    
}