package com.exchange.yes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.gc.materialdesign.views.LayoutRipple;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		 LayoutRipple Rip_personal = (LayoutRipple) findViewById(R.id.rip_personal);

	        Rip_personal.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(HomeActivity.this,ExchangeActivity.class);
					startActivity(intent);
				}
			});
		
	        LayoutRipple Rip_account = (LayoutRipple) findViewById(R.id.rip_account);

	        Rip_account.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(HomeActivity.this,ButtonsActivity.class);
					startActivity(intent);
				}
			});
	        
	        LayoutRipple Rip_exchange = (LayoutRipple) findViewById(R.id.rip_exchange);

	        Rip_exchange.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(HomeActivity.this,ButtonsActivity.class);
					startActivity(intent);
				}
			});
	        
	        LayoutRipple Rip_setting = (LayoutRipple) findViewById(R.id.rip_setting);

	        Rip_setting.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(HomeActivity.this,ButtonsActivity.class);
					startActivity(intent);
				}
			});
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
