package uz.sharqmotors.sharqmotors;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uz.sharqmotors.sharqmotors.models.auth.AppUser;
import uz.sharqmotors.sharqmotors.service.usersservice.UserService;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class SharqmotorsApplicationTests {

//	@Autowired
//	private UserService userService;
	@Test
	void contextLoads() {

//		List<AppUser> appUser = userService.getUser();
//
//		for (AppUser appUser1 : appUser) {
//
////			for (Role role :appUser1.getRoles()){
//			appUser1.getRoles().removeAll(appUser1.getRoles());
////			}
//			userService.delete(appUser1);
//		}

	}

}
