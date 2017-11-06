package com.editor.datatables;

import java.util.concurrent.TimeUnit;

import com.fourstay.utilities.Driver;

import cucumber.api.java.Before;

public class Hook {

	@Before
	public void setUp() {
		Driver.getInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// @After
	public void tearDown() {
		Driver.closeDriver();
	}
}
