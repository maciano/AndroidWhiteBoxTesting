package com.shinetech.robotium;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class NewActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity);

		final TextView example04TextView = (TextView) findViewById(R.id.example_04_text_view);
		final EditText example04EditText = (EditText) findViewById(R.id.example_04_edit_text);
		final Button example04Button = (Button) findViewById(R.id.example_04_button);
		example04Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				example04TextView.setText(example04EditText.getText().toString());
			}
		});

		String extra = getIntent().getStringExtra("example05");
		if (extra != null) {
			((TextView) findViewById(R.id.example_05_text_view)).setText(extra);
		} else {
			((TextView) findViewById(R.id.example_05_text_view)).setText("no text was found");
		}

		TextView example06TextView = (TextView)findViewById(R.id.example_06_text_view);
		example06TextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View animatedView) {
				Animation fadeOut = new AlphaAnimation(1, 0);
				fadeOut.setInterpolator(new AccelerateInterpolator());
				fadeOut.setDuration(1000);
				fadeOut.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationStart(Animation animation) {}

					@Override
					public void onAnimationRepeat(Animation animation) {}

					@Override
					public void onAnimationEnd(Animation animation) {
						animatedView.setVisibility(View.GONE);
					}
				});
				animatedView.startAnimation(fadeOut);
			}
		});

	}
}
