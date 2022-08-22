package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.OptionConstant;

import java.util.List;


@Repository
public interface OptionConstantRepo extends JpaRepository<OptionConstant, Long> {

    @Query("select p from OptionConstant p where p.active = :active")
    List<OptionConstant> getAllActive(ACTIVE active);
}
