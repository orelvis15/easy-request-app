package outlet.com.easyrequest.Views;

        import android.animation.AnimatorSet;
        import android.animation.ObjectAnimator;
        import android.content.Intent;
        import android.graphics.Point;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Display;
        import android.view.View;
        import android.view.animation.AnimationSet;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import outlet.com.easyrequest.Interfaces.Login;
        import outlet.com.easyrequest.Presenters.LoginPresenterImpl;
        import outlet.com.easyrequest.R;

public class LoginView extends AppCompatActivity implements Login.View,View.OnClickListener{


    private TextView password;
    private TextView user;

    private Button login;
    private TextView img;

    ImageView logo1;
    ImageView logo2;

    long duration = 1000;

    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        logo1 = (ImageView) findViewById(R.id.logo1);
        logo2 = (ImageView) findViewById(R.id.logo2);

        password = (TextView) findViewById(R.id.et_password);
        user = (TextView) findViewById(R.id.et_user);

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        img = (TextView) findViewById(R.id.txt);
        img.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //animationLogo();
    }

    private void animationLogo(){
        Display display = getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        final int width = point.x; // screen width
        final float halfW = width/2.0f;

        ObjectAnimator oa1 = ObjectAnimator.ofFloat(logo1,"translationX",0f,halfW);
        oa1.setDuration(duration);

        ObjectAnimator oa2 = ObjectAnimator.ofFloat(logo2,"translationX",halfW,0f );
        oa2.setDuration(duration);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(oa1,oa2);
        animatorSet.start();
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
        }else if(v.getId() == R.id.txt){
            navigateToRegister();
        }
    }
}
