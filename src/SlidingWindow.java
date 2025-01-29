import java.util.HashSet;

public class SlidingWindow {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // 중복 문자가 있으면 left를 오른쪽으로 이동
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // 현재 문자 추가 및 최대 길이 갱신
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("최장 부분 문자열 길이: " + lengthOfLongestSubstring(s)); // 출력: 3
    }
}
