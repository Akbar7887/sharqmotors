package uz.sharqmotors.sharqmotors.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.Producer;

import java.util.List;


@Repository
public interface ProducerRepo extends JpaRepository<Producer, Long> {

   @Query("select p from Producer p where p.active = :active")
   List<Producer> getAllActive(ACTIVE active);
}
