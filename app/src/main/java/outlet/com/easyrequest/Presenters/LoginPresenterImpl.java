package outlet.com.easyrequest.Presenters;

import outlet.com.easyrequest.Interactors.LoginInteractorImpl;
import outlet.com.easyrequest.Interfaces.Login;

/**
 * Created by orelv on 2/19/2018.
 */

public class LoginPresenterImpl implements Login.Presenter,Login.onLoginFinishListener {

    private Login.View view;
    private Login.Interactor interactor;

    public LoginPresenterImpl(Login.View view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl();
    }

    @Override
    public void validator(String user, String password) {

        interactor.validator(user,password,this);
    }

    @Override
    public void userError() {
        view.setErrorUser();
    }

    @Override
    public void passwordError() {
        view.setErrorPassword();
    }

}
