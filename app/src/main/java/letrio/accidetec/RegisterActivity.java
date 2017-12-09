package letrio.accidetec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private String fName;
    private String lName;
    private String mobileNo;
    private String username;
    private String password;

    private TextView fNameView;
    private TextView lNameView;
    private TextView mobileNoView;
    private TextView passwordView;
    private TextView usernameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button registerButton = (Button) findViewById(R.id.proceed);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();

            }
        });



    }


    // User registration basic details
    //Do database mapping in this fumction or create a separate ONE PRASHANT=====================
    private void registerUser() {

        fNameView = (TextView) findViewById(R.id.first_name);
        lNameView = (TextView) findViewById(R.id.last_name);
        mobileNoView = (TextView) findViewById(R.id.mobile_no);
        usernameView = (TextView) findViewById(R.id.username);
        passwordView = (TextView) findViewById(R.id.password);

        username = usernameView.getText().toString();
        password = passwordView.getText().toString();
        mobileNo = mobileNoView.getText().toString();
        fName = fNameView.getText().toString();
        lName = lNameView.getText().toString();



        boolean cancel = true;
        View focusView = null;


        if(!isEmailValid(username)){

            cancel = false;
            usernameView.setError(getString(R.string.error_invalid_email));
            focusView = usernameView;
            focusView.requestFocus();
        }


        if(!isPasswordValid(password)){

            cancel = false;
            passwordView.setError(getString(R.string.error_incorrect_password));
            focusView = passwordView;
            focusView.requestFocus();
        }


        if(fName == null){

            cancel = false;
            fNameView.setError(getString(R.string.no_name));
            focusView = fNameView;
            focusView.requestFocus();
        }


        if(lName == null){

            cancel = false;
            lNameView.setError(getString(R.string.no_name));
            focusView = lNameView;
            focusView.requestFocus();
        }

        if(mobileNoView.getText().toString().length() < 10){

            cancel = false;
            mobileNoView.setError(getString(R.string.incorrect_mobile));
            focusView = mobileNoView;
            focusView.requestFocus();
        }


    if(cancel){

      Intent in = new Intent(RegisterActivity.this, VehicleRegisterActivity.class);
        startActivity(in);
        finish();

    }




    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
