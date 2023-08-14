package kz.mun.securityjwt.repository;

import kz.mun.securityjwt.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class DishRepositoryTest {

    @Autowired
    private  DishRepository dishRepository;

    @Test
    void getDishByCookingTime() {
        //given
        Dish dish = new Dish(
                null,
                "Potato",
                "Potato",
                "Potato",
                "25 min"
        );
        dishRepository.save(dish);

        //when
        boolean expected = dishRepository.existsDishByCookingTime("25 min");

        //then
        assertThat(expected).isTrue();
    }
}