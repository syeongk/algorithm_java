import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        boolean[] notSelfNumbers = new boolean[100001];
        StringBuilder sb = new StringBuilder();
        
        for (int i=1; i<10000; i++){
            int num = i;
            int sum = num;
            while(num > 0){
                sum += num % 10; //i의 일의 자리 수
                num /= 10; //num 일의 자리수 지우기
            }
            notSelfNumbers[sum] = true; // notSelfNumbers에 셀프 넘버가 아닌 숫자 추가
        }
 
        for (int i=1; i<10000; i++){
            if (notSelfNumbers[i] == false){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
