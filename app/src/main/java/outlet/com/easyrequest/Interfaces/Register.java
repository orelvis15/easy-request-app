package outlet.com.easyrequest.Interfaces;

/**
 * Created by orelv on 2/20/2018.
 */

public interface Register {

    public interface View{

        void setErrorUser();
        void setErrorPassword();
        void setErrorConfirmPassword();
        void setErrorNotEquals();

    }

    public interface onRegisterFinishListener{

        void userError();
        void passwordError();
        void confirmPasswordError();
        void setErrorNotEquals();

    }

    public interface Presenter{

        void validator(String user,String password,String confirmPassword);

    }
    public interface Interactor{

        void validator(String user,String password,String confirmPassword, Register.onRegisterFinishListener listener);

    }

}
