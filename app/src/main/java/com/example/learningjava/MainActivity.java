package com.example.learningjava;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void disable(View v )
    {
        v.setEnabled(false);
        Button vbutton = (Button) v;

        if (v.getId() == R.id.button2)
        {
            handleText(findViewById(R.id.inputText));
            findViewById(R.id.button3).setEnabled(true);
            vbutton.setText("disabled");
            ((Button) findViewById(R.id.button3)).setText("enabled");
            Log.d("success","b3 enabled");
        }
        else {
            handleText(findViewById(R.id.inputText));
            findViewById(R.id.button2).setEnabled(true);
            vbutton.setText("disabled");
            ((Button) findViewById(R.id.button2)).setText("enabled");
            Log.d("success","b2 enabled");
        }

    }
    public void handleText(View v)
    {
        String txt = ((EditText) v).getText().toString();
        Log.d("text:", txt);
        Toast.makeText(this,"TestAlert",Toast.LENGTH_LONG).show();
        ((TextView) findViewById(R.id.hello)).setText(txt);
    }
    public void launchAct2(View v)
    {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}