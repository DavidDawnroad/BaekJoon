/*
    직각삼각형에 대한 피타고라스의 정리를 이용, 주어진 세 변의 길이가 직각삼각형인지 검증
    Testcase 는 30000보다 적은 양의 정수이며, 마지막 Testcase 는 0 0 0이 입력됨
    직각삼각형이 맞다면 "right", 아니라면 "wrong"을 출력
    입력: 6 8 10
    출력: right
    입력: 25 52 60
    출력: wrong
*/
package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4153 {
    public static void main(String[] args) throws IOException {

        /*
            1. Scanner 대신 BufferedReader를 사용한 이유는?
                Scanner는 내부적으로 정규식을 이용해 데이터를 파싱하기 때문에, 많은 양의 데이터를 처리한다면 성능 면에서 이슈가 발생할 수 있다. (=느림)
                BufferedReader는 문자열 데이터를 읽는 데 사용되며, 내부 버퍼를 사용해 데이터를 한 번에 읽기 때문에 대용량 데이터를 처리할 때도 뛰어난 성능을 보인다.
                InputStreamReader를 사용해 바이트 스트림을 문자 스트림으로 변환하고, 이를 버퍼링하는 방식으로 성능을 최적화한다.

            2. BufferedReader의 특징은?
                문자열 데이터만 읽을 수 있기 때문에, 다른 타입의 데이터를 입력받기 위해선 형변환을 해줘야 한다. (ex- Integer.parseInt())

            3. StringTokenizer를 사용한 이유는?
                문자열을 지정된 구분자(default는 공백 문자)로 분리하기 위해 사용한다.
                최근에는 StringTokenizer 대신에 String.split()을 사용하는 편.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            /*
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            */
            String[] sides = br.readLine().split(" ");
            String temp;

            // 버블 정렬
            for (int i = 1; i < sides.length; i++) {
                for (int j = 0; j < sides.length - i; j++) {
                    if (Integer.parseInt(sides[j]) > Integer.parseInt(sides[j+1])) {
                        temp = sides[j];
                        sides[j] = sides[j+1];
                        sides[j+1] = temp;
                    }
                }
            }

            int a = Integer.parseInt(sides[0]);
            int b = Integer.parseInt(sides[1]);
            int c = Integer.parseInt(sides[2]);

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1); // 0 0 0이 입력됐을 때 마지막으로 추가됐던 줄바꿈 문자를 삭제
        System.out.println(sb);
    }
}