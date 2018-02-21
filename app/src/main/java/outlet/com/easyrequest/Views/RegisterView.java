package outlet.com.easyrequest.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import outlet.com.easyrequest.Interfaces.Register;
import outlet.com.easyrequest.Presenters.RegisterPresenterImpl;
import outlet.com.easyrequest.R;

public class RegisterView extends AppCompatActivity implements Register.View, View.OnClickListener{

    Toolbar tb;

    TextView user;
    TextView email;
    TextView password;
    TextView confirmpassword;

    Button register;

    Register.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tb.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBack();
            }
        });

        user = (TextView) findViewById(R.id.et_user);
        email = (TextView) findViewById(R.id.et_email);
        password = (TextView) findViewById(R.id.et_password);
        confirmpassword = (TextView) findViewById(R.id.et_confirmpassword);
        register = (Button) findViewById(R.id.btn_register);

        register.setOnClickListener(this);

        presenter = new RegisterPresenterImpl(this);
    }

    public void onBack(){
        this.finish();
    }


    @Override
    public void setErrorUser() {
        user.setError(getString(R.string.obligatory_field));
    }

    @Override
    public void setErrorEmail() {
        email.setError(getString(R.string.obligatory_field));
    }

    @Override
    public void setErrorPassword() {
        password.setError(getString(R.string.obligatory_field));
    }

    @Override
    public void setErrorConfirmPassword() {
        confirmpassword.setError(getString(R.string.obligatory_field));
    }

    @Override
    public void setErrorNotEquals() {
      Toast.makeText(this,getString(R.string.password_not_equals),Toast.LENGTH_SHORT).show();
    }


    public void validator(){
        presenter.validator(user.getText().toString(),email.getText().toString(),password.getText().toString(),confirmpassword.getText().toString());
    }

    @Override
    public void onClick(View v) {
        validator();
    }
}
