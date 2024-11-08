package calculator;

import java.util.*;

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

        String input;
        try {
            input = scanner.nextLine();
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.getMessage();
            return 0;
        }

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
        else throw new IllegalArgumentException("연산자가 아닌 문자는 입력 불가능합니다.");

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        int calculate = stringCalculator.calculate();
        System.out.println("calculate = " + calculate);

    }

}
