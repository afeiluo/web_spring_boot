package com.afeiluo.hello;


import com.afeiluo.hello.model.user.User;
import com.afeiluo.hello.model.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPADBTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCreatingUser_thenCreated() {
        User user = new User();
        user.setName("John");
        user.setCity("chengdu");
        user.setAge(20);
        user = userRepository.save(user);
        assertNotNull(userRepository.findById(user.getId()));
    }
}
