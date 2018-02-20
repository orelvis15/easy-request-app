package outlet.com.easyrequest.Interactors;

import outlet.com.easyrequest.Interfaces.Register;

/**
 * Created by orelv on 2/20/2018.
 */

public class RegisterInteractorImpl implements Register.Interactor {
    @Override
    public void validator(String user, String password, String confirmPassword, Register.onRegisterFinishListener listener) {
        if (user.equals("") || password.equals("") || confirmPassword.equals("") || !password.equals(confirmPassword)){
            if (user.equals("")){
                listener.userError();
            }else if (password.equals("")){
                listener.passwordError();
            }else if (confirmPassword.equals("")){
                listener.passwordError();
            }else if(!password.equals(confirmPassword)){
                listener.setErrorNotEquals();
            }
        }else {
            //crear cuenta
        }
    }
}
