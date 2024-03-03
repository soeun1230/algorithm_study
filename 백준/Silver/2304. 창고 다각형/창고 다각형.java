import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        
        int[] arr =new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            arr[X]=height;
            start = Math.min(X,start);
            end = Math.max(X,end);
        }

        Stack<Integer> H = new Stack<>();
        
        int temp = arr[start];
        for(int i=start+1;i<=end;i++){
            if(arr[i]<temp){
                H.push(i);
            }
            else{
                while(!H.isEmpty()){
                    int x = H.pop();
                    arr[x]=temp;
                }
                temp=arr[i];
            }
        }
        H.clear();
        
        temp = arr[end];
        for(int i =end-1;i>=start;i--){
            if(arr[i]<temp){
                H.push(i);
            }
            else{
                while(!H.isEmpty()){
                    int x = H.pop();
                    arr[x]=temp;
                }
                temp=arr[i];
            }
        }
        
        int result =0;
        for(int i=start;i<=end;i++){
            result+=arr[i];
        }

        System.out.println(result);
        br.close();
    }
}