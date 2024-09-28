class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 알파벳 변경에 필요한 조작 횟수 계산
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 최소 좌우 이동 횟수 계산
        int minMove = len - 1; // 기본적으로 오른쪽으로 끝까지 가는 경우
        for (int i = 0; i < len; i++) {
            int next = i + 1;

            // 연속된 'A' 뒤의 첫 'A'가 아닌 위치 찾기
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 이동 경로 계산: i에서 돌아가기 + len - next 이후 돌아가기
            minMove = Math.min(minMove, i + len - next + Math.min(i, len - next));
        }

        answer += minMove;

        return answer;
    }
}
