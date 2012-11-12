package net.aldakur.app.intent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button1).setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_VIEW);
		//url bat pasatzerako orduan ezin da pasa zuzenean
		//partxeatu beharra dago
		intent.setData(Uri.parse("http://www.aldakur.net"));
		startActivity(intent);
	}

}
