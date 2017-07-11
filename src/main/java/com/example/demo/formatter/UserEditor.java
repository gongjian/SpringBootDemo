package com.example.demo.formatter;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

import com.example.demo.model.User;

public class UserEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		User user = (User) getValue();

		if (user != null) {
			return user.getUser();
		} else {
			return "";
		}
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text)) {
			setValue(new User(text));
		} else {
			setValue(null);
		}
	}

}
