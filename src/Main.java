import java.util.Scanner;

public class Main {
    private static double f(double x, double a, double b) {
        if (x <= a)     return Math.exp(x) * Math.sin(x);
        else if (x < b) return Math.tan(x) + Math.pow(x, 2);
        else            return Math.pow(x, 7);
    }
    public static void main(String[] args) {
        String[] _menu_items = {
                "Задать параметры A и B",
                "Задать параметры A и B и посчитать значение функции",
                "Вычислить значение функции",
                "Вычислить для диапазона аргументов",
                "Выйти из программы"
        };
        boolean params = false;
        double a = 0, b = 0;
        Scanner _input = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            for (int _i = 0; _i < 4; _i++) System.out.println((_i+1) + " > " + _menu_items[_i]);
            System.out.println(" >>> ");
            while (!_input.hasNextInt()) {
                _input.next();
            }
            int answer = _input.nextInt();
            switch (answer) {
                case 1: case 2: {
                    if (params) System.out.println("Параметры заданы: A = " + a + ", B = " + b);
                    while (true) {
                        System.out.print("Введите A: ");
                        if (_input.hasNextDouble()) {
                            a = _input.nextDouble();
                            break;
                        } else _input.next();
                    }
                    while (true) {
                        System.out.print("Введите B: ");
                        if (_input.hasNextDouble()) {
                            b = _input.nextDouble();
                            break;
                        } else _input.next();
                    }
                    System.out.println("Параметры обновлены\n");
                    params = true;
                    if (answer == 1) break;
                }
                case 3: {
                    // Вычислить значение функции
                    if (!params) {
                        System.out.println("Не заданы параметры функци. Не можем вычислять значение.");
                        break;
                    }
                    double x, z;
                    while (true) {
                        System.out.print("Введите аргумент: ");
                        if (_input.hasNextDouble()) {
                            x = _input.nextDouble();
                            break;
                        } else _input.next();
                    }
                    z = f(x, a, b);
                    System.out.println("f(" + x + ") = " + z);
                    break;
                }
                case 4: {
                    // Вычислить для диапазона значений
                    if (!params) {
                        System.out.println("Не заданы параметры функци. Не можем вычислять значения.");
                        break;
                    }
                    double x1, x2, dx, z;
                    while (true) {
                        System.out.print("Введите начальное значение аргумента: ");
                        if (_input.hasNextDouble()) {
                            x1 = _input.nextDouble();
                            break;
                        } else _input.next();
                    }
                    while (true) {
                        System.out.print("Введите конечное значение аргумента: ");
                        if (_input.hasNextDouble()) {
                            x2 = _input.nextDouble();
                            break;
                        } else _input.next();
                    }
                    while (true) {
                        System.out.print("Введите аргумент: ");
                        if (_input.hasNextDouble()) {
                            dx = _input.nextDouble();
                            break;
                        } else _input.next();
                    }
                    if ((x2 > x1 && dx < 0) || (x2 < x1 && dx > 0)) dx = -dx;

                    for (double x = x1; x <= x2; x+=dx) {
                        System.out.println("f(" + x + ") = " + f(x, a, b));
                    }
                    break;
                }
                case 5: {
                    return;
                }
            }
        }
    }
}
