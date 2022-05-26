import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] _menu_items = {
                "Задать параметры A и B",
                "Вычислить значение функции",
                "Вычислить для диапазона аргументов",
                "Выйти из программы"
        };
        boolean params = false;
        Scanner _input = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            for (int _i = 0; _i < 4; _i++) System.out.println((_i+1) + " > " + _menu_items[_i]);
            System.out.println(" >>> ");
            while (!_input.hasNextInt()) {
                _input.next();
            }
            switch (_input.nextInt()) {
                case 1: {
                    //  
                }
            }
        }
    }
}
