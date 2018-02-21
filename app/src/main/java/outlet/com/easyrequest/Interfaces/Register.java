package outlet.com.easyrequest.Interfaces;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by orelv on 2/20/2018.
 */

public interface Register {

    public interface View{

        void setErrorUser();
        void setErrorEmail();
        void setErrorPassword();
        void setErrorConfirmPassword();
        void setErrorNotEquals();
        void errorNetwork();
        void errorRequest();
        void onBack();
        void showMessage(int sms);
        void inactiveActivity();
        void activeActivity();

    }

    public interface onRegisterFinishListener{

        void userError();
        void emailError();
        void confirmPasswordError();
        void passwordError();
        void setErrorNotEquals();
        void errorNetwork();
        void errorRequest();
        void onBack();
        void showMessage(int sms);
        void inactiveActivity();
        void activeActivity();

    }

    public interface Presenter{

        void validator(String user, String email, String password, String confirmPassword, SharedPreferences prefer);

    }
    public interface Interactor{

        void validator(String user,String email,String password,String confirmPassword, Register.onRegisterFinishListener listener, SharedPreferences prefer);

    }

}
