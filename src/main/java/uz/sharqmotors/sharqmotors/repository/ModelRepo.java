package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.Model;

import java.util.List;

@Repository
public interface ModelRepo extends JpaRepository<Model, Long> {

    @Query("select p from Model p where p.active = :active")
    List<Model> getAllModels(ACTIVE active);
}
