package com.shinetech.robotium.test;

import com.jayway.android.robotium.solo.Solo;
import com.shinetech.robotium.Main;
import com.shinetech.robotium.NewActivity;
import com.shinetech.robotium.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.Button;
import android.widget.TextView;


public class TestFirstActivity extends ActivityInstrumentationTestCase2<Main> {
	private Solo solo;
	
	public TestFirstActivity() {
		super(Main.class);
		}

	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	
	public void test01ClickButton01(){
		solo.assertCurrentActivity("Check on first activity", Main.class);
		
		final Button button01 = (Button) solo.getCurrentActivity().findViewById(R.id.example_01_button);
		solo.clickOnView(button01);
		
		final TextView label01= (TextView) solo.getCurrentActivity().findViewById(R.id.example_01_text_view);
	    assertEquals("after click",label01.getText().toString());

	    
	    
	}
	
	public void test02TouchLabel(){
		
		final TextView touchableLabel= (TextView) solo.getCurrentActivity().findViewById(R.id.example_02_text_view);
		solo.clickOnView(touchableLabel);
		
		assertEquals("touch received",touchableLabel.getText().toString());
		
	}
	
	public void test03NewActivityLaunched(){
			    
	    final Button newActivitybutton= (Button) solo.getCurrentActivity().findViewById(R.id.example_03_button);
	    solo.clickOnView(newActivitybutton);
	    
		solo.assertCurrentActivity("Check new activity", NewActivity.class);
//		assertEquals(true,solo.getString("after click"));
		
	}
	


}
