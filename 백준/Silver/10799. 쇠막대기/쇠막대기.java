import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String total = sc.nextLine();
        int len = total.length();

        ArrayList<Integer> attack = new ArrayList<>();
        ArrayList<int[]> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        HashMap<int[], Integer> hm = new HashMap<>();

        int answer=0;
        for(int i=0;i<len;i++){
            char now = total.charAt(i);
            int nowIdx = i;

            if(now=='('){
                st.push(nowIdx);
            }
            else{
                int comIdx = st.pop();
                if(nowIdx-comIdx==1) {
                    answer += st.size();
                }
                else{
                    answer+=1;
                }
            }
        }

        System.out.println(answer);

    }
}
