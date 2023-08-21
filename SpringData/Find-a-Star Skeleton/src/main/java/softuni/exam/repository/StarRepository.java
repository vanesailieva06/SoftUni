package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    Star findByName(String name);

    @Query("SELECT s FROM Star s " +
            "WHERE SIZE(s.astronomers) = 0 AND " +
            "s.starType = :starType " +
            "ORDER BY s.lightYears")
    List<Star> findStarsByStarTypeAndAstronomersStarIdIsNull(@Param(value = "starType") StarType starType);
}
