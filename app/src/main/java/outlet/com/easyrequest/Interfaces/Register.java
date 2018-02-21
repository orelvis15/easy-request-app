package outlet.com.easyrequest.Interfaces;

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

    }

    public interface onRegisterFinishListener{

        void userError();
        void emailError();
        void confirmPasswordError();
        void passwordError();
        void setErrorNotEquals();

    }

    public interface Presenter{

        void validator(String user,String email,String password,String confirmPassword);

    }
    public interface Interactor{

        void validator(String user,String email,String password,String confirmPassword, Register.onRegisterFinishListener listener);

    }

}
