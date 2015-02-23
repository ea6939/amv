/*
 * amv calculator
 * ELITSA ASENOVA - 260481980, JUNYANG WANG - 260251358
 */
package com.amv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button b1, b2;
	int method;
	EditText et1, et2, et3, et4, et5, et6, et7, et8, et9;
	TextView tvResult;
	RelativeLayout rl2, rl3;
	VectorTest vt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
		et4 = (EditText) findViewById(R.id.et4);
		et5 = (EditText) findViewById(R.id.et5);
		et6 = (EditText) findViewById(R.id.et6);
		et7 = (EditText) findViewById(R.id.et7);
		et8 = (EditText) findViewById(R.id.et8);
		et9 = (EditText) findViewById(R.id.et9);
		
		rl2 = (RelativeLayout) findViewById(R.id.rl2);
		rl3 = (RelativeLayout) findViewById(R.id.rl3);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		b1 = (Button) findViewById(R.id.b1);
		b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	final CharSequence[] items = {"2 vectors addition", "3 vectors addition", "scalar product", "vector product"};
				
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Select a method");
				builder.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				    	switch(item){
				    	case 0:
				    		method = 1;
				    		b1.setText("2 vectors addition");
				    		rl3.setVisibility(View.GONE);
				    		break;
				    	case 1:
				    		method = 2;
				    		b1.setText("3 vectors addition");
				    		rl3.setVisibility(View.VISIBLE);
				    		break;
				    	case 2:
				    		method = 3;
				    		b1.setText("scalar product");
				    		rl3.setVisibility(View.GONE);
				    		break;
				    	case 3:
				    		method = 4;
				    		b1.setText("vector product");
				    		rl3.setVisibility(View.GONE);
				    		break;
				    	}
				    }
				});
				AlertDialog alert = builder.create();
				alert.show();
            }
        });
		
		b2 = (Button) findViewById(R.id.b2);
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				double v1 = 0.0;
				if (!et1.getText().toString().contentEquals("")){
					v1 = (double) Integer.valueOf(et1.getText().toString());
				}
				double v2 = 0.0;
				if (!et2.getText().toString().contentEquals("")){
					v2 = (double) Integer.valueOf(et2.getText().toString());
				}
				double v3 = 0.0;
				if (!et3.getText().toString().contentEquals("")){
					v3 = (double) Integer.valueOf(et3.getText().toString());
				}
				double v4 = 0.0;
				if (!et4.getText().toString().contentEquals("")){
					v4 = (double) Integer.valueOf(et4.getText().toString());
				}
				double v5 = 0.0;
				if (!et5.getText().toString().contentEquals("")){
					v5 = (double) Integer.valueOf(et5.getText().toString());
				}
				double v6 = 0.0;
				if (!et6.getText().toString().contentEquals("")){
					v6 = (double) Integer.valueOf(et6.getText().toString());
				}
				double v7 = 0.0;
				if (!et7.getText().toString().contentEquals("")){
					v7 = (double) Integer.valueOf(et7.getText().toString());
				}
				double v8 = 0.0;
				if (!et8.getText().toString().contentEquals("")){
					v8 = (double) Integer.valueOf(et8.getText().toString());
				}
				double v9 = 0.0;
				if (!et9.getText().toString().contentEquals("")){
					v9 = (double) Integer.valueOf(et9.getText().toString());
				}
				
				String result = "";
				Vector vResult = new Vector();
				Operations ops = new Operations();
				if (method == 1){
					Vector vct1 = new Vector(v1, v2, v3);
					Vector vct2 = new Vector(v4, v5, v6);
			        
			        vResult = ops.add(vct1, vct2, new Vector());
			        result = vResult.toString();
				} else if (method == 2){
					Vector vct1 = new Vector(v1, v2, v3);
					Vector vct2 = new Vector(v4, v5, v6);
					Vector vct3 = new Vector(v7, v8, v9);
			        
					vResult = ops.add(vct1, vct2, vct3);
					result = vResult.toString();
				} else if (method == 3){
					Vector vct1 = new Vector(v1, v2, v3);
					Vector vct2 = new Vector(v4, v5, v6);
			        
					result = String.valueOf(ops.scalarProduct(vct1, vct2));
				} else if (method == 4){
					Vector vct1 = new Vector(v1, v2, v3);
					Vector vct2 = new Vector(v4, v5, v6);
			        
					vResult = ops.crossProduct(vct1, vct2);
					result = vResult.toString();
				} else {
					Toast.makeText(getApplicationContext(), 
							"Please select a method", 
							Toast.LENGTH_SHORT).show();
				}
				
				tvResult.setText(result);
			}
		});
	}
	
	
}

