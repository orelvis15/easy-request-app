package outlet.com.easyrequest.Views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
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

    SharedPreferences sharedPref;

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

        sharedPref = getPreferences(Context.MODE_PRIVATE);

    }

    @Override
    public void onBack(){
        this.finish();
    }

    @Override
    public void showMessage(int sms) {
        Toast.makeText(this,getString(sms),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void inactiveActivity() {
        user.setEnabled(false);
        email.setEnabled(false);
        password.setEnabled(false);
        confirmpassword.setEnabled(false);
        register.setEnabled(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @Override
    public void activeActivity() {
        user.setEnabled(true);
        email.setEnabled(true);
        password.setEnabled(true);
        confirmpassword.setEnabled(true);
        register.setEnabled(true);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
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
    public void errorNetwork() {
        Toast.makeText(this,getString(R.string.networkError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorRequest() {
        Toast.makeText(this,getString(R.string.requestError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorNotEquals() {
      Toast.makeText(this,getString(R.string.password_not_equals),Toast.LENGTH_SHORT).show();
    }

    public void validator(){
        presenter.validator(user.getText().toString(),email.getText().toString(),password.getText().toString(),confirmpassword.getText().toString(),sharedPref);
    }

    @Override
    public void onClick(View v) {
        validator();
    }
}
