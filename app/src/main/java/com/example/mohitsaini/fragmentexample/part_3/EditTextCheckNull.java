package com.example.mohitsaini.fragmentexample.part_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

public class EditTextCheckNull extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_check_null);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        e6 = (EditText) findViewById(R.id.e6);
        e7 = (EditText) findViewById(R.id.e7);
        e8 = (EditText) findViewById(R.id.e8);
        e9 = (EditText) findViewById(R.id.e9);
        e10 = (EditText) findViewById(R.id.e10);

        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean fieldsOK = validate(new EditText[]{e1, e2, e3,
                        e4, e5, e6, e7,
                        e8, e9, e10});
                if (fieldsOK ) {
                    Toast.makeText(EditTextCheckNull.this, "fields sre ok", Toast.LENGTH_SHORT).show();
                    e1.setError(null);
                    e2.setError(null);
                    e3.setError(null);
                    e4.setError(null);
                    e5.setError(null);
                    e6.setError(null);
                    e7.setError(null);
                    e8.setError(null);
                    e9.setError(null);
                    e10.setError(null);
                }
                else {
                    e1.setError("");
                    e2.setError("");
                    e3.setError("");
                    e4.setError("");
                    e5.setError("");
                    e6.setError("");
                    e7.setError("");
                    e8.setError("");
                    e9.setError("");
                    e10.setError("");

                }
            }
        });
    }


    private boolean validate(EditText[] fields) {
        boolean result = true;
        for (int i = 0; i < fields.length; i++) {
            EditText currentField = fields[i];
            if (currentField.getText().toString().length() <= 0) {
                currentField.setError("");
                result = false;
            }
        }
        return result;
    }
}
