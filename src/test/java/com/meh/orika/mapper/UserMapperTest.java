package com.meh.orika.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.meh.orika.dto.UserDto;
import com.meh.orika.entity.User;

@RunWith(SpringRunner.class)
public class UserMapperTest {

	@Autowired
	private Mapper mapper;
	
	@Test
	public void shouldMapUserDtoToUserEntity() {
		UserDto userDto = mockUserDto();
		User user = mapper.map(userDto, User.class);
		assertThat(user.getUserName()).isEqualTo(userDto.getUserName());
		assertThat(user.getMails()).isEqualTo(userDto.getMails());
	}
	
	private UserDto mockUserDto() {
		UserDto userDto = new UserDto();
		List<String> mails = new ArrayList<String>();
		mails.add("Mayte@gmail.com");
		mails.add("Santi@gmail.com");
		mails.add("Alvaro@gmail.com");
		userDto.setMails(mails);
		userDto.setUserName("X05927ES");
		return userDto;
	}
    
	@TestConfiguration
    static class UserMapperTestContextConfig {
        @Bean
        public Mapper mapper() {
            return new Mapper();
        }
    }


}
