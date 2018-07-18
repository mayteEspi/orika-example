package com.meh.orika.mapper;

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
		User user = mapper.map(mockUserDto(), User.class);
	}
	
	private UserDto mockUserDto() {
		UserDto userDto = new UserDto();
		List<String> mails = new ArrayList<String>();
		mails.add("mayte@gmail.com");
		mails.add("santi@gmail.com");
		userDto.setMails(mails);
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
