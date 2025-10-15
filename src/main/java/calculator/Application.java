package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        char[] separators = findCustomSeparator(input);

        String[] numbers = separateString(input, separators);

        System.out.println("결과 : " + getSum(numbers, 0));
    }

    public static String[] separateString(String target, char[] separators){
        for (char separator : separators){
            target = target.replace(separator, ' ');
        }
        return target.split(" ");
    }

    public static char[] findCustomSeparator(String target){

        return null;
    }

    public static int getSum(String[] numbers, int sum){

        return sum;
    }
}
