package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByPhone(String phone);

//    @Query("select p from Customer p where p.active = :active")
//    List<Customer> getAllActive(ACTIVE active);
}