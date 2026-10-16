package com.example.egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepeatPassword;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        textViewMessage = findViewById(R.id.textViewMessage);
        Button buttonConfirm = findViewById(R.id.buttonConfirm);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateRegistration();
            }
        });
    }

    private void validateRegistration() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String repeatedPassword = editTextRepeatPassword.getText().toString();

        if (!email.contains("@")) {
            textViewMessage.setText(R.string.message_invalid_email);
        } else if (!password.equals(repeatedPassword)) {
            textViewMessage.setText(R.string.message_passwords_differ);
        } else {
            textViewMessage.setText(getString(R.string.message_welcome, email));
        }
    }
}