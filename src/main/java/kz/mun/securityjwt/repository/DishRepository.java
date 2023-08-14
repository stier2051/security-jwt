package kz.mun.securityjwt.repository;

import kz.mun.securityjwt.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    Boolean existsDishByCookingTime(String cookingTime);
}
