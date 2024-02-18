package ru.astieriait.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.astieriait.bot.model.Car;
import ru.astieriait.bot.model.ShortCarInfo;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(nativeQuery = true, value = " SELECT c.id, c.brand, c.model, c.price FROM car c " +
            "WHERE c.disable = false " +
            "ORDER BY c.id " +
            "LIMIT :limit OFFSET :offset ")
    List<ShortCarInfo> getAllShortCarsInfo(@Param("limit") Integer limit, @Param("offset") Integer offset);

    @Query(nativeQuery = true, value = " SELECT c.id, c.brand, c.model, c.price FROM car c " +
            "LEFT JOIN second_hand_car_details shcd ON c.id = shcd.car_id " +
            "WHERE c.disable = false AND shcd.id IS NULL " +
            "ORDER BY c.id " +
            "LIMIT :limit OFFSET :offset ")
    List<ShortCarInfo> getNewShortCarsInfo(@Param("limit") Integer limit, @Param("offset") Integer offset);

    @Query(nativeQuery = true, value = " SELECT c.id, c.brand, c.model, c.price FROM car c " +
            "LEFT JOIN second_hand_car_details shcd ON c.id = shcd.car_id " +
            "WHERE c.disable = false AND shcd.id IS NOT NULL " +
            "ORDER BY c.id " +
            "LIMIT :limit OFFSET :offset")
    List<ShortCarInfo> getSecondHandShortCarsInfo(@Param("limit") Integer limit, @Param("offset") Integer offset);

    @Query(nativeQuery = true, value = " SELECT c.id, c.brand, c.model, c.price FROM car c " +
            "LEFT JOIN electric_car_details ecd ON c.id = ecd.car_id " +
            "WHERE c.disable = false AND ecd.id IS NOT NULL " +
            "ORDER BY c.id " +
            "LIMIT :limit OFFSET :offset")
    List<ShortCarInfo> getElectricShortCarsInfo(@Param("limit") Integer limit, @Param("offset") Integer offset);
}
