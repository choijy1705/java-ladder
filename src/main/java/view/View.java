package view;

import java.util.List;
import java.util.Scanner;

public class View {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println("참여할 사람을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        String line = SCANNER.nextLine();
        String[] split = line.split(",");

        return List.of(split);
    }

    public static int getLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("정확한 숫자를 입력해주세요!");
        }
    }

    public static void printLadder(List<Boolean> points) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    |");
        points.forEach(point -> stringBuilder.append(printPoint(point)));
        System.out.println(stringBuilder);
    }

    private static String printPoint(Boolean point) {
        if (point) {
            return "-----|";
        }
        return "     |";
    }

    public static void printNames(List<String> names) {
        names.forEach(name -> System.out.printf("%5s ", name));
        System.out.println();
    }
}
