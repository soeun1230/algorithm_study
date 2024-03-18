import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public Stack<String[]> st = new Stack<>();
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i=0;i<plans.length;i++){
            String[] t = plans[i][1].split(":");
            int time = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
            plans[i][1]=Integer.toString(time);
        }
        
        Arrays.sort(plans,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                int h1=Integer.parseInt(o1[1]);
                int h2=Integer.parseInt(o2[1]);
                    return h1-h2;
            }
        });
        
        // for(String[] i:plans){
        //     System.out.println(i[0]);
        // }
        
        int i=1;
        st.push(plans[0]);
        while(i<=plans.length){
            //끝까지 다 들어왔다먄
            if(i==plans.length){
                while(!st.isEmpty()){
                    //System.out.println("k "+st.peek()[0]);
                    arr.add(st.peek()[0]);
                    st.pop();
                }
                break;
            }
            String[] cur = plans[i];
            if(Integer.parseInt(cur[1])<Integer.parseInt(st.peek()[1])+Integer.parseInt(st.peek()[2])){
                //지금 새로 들어올 때까지 과제 수행 정도를 전꺼에서 뺴주는 것 
                int passed = Integer.parseInt(cur[1])-Integer.parseInt(st.peek()[1]);
                String[]ch = st.peek();
                ch[2]=Integer.toString(Integer.parseInt(ch[2])-passed);
                st.pop();
                st.push(ch);
                st.push(cur);
                i++;
            }
            else{
                //이전과제 끝났으니 답에 넣어주기
                //System.out.println(i+"s "+st.peek()[0]);
                arr.add(st.peek()[0]);
                //이전과제 끝난시간 저장
                String endTime = st.peek()[1];
                endTime = Integer.toString(Integer.parseInt(endTime)+Integer.parseInt(st.peek()[2]));

                //이전과제 삭제
                st.pop();
                
                //전 과제의 수행 정도 체크
                while(!st.isEmpty()){
                    String[] before = st.peek();
                    before[1]=endTime;
                    if(Integer.parseInt(cur[1])<Integer.parseInt(before[1])+Integer.parseInt(before[2])){
                        //changeLeftTime(cur, before);
                        int passed = Integer.parseInt(cur[1])-Integer.parseInt(before[1]);
                        String[]ch = before;
                        ch[2]=Integer.toString(Integer.parseInt(ch[2])-passed);
                        st.pop();
                        st.push(ch);
                        break;
                    }
                    else{
                        //stem.out.println("a "+st.peek()[0]);
                        arr.add(st.peek()[0]);
                        endTime= Integer.toString(Integer.parseInt(endTime)+Integer.parseInt(before[2]));
                        st.pop();
                    }
                }
                //현재 과제 추가
                st.push(cur);
                i++;
                //System.out.println(i+" "+st.size());
            }
        }
        for(int j=0;j<plans.length;j++){
            answer[j]=arr.get(j);
        }
        return answer;
    }
}