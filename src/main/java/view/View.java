package view;

import java.util.List;
import java.util.Scanner;

public class View {

    private static final String LINE = "|";
    private static final String POINT = "-----";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println("참여할 사람을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        String line = SCANNER.nextLine();

        return List.of(line.split(","));
    }

    public static int getLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("정확한 숫자를 입력해주세요!");
        }
    }

    public static List<String> getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String line = SCANNER.next();

        return List.of(line.split(","));
    }

    public static void printLadder(List<Boolean> points) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%6s", LINE));
        points.forEach(point -> stringBuilder.append(printPoint(point)));
        System.out.println(stringBuilder);
    }

    private static String printPoint(boolean point) {
        if (point) {
            return POINT + LINE;
        }
        return String.format("%6s", LINE);
    }

    public static void printNames(List<String> names) {
        names.forEach(name -> System.out.printf("%5s ", name));
        System.out.println();
    }

    public static void printResults(List<String> results) {
        results.forEach(result -> System.out.printf("%-6s", result));
        System.out.println();
    }

    public static String selectPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.next();
    }

    public static void printGameResult(String result) {
        System.out.println("실행결과");
        System.out.println(result);
    }
}
