package com.shinetech.robotium.test;

import com.jayway.android.robotium.solo.Solo;
import com.shinetech.robotium.Main;
import com.shinetech.robotium.NewActivity;

import android.test.ActivityInstrumentationTestCase2;

public class TestSecondActivity extends
		ActivityInstrumentationTestCase2<NewActivity> {
	private Solo solo;

	public TestSecondActivity() {
		super(NewActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	
	}

	public void testRightActivity(){
		solo.assertCurrentActivity("Check on second activity", NewActivity.class);
	}
	
	
}
