package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {

    Button createAccountButton,clearButton;
    EditText name,username,password,confirmPassword,email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initializeViews();
        createAccountButton.setBackgroundColor(getColor(R.color.white));
        clearButton.setBackgroundColor(getColor(R.color.white));



        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String Name = name.getText().toString();
                final String Email = email.getText().toString();
                final String Username = username.getText().toString();
                final String Password = password.getText().toString();
                final String ConfirmPassword = confirmPassword.getText().toString();
                String Expn =
                        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                                +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                                +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                                +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

                System.out.println("Email "+Email+"Username"+username+"Password"+Password+"confirm password"+confirmPassword);

                if (ConfirmPassword.isEmpty() && Password.isEmpty() && Email.isEmpty() && Username.isEmpty()) {
                    email.requestFocus();
                    email.setError("FIELD CANNOT BE EMPTY");
                    username.setError("FIELD CANNOT BE EMPTY");
                    confirmPassword.setError("FIELD CANNOT BE EMPTY");
                    password.setError("FIELD CANNOT BE EMPTY");

                    email.setBackgroundColor(getColor(R.color.alert));
                    username.setBackgroundColor(getColor(R.color.alert));
                    confirmPassword.setBackgroundColor(getColor(R.color.alert));
                    password.setBackgroundColor(getColor(R.color.alert));

                    Toast.makeText(MainActivity2.this, "Enter All the Required Field", Toast.LENGTH_LONG).show();
                } else if (!Name.matches("[a-zA-Z ]+") ) {
                    name.requestFocus();
                    name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    name.setBackgroundColor(getColor(R.color.alert));
                } else if (!Username.matches("[a-zA-Z ]+")) {
                    username.requestFocus();
                    username.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    username.setBackgroundColor(getColor(R.color.alert));
                } else if (!Email.matches(Expn)){
                    email.requestFocus();
                    email.setError("Invaild Email");
                    email.setBackgroundColor(getColor(R.color.alert));
                } else if (Password.length() < 8) {
                    password.requestFocus();
                    password.setError("Password length Should be 8");
                    password.setBackgroundColor(getColor(R.color.alert));
                } else if (ConfirmPassword.length() < 8  ) {
                    confirmPassword.requestFocus();
                    confirmPassword.setError("Password length Should be 8");
                    confirmPassword.setBackgroundColor(getColor(R.color.alert));
                } else if (!ConfirmPassword.equals(Password)) {
                    confirmPassword.requestFocus();
                    confirmPassword.setError("Password Mismatch");
                } else {
                    Toast.makeText(MainActivity2.this, "Validation Successful", Toast.LENGTH_LONG).show();
                }


            }

        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.getText().clear();
                email.getText().clear();
                username.getText().clear();
                password.getText().clear();
                confirmPassword.getText().clear();
            }
        });



    }


    private void initializeViews() {
        createAccountButton=findViewById(R.id.create_account_button);
        clearButton=findViewById(R.id.clear_button);
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirm_password);

    }
}