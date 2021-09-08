import java.util.*;

public class Main {
    public static Stack<String> sign = new Stack<>();
    public static Queue<Integer> numbers = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение:");
        String input = scanner.nextLine();
        separateCharacters(input);
        showPolandString();
    }

    public static void separateCharacters(String input) {
        Arrays.stream(input.split(" ")).forEach(element -> {
            try {
                int number = Integer.parseInt(element);
                numbers.add(number);
            } catch(NumberFormatException err) {
                sign.add(element);
            }
        });
    }

    public static void showPolandString() {
        while (numbers.peek() != null) {
            System.out.print(numbers.poll() + " ");
        }

        while (!sign.isEmpty()) {
            System.out.print(sign.pop());
        }
    }
}
