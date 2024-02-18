package ru.astieriait.bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.astieriait.bot.dto.CarCategory;
import ru.astieriait.bot.dto.CarDto;
import ru.astieriait.bot.service.CarService;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CarWebAppController {
    private final CarService carService;

    @GetMapping("/")
    public String getIndex() {
        return "index.html";
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<CarDto> getCars(
            @RequestParam("category") CarCategory carCategory,
            @RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
            @RequestParam(defaultValue = "10", value = "amount", required = false) Integer amount
    ) {
        return carService.getCars(carCategory, page, amount);
    }
}
