package com.shinetech.robotium.test;

import com.jayway.android.robotium.solo.Solo;
import com.shinetech.robotium.NewActivity;
import com.shinetech.robotium.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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
	
	public void testSendText(){
		final String sendedText = "texto prueba";
		
		final TextView label03=(TextView) solo.getCurrentActivity().findViewById(R.id.example_03_text_view);
		assertEquals("yay, we got here!",label03.getText().toString());
		
		final EditText editfield= (EditText) solo.getCurrentActivity().findViewById(R.id.example_04_edit_text);
		
		solo.enterText(editfield, sendedText);
		
		final Button button04 = (Button) solo.getCurrentActivity().findViewById(R.id.example_04_button);
		solo.clickOnView(button04);
		
		final TextView label04 = (TextView) solo.getCurrentActivity().findViewById(R.id.example_04_text_view);
		assertEquals(sendedText,label04.getText().toString());
		
		
		
	}
	
	public void testAnimateEvent(){
		
		
		
	}
	
}
