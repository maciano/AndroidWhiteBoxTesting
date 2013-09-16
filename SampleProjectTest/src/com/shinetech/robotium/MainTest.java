package com.shinetech.robotium;


import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.Button;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;

public class MainTest extends ActivityInstrumentationTestCase2<Main> {
	private Solo solo;

	public MainTest() {
		super(Main.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Smoke
	public void testExample01() {
		final String expectedString = "before click";
		final String expectedStringAfter = "after click";
		
		//clicking on a view by id
		final TextView example01TextView = (TextView) solo.getCurrentActivity().findViewById(R.id.example_01_text_view);
		assertEquals(expectedString, example01TextView.getText().toString());
		final Button example01Button = (Button) solo.getCurrentActivity().findViewById(R.id.example_01_button);
		solo.clickOnView(example01Button);
		assertEquals(expectedStringAfter, example01TextView.getText().toString());
	}

	@Smoke
	public void testExample02() {
		//clicking a view by searching for the text
		final String touchText = "touch this text";
		final String touchReceived = "touch received";
		
		final TextView example02TextView = (TextView) solo.getCurrentActivity().findViewById(R.id.example_02_text_view);
		assertEquals(touchText, example02TextView.getText().toString());
		solo.clickOnText(touchText);
		assertEquals(touchReceived, example02TextView.getText().toString());
	}

	@Smoke
	public void testExample03() {
		//testing between multiple activities
		final String expectedStringTextView = "yay, we got here!";
		final String expectedStringCurrentActivity = "should have moved into NewActivity";
		
		final Button example03Button = (Button) solo.getCurrentActivity().findViewById(R.id.example_03_button);
		solo.clickOnView(example03Button);
		solo.assertCurrentActivity(expectedStringCurrentActivity, NewActivity.class);
		final TextView example03TextView = (TextView) solo.getCurrentActivity().findViewById(R.id.example_03_text_view);
		assertEquals(expectedStringTextView, example03TextView.getText().toString());
	}
	
}