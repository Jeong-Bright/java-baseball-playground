package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StringCalculator {


    public List<Integer> separateNumber(String[] value) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i <= value.length; i += 2) {
            int number = Integer.parseInt(value[i]);
            numberList.add(number);
        }

        return numberList;
    }

    public List<String> separateString(String[] value) {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i < value.length; i += 2) {
            stringList.add(value[i]);
        }
        return stringList;
    }


    public int calculate() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = 0;

        try {
            result = calculator(input);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
            n.getMessage();
            return 0;
        }

        scanner.close();

        return result;
    }

    public int calculator(String input) {


        String[] splitValue = input.split(" ");

        List<Integer> integers = separateNumber(splitValue);
        List<String> strings = separateString(splitValue);

        int result = integers.get(0);

        for (int i = 0; i < strings.size(); i++) {
            result = checkOperator(result, integers.get(i+1), strings.get(i));
        }

        return result;
    }

    public int checkOperator(int sum, int number, String operator) {
        if (Objects.equals(operator, "+")) {
            sum += number;
        } else if (Objects.equals(operator, "-")) {
            sum -= number;
        } else if (Objects.equals(operator, "*")) {
            sum *= number;
        } else if (Objects.equals(operator, "/")) {
            try {
                sum /= number;
            } catch (ArithmeticException a) {
                System.out.println("0으로 나눌 수 없습니다.");
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        int calculate = stringCalculator.calculate();
        System.out.println("calculate = " + calculate);

    }

}
