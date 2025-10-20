package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        if (input == null || input.isBlank()) {
            System.out.println("결과 : 0");
            return;
        }

        ArrayList<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
        String customStr = findCustomSeparator(input, separators);
        String[] numbers = separateString(customStr, separators);

        System.out.println("결과 : " + getSum(numbers, 0));
    }

    public static String[] separateString(String target, ArrayList<String> separators){
        String regex = separators.stream().map(Pattern::quote).collect(Collectors.joining("|"));
        return target.split(regex, -1);
    }

    public static String findCustomSeparator(String target, ArrayList<String> separators){
        Pattern header = Pattern.compile("(?s)^//(.+?)(?:\\r?\\n|\\\\n)(.*)$");
        Matcher m = header.matcher(target);
        if (m.matches()) {
            String custom = m.group(1);
            separators.add(custom);
            return m.group(2);
        }
        return target;
    }

    public static long getSum(String[] numbers, long sum){
        if (numbers.length == 1 && numbers[0].isBlank()) return 0;
        for (String str : numbers){
            try{
                long num = Long.parseLong(str);
                if (num < 0) throw new IllegalArgumentException("음수 " + str + "가 입력되었습니다");
                sum += num;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("잘못된 문자열 " + str + " 이 입력되었습니다.", e);
            }
        }
        return sum;
    }
}
