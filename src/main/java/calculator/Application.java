package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        ArrayList<String> separators = new ArrayList<String>();
        separators.add(":");
        separators.add(",");

        String customStr = findCustomSeparator(input, separators);

        String[] numbers = separateString(customStr, separators);

        System.out.println("결과 : " + getSum(numbers, 0));
    }

    public static String[] separateString(String target, ArrayList<String> separators){
        for (String separator : separators){
            target = target.replace(separator, " ");
        }
        return target.split(" ");
    }

    public static String findCustomSeparator(String target, ArrayList<String> separators){
        int start = target.indexOf("//");
        int end = target.indexOf("\\n");

        while (start != -1 && end != -1){
            separators.add(String.valueOf(target.charAt(start + 2)));
            target = target.substring(0, start) + target.substring(end + 2);
            start = target.indexOf("//");
            end = target.indexOf("\\n");
        }

        return target;
    }

    public static int getSum(String[] numbers, int sum){
        for (String str : numbers){
            try{
                int num = Integer.parseInt(str);
                if (num < 0) throw new IllegalArgumentException("음수 " + str + "가 입력되었습니다");
                sum += num;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("잘못된 문자열 " + str + " 이 입력되었습니다.", e);
            }
        }
        return sum;
    }
}
