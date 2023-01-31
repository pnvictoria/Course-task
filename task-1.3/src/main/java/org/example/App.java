package org.example;

import org.example.division.DivisionService;

public class App {
    //TODO: Консольное приложение предполагает элементарный консольный интерфейс.
    // Программа должна с нами поздороваться, предложить ввести 2 числа для деления.
    // Потом вывести результат. Можно это сделать в цикле и спрашивать, хочет ли
    // пользователь завершить работу, или поделить еще числа.

    //TODO: По сути нам тут в main не очень нужен DivisionResult. Лучше пусть будет
    // DivisionService (вместо DivisionCalculator или кроме DivisionCalculator), которому
    // мы дадим 2 числа, а он пусть нам отдаст готовую стрингу для вывода на экран.
    // Пусть он внутри себя использует DivisionFormatter, а не мы тут в main методе.
    // Кроме облегчения main метода мы получим класс с методом, который удобно тестировать.
    // Создавать DivisionResult в тесте для divisionCalculator.divide - не самая простая задача.


    public static void main(String[] args) {
        System.out.println(new DivisionService().getDivision(78945, 4));
    }
}
