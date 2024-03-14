package ru.astieriait.bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.astieriait.bot.dto.car.get.CarCategory;
import ru.astieriait.bot.dto.car.get.GetCarDto;
import ru.astieriait.bot.dto.car.id.CarDto;
import ru.astieriait.bot.dto.order.create.CreateOrderRequestDto;
import ru.astieriait.bot.dto.order.create.CreateOrderResponseDto;
import ru.astieriait.bot.service.CarOrderService;
import ru.astieriait.bot.service.CarService;

import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/v1/car-bot-api")
public class CarWebAppController {
    private final CarService carService;
    private final CarOrderService orderService;

    @GetMapping("/cars")
    @ResponseBody
    public List<GetCarDto> getCars(
            @RequestParam("category") CarCategory carCategory,
            @RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
            @RequestParam(defaultValue = "10", value = "amount", required = false) Integer amount
    ) {
        return carService.getCars(carCategory, page, amount);
    }

    @GetMapping("/cars/{carId}")
    @ResponseBody
    public CarDto getCarDetails(@PathVariable("carId") UUID carId) {
        return carService.getCarDetails(carId);
    }

    @PostMapping("/order")
    @ResponseBody
    public CreateOrderResponseDto createOrder(
            @RequestBody CreateOrderRequestDto createOrderRequestDto
    ) {
        return orderService.createOrder(createOrderRequestDto);
    }
}
