package com.rcb.test.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rcb.utils.CommonValidation;

public class CommonValidationTest {
	
	CommonValidation commonValidation = new CommonValidation();

	@Test
	public void emailValidateTest() {
		assertEquals("Expect TRUE",true,commonValidation.emailValidate("aurora.bcg@gmail.com"));
		assertEquals("Expect FALSE",false,commonValidation.emailValidate("aurora.bcggmail.com"));
	}
}
