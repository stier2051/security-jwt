package kz.mun.securityjwt.service.impl;

import kz.mun.securityjwt.entity.Dish;
import kz.mun.securityjwt.repository.DishRepository;
import kz.mun.securityjwt.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    @Override
    @SneakyThrows
    public Dish getDishById(Long id) {
        return dishRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }
}
