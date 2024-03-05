import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
public int solution(int[] bandage, int health, int[][] attacks) {
    int answer = 0;
    //공격횟수
    int attackNum = attacks.length;

    //몬스터의 마지막 공격이 끝나는 시간
    int lastAttack = attacks[attackNum-1][0];

    //1초당 회복량 + 연속 성공 보상 줄 때도 추가되는 값
    int secHealth = bandage[1];

    //연속성공 보상에 걸리는 시간
    int coolTime = bandage[0];
    //연속성공 시 얻는 체력
    int plusHealth = bandage[2];

    int maxHealth = health;
    int iniTime=0;
    for(int i=0;i<attackNum;i++){
        int curTime = attacks[i][0];
        int curAttack = attacks[i][1];
        int beforeAttackHealth = (curTime-iniTime-1)*secHealth+health;
        for(int j=0;j<(curTime-iniTime-1)/coolTime;j++){
            beforeAttackHealth+=plusHealth;
        }
    
        if(beforeAttackHealth>maxHealth){
            beforeAttackHealth = maxHealth;
        }
        health= beforeAttackHealth-curAttack;
        iniTime=curTime;
        if(health<=0){
            answer=-1;
            break;
        }
    }
    if(answer!=-1){
        answer=health;
    }

    return answer;
}
}