package com.nlscan.android.setdemodata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSetup;
    private Button btnClear;
    private EditText editText;
    private Bundle extras;
    private static final String SET_DEMO_DATA = "SET_DEMO_DATA";
    private static final String ACTION_SET_DEMO_DATA = "nlscan.action.ACTION_SET_DEMO_DATA";
    private static final String TAG = "SET_DEMO_DATA_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnSetup = findViewById(R.id.btnSetup);
        btnClear = findViewById(R.id.btnClear);
        btnSetup.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        extras = new Bundle();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSetup:
                btnSetupClicked();
                break;
            case R.id.btnClear:
                editText.setText("");
                break;
            default:
                break;
        }
    }

    private void btnSetupClicked() {
        String demoData = editText.getText().toString().trim();
        if(TextUtils.isEmpty(demoData)){
            Toast.makeText(getApplicationContext(), "Data should not be empty!", Toast.LENGTH_LONG).show();
            return;
        }

        extras.putString(SET_DEMO_DATA,demoData);
        Intent demoDataIntent = new Intent(ACTION_SET_DEMO_DATA);
        demoDataIntent.putExtra(SET_DEMO_DATA, extras);
        sendBroadcast(demoDataIntent);
        Log.d(TAG,extras.toString());
        Toast.makeText(getApplicationContext(), "Demo data has been set.", Toast.LENGTH_LONG).show();
    }
}
