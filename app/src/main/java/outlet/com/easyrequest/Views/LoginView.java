package outlet.com.easyrequest.Views;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import outlet.com.easyrequest.Interfaces.Login;
        import outlet.com.easyrequest.Presenters.LoginPresenterImpl;
        import outlet.com.easyrequest.R;

public class LoginView extends AppCompatActivity implements Login.View,View.OnClickListener{


    private TextView password;
    private TextView user;

    private Button login;
    private Button register;

    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password = (TextView) findViewById(R.id.et_password);
        user = (TextView) findViewById(R.id.et_user);

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        register = (Button) findViewById(R.id.btn_register);
        register.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    public void setErrorUser() {
        user.setError(getString(R.string.obligatory_field));
    }

    @Override
    public void setErrorPassword() {
        password.setError(getString(R.string.obligatory_field));
    }

    public void validator() {
        presenter.validator(user.getText().toString(),password.getText().toString());
    }

    public void navigateToRegister() {
        Intent i = new Intent(this,RegisterView.class);
        startActivity(i);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login){
            validator();
        }else if(v.getId() == R.id.btn_register){
            navigateToRegister();
        }
    }
}
