package com.shinetech.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;


public class NewActivityTest extends ActivityInstrumentationTestCase2<NewActivity>{
	private Solo solo;
	
	public NewActivityTest() {
		super(NewActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Smoke
	public void testExample04() {
		//basic data input
		final String sampleText = "sample text";
		final EditText example04EditText = (EditText) solo.getCurrentActivity().findViewById(R.id.example_04_edit_text);
		final Button example04Button = (Button) solo.getCurrentActivity().findViewById(R.id.example_04_button);
		final TextView example04TextView = (TextView) solo.getCurrentActivity().findViewById(R.id.example_04_text_view);
		solo.enterText(example04EditText, sampleText);
		solo.clickOnView(example04Button);
		assertEquals(sampleText, example04TextView.getText().toString());
	}
}