package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.Option;

import java.util.List;

@Repository
public interface OptionRepo extends JpaRepository<Option, Long> {
    @Query("select p from Option p where p.active = :active")
    List<Option> getAllActive(ACTIVE active);
}
