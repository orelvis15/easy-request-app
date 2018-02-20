package outlet.com.easyrequest.Interfaces;

/**
 * Created by orelv on 2/19/2018.
 */

public interface Login {

    public interface View {

        void setErrorUser();

        void setErrorPassword();

    }

    public interface onLoginFinishListener {

        void userError();

        void passwordError();

    }

 /*-------------------------------------------*/

    public interface Presenter {

        void validator(String user, String password);

    }

/*----------------------------------------------*/

    public interface Interactor {

        void validator(String user, String password, Login.onLoginFinishListener listener);

    }
}