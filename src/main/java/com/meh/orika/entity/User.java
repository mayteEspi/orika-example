package com.meh.orika.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private String userName;
	private List<String> mails;
}
