package com.example.demo.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import com.example.demo.model.User;

public class UserFormatter implements Formatter<User> {

	@Override
	public String print(User user, Locale locale) {
		if (user != null) {
			return user.getUser();
		} else {
			return "";
		}
	}

	@Override
	public User parse(String text, Locale locale) throws ParseException {

		if (StringUtils.hasText(text)) {
			return new User(text);
		} else {
			return null;
		}
	}

}
