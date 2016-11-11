package com.md;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.imagedemo.R;

public class MDActivity extends Activity {
    private TextInputLayout textInputLayout ;
    private EditText editText;
    private TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);
        textInputLayout = (TextInputLayout) findViewById(R.id.tin_one);
        textInputLayout.setHint("passWord");
        editText = textInputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()<6){
                    textInputLayout.setError("error");
                    textInputLayout.setEnabled(true);
                }else {
                    textInputLayout.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        editText = (EditText) findViewById(R.id.ed_one);
        textInputEditText = (TextInputEditText) findViewById(R.id.text1);
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()<6){
                    textInputEditText.setText("this is not correct");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}
