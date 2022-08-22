package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.Rate;

@Repository
public interface RateRepo extends JpaRepository<Rate, Long> {


    @Query("select r from Rate r where r.currentdate in (select max(r1.currentdate) from Rate r1)")
    Rate getMaxDate();

}
