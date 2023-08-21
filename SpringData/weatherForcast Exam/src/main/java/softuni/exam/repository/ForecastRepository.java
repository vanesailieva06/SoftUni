package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    Forecast findByDayOfWeekAndAndCity_Id(DayOfWeek dayOfWeek, Long cityId);
    @Query("SELECT f from Forecast f " +
            "WHERE f.dayOfWeek = :dayOfWeek AND " +
            "f.city.population < :cityPopulation " +
            "ORDER BY f.maxTemperature DESC, " +
            "f.id ASC")
    List<Forecast> findForecastWithDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescAndId(
            @Param(value = "dayOfWeek") DayOfWeek dayOfWeek, @Param(value = "cityPopulation") Integer cityPopulation);
}
