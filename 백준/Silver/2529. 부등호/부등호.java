import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] com = new char[n];
        int[] num = new int[n+1];

        for(int i=0;i<n;i++){
            com[i]=sc.next().charAt(0);
        }

        //큰거부터
        for(int i=9;i>=(9-n);i--){
            num[9-i]=i;
        }

        int cnt=0;
        while(cnt==0){
            for(int i=0;i<n;i++){
                char now = com[i];
                int left = num[i];
                int right = num[i+1];

                if(now=='<'){
                    if(left<right) continue;
                    else{
                        int ch=num[i+1];
                        num[i+1]=num[i];
                        num[i]=ch;
                        cnt++;
                    }
                }
                else{
                    if(left>right) continue;
                    else{
                        int ch=num[i+1];
                        num[i+1]=num[i];
                        num[i]=ch;
                        cnt++;
                    }
                }
            }
            if(cnt==0){
                String ans = "";
                for(int l=0;l<num.length;l++){
                    ans+=String.valueOf(num[l]);
                }
                System.out.println(ans);
                break;
            }
            else{
                cnt=0;
            }
        }

        //작은거부터
        for(int i=0;i<=n;i++){
            num[i]=i;
        }

        cnt=0;
        while(cnt==0){
            for(int i=0;i<n;i++){
                char now = com[i];
                int left = num[i];
                int right = num[i+1];

                if(now=='<'){
                    if(left<right) continue;
                    else{
                        int ch=num[i+1];
                        num[i+1]=num[i];
                        num[i]=ch;
                        cnt++;
                    }
                }
                else{
                    if(left>right) continue;
                    else{
                        int ch=num[i+1];
                        num[i+1]=num[i];
                        num[i]=ch;
                        cnt++;
                    }
                }
            }
            if(cnt==0){
                String ans = "";
                for(int l=0;l<num.length;l++){
                    ans+=String.valueOf(num[l]);
                }
                System.out.println(ans);
                break;
            }
            else{
                cnt=0;
            }
        }

    }
}
