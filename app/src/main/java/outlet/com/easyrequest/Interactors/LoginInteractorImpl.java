package outlet.com.easyrequest.Interactors;

import outlet.com.easyrequest.Interfaces.Login;

/**
 * Created by orelv on 2/19/2018.
 */

public class LoginInteractorImpl implements Login.Interactor {


    @Override
    public void validator(String user, String password, Login.onLoginFinishListener listener) {
        if (user.equals("")|| password.equals("")){
            if (user.equals("")){
                listener.userError();
            }else{
                listener.passwordError();
            }
        }else{
            //intentar registrarse
        }
    }
}
