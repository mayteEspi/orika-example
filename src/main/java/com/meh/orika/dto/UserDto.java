package com.meh.orika.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private String userName;
	private List<String> mails;
}
