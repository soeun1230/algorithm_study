import java.io.*;

public class Main {
    public static int N, M;
    public static int[][] visited;
    public static int[][] map;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int startRow = Integer.parseInt(input[0]);
        int startCol = Integer.parseInt(input[1]);
        int dir = Integer.parseInt(input[2]);

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] put = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(put[j]);
            }
        }

        cnt++;
        map[startRow][startCol]=-1;
        dfs(startRow,startCol,dir);
        System.out.println(cnt);

    }

    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};

    public static void dfs(int row, int col, int dir){

        map[row][col]=-1;
        for(int i=0;i<4;i++){
            dir=(dir+3)%4;
            int nr = row+dr[dir];
            int nc = col+dc[dir];
            if(nr>=0&&nr<N && nc>=0&&nc<M && map[nr][nc]==0){
                cnt++;

                dfs(nr,nc,dir);
                return;
            }
        }

        int d = (dir+2)%4;
        int nr = row+dr[d];
        int nc = col+dc[d];
        if(nr>=0&&nr<N && nc>=0&&nc<M && map[nr][nc]!=1){
            dfs(nr,nc,dir);
        }
    }

}
