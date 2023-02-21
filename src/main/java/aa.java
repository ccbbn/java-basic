import java.util.Arrays;

public class aa {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 5});
    }
    public static int[] solution(int[] num_list) {
        int[] answer = {};

        for(int i = 0; i< num_list.length; i++){
            if ( num_list[i]%2 == 0){
                answer[0] += 1;
            } else {
                answer[1] += 1;
            }

        }

        return answer;
    }
}
