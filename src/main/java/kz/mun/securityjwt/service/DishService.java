package kz.mun.securityjwt.service;

import kz.mun.securityjwt.entity.Dish;

public interface DishService {
    Dish getDishById(Long id);
    Dish createDish(Dish dish);
}
