import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extendedElements = new int[n * 2]; // 원형 수열을 처리하기 위해 두 번 반복한 배열 생성

        // 두 번 반복한 배열 생성
        for (int i = 0; i < n; i++) {
            extendedElements[i] = elements[i];
            extendedElements[i + n] = elements[i];
        }

        Set<Integer> uniqueSums = new HashSet<>(); // 중복 없는 합을 저장할 집합

        // 부분 수열의 길이를 1부터 n까지 반복
        for (int length = 1; length <= n; length++) {
            // 시작 인덱스를 0부터 n-1까지 반복
            for (int start = 0; start < n; start++) {
                int subSum = 0;

                // 부분 수열의 합 계산
                for (int i = 0; i < length; i++) {
                    subSum += extendedElements[start + i];
                }

                uniqueSums.add(subSum); // 집합에 추가하여 중복 제거
            }
        }

        return uniqueSums.size();
    }
    
}