import java.io.*;

public class Main {
    public static int[] oper, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        if(N==1){
            System.out.println(Integer.parseInt(input));
            return;
        }

        oper = new int[N/2];
        num = new int[N/2+1];

        for(int i=0;i<N;i++){
            if(i%2==0){
                num[i/2]=Integer.parseInt(input.substring(i,i+1));
            }
            else{
                if(input.substring(i,i+1).equals("+")){
                    oper[i/2]=1;
                }
                else if(input.substring(i,i+1).equals("-")){
                    oper[i/2]=2;
                }
                else{
                    oper[i/2]=3;
                }
            }
        }

        if(N==3){
            System.out.println(calNum(oper[0],num[0],num[1]));
            return;
        }

        dfs(0, num[0]);
        System.out.println(max);
    }
    public static int max = Integer.MIN_VALUE;
    public static void dfs(int operInd, int result){
        if(operInd>=oper.length){
            //System.out.println(result);
            if(result>max) max=result;
            return;
        }

        int nowPlus1 = calNum(oper[operInd],result,num[operInd+1]);
        dfs(operInd+1,nowPlus1);

        if(operInd+1<oper.length){
            int nowPlus2 = calNum(oper[operInd+1],num[operInd+1],num[operInd+2]);
            //System.out.println("n2 : "+nowPlus2);
            dfs(operInd+2,calNum(oper[operInd],result,nowPlus2));

        }

    }
    public static int calNum(int operInd, int n1, int n2){
        int re =n1;
        if(operInd==1){
            re=n1+n2;
        }
        else if(operInd==2){
            re=n1-n2;
        }
        else{
            re=n1*n2;
        }
        return re;
    }
}
