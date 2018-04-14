package com.example.demo.handlers;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.example.demo.models.BillingInfo;
import com.example.demo.models.PersonalInfo;
import com.example.demo.models.RegisterModel;

@Component
public class RegisterHandler {

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addPersonalInfo(RegisterModel registerModel, PersonalInfo personalInfo) {
		registerModel.setPersonalInfo(personalInfo);
	}

	public void addBillingInfo(RegisterModel registerModel, BillingInfo billingInfo) {
		registerModel.setBillingInfo(billingInfo);
	}

	public String saveAll(RegisterModel registerModel, MessageContext error) {
		String transitionValue = "success";

		// XXX Save model in database or somewhere else...
		error.addMessage(new MessageBuilder(). //
				error() //
				.source("registration") //
				.defaultText( //
						String.format("Couldn't register user with username: %s!",
								registerModel.getPersonalInfo().getUsername())) //
				.build());
		transitionValue = "failure";

		return transitionValue;
	}

	public String validatePersonalInfo(PersonalInfo personalInfo, MessageContext error) {
		String transitionValue = "success";

		// Checking that username is not equal to 'Vakho' :d XXX do whatever you want!
		if (personalInfo.getUsername().equalsIgnoreCase("Vakho")) {
			error.addMessage(new MessageBuilder(). //
					error() //
					.source("username") //
					.defaultText("You are not allowed to use Vakho as the username!") //
					.build());

			transitionValue = "failure";
		}

		// Checking if password matched the confirm password
		if (!personalInfo.getPassword().equals(personalInfo.getConfirmPassword())) {
			error.addMessage(new MessageBuilder(). //
					error() //
					.source("confirmPassword") //
					.defaultText("Password doesn't match up the confirm password!") //
					.build());

			transitionValue = "failure";
		}
		return transitionValue;
	}
}
