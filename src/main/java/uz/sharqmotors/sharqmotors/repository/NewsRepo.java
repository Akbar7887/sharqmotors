package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.News;

import java.util.List;

public interface NewsRepo extends JpaRepository<News, Long> {

    @Query("select p from News p where p.active = :active")
    List<News> getAllActive(ACTIVE active);
}
