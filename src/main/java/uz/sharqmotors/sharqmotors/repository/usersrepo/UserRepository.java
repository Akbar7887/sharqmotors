package uz.sharqmotors.sharqmotors.repository.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sharqmotors.sharqmotors.models.auth.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
