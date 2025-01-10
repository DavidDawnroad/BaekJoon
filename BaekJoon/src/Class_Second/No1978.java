/*
    소수 찾기
    주어진 소수 N개 중에서 소수가 몇 개인지 찾아서 출력하라.
    첫 줄에 수의 개수 N이 주어진다. N은 100 이하이다.
    다음 줄에 N개의 수가 주어진다. 수는 1000 이하의 자연수이다.

    주어진 수들 중 소수의 개수를 출력하라.
*/
package Class_Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        if (!(count == 0)) {
            int stack = 0;
            int result = 0;
            int[] arr = new int[count];
            String[] nums = br.readLine().split(" ");

            for (int i = 0; i < nums.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            // 소수 판별
            for (int i = 0; i < arr.length; i++) {
                // input 이 무조건 1000 이하 자연수이므로 input = 0인 경우는 신경쓸 필요 없음
                if (!(arr[i] == 1)) {
                    for(int j = 2; j <= arr[i]; j++) {
                        if (arr[i] % j == 0) {
                            stack++;
                        }
                    }
                    if (stack == 1) {
                        result++;
                        stack = 0;
                    }
                }
            }
            System.out.print(result);
        } else {
            System.out.print("0");
        }
    }
}