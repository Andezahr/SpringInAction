package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll")
    public String index(
            @RequestParam(name = "sides", required = false, defaultValue = "6") int sides,
            @RequestParam(name = "count", required = false, defaultValue = "1") int count,
            @RequestParam(name = "bonus", required = false, defaultValue = "0") int bonus,
            Model model) {

        // Если параметры переданы, бросаем кубики
        if (sides > 0 && count > 0) {
            List<Integer> results = new ArrayList<>();
            Random random = new Random();
            int total = 0; // Переменная для хранения суммы результатов

            // Генерация результатов для каждого кубика
            for (int i = 0; i < count; i++) {
                int result = random.nextInt(sides) + 1; // Случайное число от 1 до sides
                results.add(result);
                total += result; // Добавляем результат к сумме
            }

            // Добавляем фиксированное значение к сумме
            total += bonus;

            model.addAttribute("results", results); // Передаем результаты в шаблон
            model.addAttribute("total", total); // Передаем сумму результатов в шаблон
        }

        model.addAttribute("sides", sides); // Количество граней
        return "index"; // Имя шаблона Thymeleaf
    }
}