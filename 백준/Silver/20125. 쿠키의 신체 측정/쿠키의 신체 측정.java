import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main{
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int[][] board;
    static int size;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        size = Integer.parseInt(br.readLine());
        board = new int[size+1][size+1];

        for(int i=1;i<=size;i++){
            String input = br.readLine();
            for(int j=0;j<size;j++){
                if(input.charAt(j)=='*'){
                    board[i][j+1]=1;
                }
                else{
                    board[i][j+1]=0;
                }
            }
        }
        
        int[]heart=findHeart(1,1);
        sb.append(heart[0]+" "+heart[1]+'\n');

        int left_arm=0;
        for(int i=heart[1]-1;i>=1;i--){
            if(board[heart[0]][i]==0){
                break;
            }
            else{
                left_arm++;
            }
        }

        int right_arm=0;
        for(int i=heart[1]+1;i<=size;i++){
            if(board[heart[0]][i]==0){
                break;
            }
            else{
                right_arm++;
            }
        }

        int belly=0;
        int belly_y=0;
        for(int i=heart[0]+1;i<=size;i++){
            if(board[i][heart[1]]==0){
                belly_y=i-1;
                break;
            }
            else{
                belly++;
            }
        }

        int left_leg=0;
        for(int i=belly_y+1;i<=size;i++){
            if(board[i][heart[1]-1]==0){
                break;
            }
            else{
                left_leg++;
            }
        }
        int right_leg=0;
        for(int i=belly_y+1;i<=size;i++){
            if(board[i][heart[1]+1]==0){
                break;
            }
            else{
                right_leg++;
            }
        }

        sb.append(left_arm+" "+right_arm+" "+belly+" "+left_leg+" "+right_leg);

        System.out.println(sb.toString());
        br.close();
    }
    static int[] findHeart(int x, int y){
        int[] heart=new int[2];

        while(!findNearBlock(x,y)){
            if(x==size){
                x=1;
                y++;
            }
            else{
                x++;
            }
        }
        heart[0]=y;
        heart[1]=x;

        return heart;
    }
    static boolean findNearBlock(int x, int y){
        int nx=x;
        int ny=y;

        if(board[ny][nx]==0){
            return false;
        }
        for(int i=0;i<4;i++){
            nx = x+dx[i];
            ny = y+dy[i];

            if(nx>=size || nx<1 || ny>=size || ny<1){
                return false;
            }
            if(board[ny][nx]==1){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}