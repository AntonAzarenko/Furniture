package azarenka.service.logic;

import azarenka.dto.UserDTO;
import azarenka.entity.User;
import azarenka.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService service;

    @Test
    public void save() {
    }

    @Test
    public void existsByUserName() {
    }

    @Test
    public void updatePassword() {
    }

    @Test
    public void resetPassword() {
    }

    @Test
    public void testGet() {
        UserDTO user = service.get(1L);
        log.info(user.toString());
    }

    @Test
    public void delete() {
    }
}