package kz.mun.securityjwt.service.impl;

import kz.mun.securityjwt.entity.Dish;
import kz.mun.securityjwt.repository.DishRepository;
import kz.mun.securityjwt.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    @SneakyThrows
    public Dish getDishById(Long id) {
        return dishRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @SneakyThrows
    @Override
    public Dish createDish(Dish dish) {
        Boolean isDishExist = dishRepository.existsDishByName(dish.getName());
        if (isDishExist) {
            throw new Exception(String.format("Dish %s already exist", dish.getName()));
        }
        return dishRepository.save(dish);
    }
}
