import com.example.model.User;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

    public static void main(String[] args){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)applicationContext.getBean("userServiceImpl");
        User user = new User();
        user.setUserName("lulu");
        user.setPassword("love");
        user.setAge(18);
        service.registerUser(user);
    }
}
