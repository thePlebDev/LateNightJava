package com.example.LateNightJava.Repositories;

import com.example.LateNightJava.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class userRepositoryTest {

    @Autowired
    private UserRepository underTest;


    @Test
    public void findByUsernameTest(){
        //GIVEN
        String EXPECTED_USERNAME = "BOB";
        User user = new User(EXPECTED_USERNAME,"",null);

        //WHEN
        underTest.save(user);
        User foundUser = underTest.findByUsername(EXPECTED_USERNAME).get();

        //THEN
        assertThat(foundUser.getUsername()).isEqualTo(EXPECTED_USERNAME);
    }


}
