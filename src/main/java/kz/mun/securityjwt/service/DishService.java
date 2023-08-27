package kz.mun.securityjwt.service;

import kz.mun.securityjwt.entity.Dish;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();
    Dish getDishById(Long id);
    Dish createDish(Dish dish);
}
