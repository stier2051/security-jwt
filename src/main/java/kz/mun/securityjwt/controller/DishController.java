package kz.mun.securityjwt.controller;

import kz.mun.securityjwt.constants.Constants;
import kz.mun.securityjwt.entity.Dish;
import kz.mun.securityjwt.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API + "/dish")
public class DishController {

    private final DishService dishService;

    @GetMapping("/{dishId}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long dishId) {
        return ResponseEntity.ok(dishService.getDishById(dishId));
    }

    @PostMapping
    public ResponseEntity<Dish> createNewDish(@RequestBody Dish dish) {
        return ResponseEntity.ok(dishService.createDish(dish));
    }
}
