package kz.mun.securityjwt.service;

import kz.mun.securityjwt.entity.Dish;
import kz.mun.securityjwt.repository.DishRepository;
import kz.mun.securityjwt.service.impl.DishServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class DishServiceTest {

    @Mock
    private DishRepository dishRepository;
    private DishService underTest;

    @BeforeEach
    void setUp() {
        underTest = new DishServiceImpl(dishRepository);
    }

    @Test
    void canGetAllDishes() {
        // when
        underTest.getAllDishes();
        // then
        verify(dishRepository).findAll();
    }

    @Test
    void canGetDishById() {
        Dish dish = new Dish(
                1L,
                "Potato",
                "Potato",
                "Potato",
                "25 min"
        );

        given(dishRepository.findById(1L)).willReturn(Optional.of(dish));
        assertThat(underTest.getDishById(1L)).isEqualTo(dish);
    }

    @Test
    void canCreateDish() {
        Dish dish = new Dish(
                1L,
                "Potato",
                "Potato",
                "Potato",
                "25 min"
        );
        //when
        underTest.createDish(dish);
        //then
        ArgumentCaptor<Dish> dishArgumentCaptor = ArgumentCaptor.forClass(Dish.class);
        verify(dishRepository).save(dishArgumentCaptor.capture());
        Dish capturesDish = dishArgumentCaptor.getValue();
        assertThat(capturesDish).isEqualTo(dish);
    }

    @Test
    void willThrowWhenDishIsExist() {
        Dish dish = new Dish(
                1L,
                "Potato",
                "Potato",
                "Potato",
                "25 min"
        );
        given(dishRepository.existsDishByName(dish.getName())).willReturn(true);
        assertThatThrownBy(() -> underTest.createDish(dish))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(String.format("Dish %s already exist", dish.getName()));
    }
}