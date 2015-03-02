package edu.computerpower.student.webconnectivityapp;

import com.cp.dma.dma_android_webconnectivity.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		boolean val = this.checkWebConnection(); 

		if (val == true) { 

			Toast.makeText(MainActivity.this, "You have an Internet Connection",Toast.LENGTH_LONG).show(); 

		} else {

			Toast.makeText(MainActivity.this, " No Internet Connection",Toast.LENGTH_LONG).show();
		}

	}

	public boolean checkWebConnection() { 

		ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE); 

		NetworkInfo info = mgr.getActiveNetworkInfo();

		if (info.isConnectedOrConnecting()) {

			if (info.isConnected()) {

				return true;

			}

			return false;

		}

		return false;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
