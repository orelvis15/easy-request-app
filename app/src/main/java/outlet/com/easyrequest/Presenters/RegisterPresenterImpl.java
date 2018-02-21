package outlet.com.easyrequest.Presenters;

import android.content.SharedPreferences;

import outlet.com.easyrequest.Interactors.RegisterInteractorImpl;
import outlet.com.easyrequest.Interfaces.Register;

/**
 * Created by orelv on 2/20/2018.
 */

public class RegisterPresenterImpl implements Register.Presenter,Register.onRegisterFinishListener{

    private Register.View view;
    private Register.Interactor interactor;

    public RegisterPresenterImpl(Register.View view) {
        this.view = view;
        interactor = new RegisterInteractorImpl();
    }

    @Override
    public void validator(String user,String email, String password, String confirmPassword, SharedPreferences prefer) {
        interactor.validator(user,email,password,confirmPassword,this,prefer);
    }

    @Override
    public void userError() {
        view.setErrorUser();
    }

    @Override
    public void emailError() {
        view.setErrorEmail();
    }

    @Override
    public void passwordError() {
        view.setErrorPassword();
    }

    @Override
    public void confirmPasswordError() {
        view.setErrorConfirmPassword();
    }

    @Override
    public void setErrorNotEquals() {
        view.setErrorNotEquals();
    }

    @Override
    public void errorNetwork() {
        view.errorNetwork();
    }

    @Override
    public void errorRequest() {
        view.errorRequest();
    }

    @Override
    public void onBack() {
        view.onBack();
    }

    @Override
    public void showMessage(int sms) {
        view.showMessage(sms);
    }

    @Override
    public void inactiveActivity() {
        view.inactiveActivity();
    }

    @Override
    public void activeActivity() {
        view.activeActivity();
    }
}
