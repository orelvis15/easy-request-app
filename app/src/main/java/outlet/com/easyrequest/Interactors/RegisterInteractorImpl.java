package outlet.com.easyrequest.Interactors;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import outlet.com.easyrequest.Data.Model.RegisterPost;
import outlet.com.easyrequest.Data.Remote.APIService;
import outlet.com.easyrequest.Data.Remote.ApiUtils;
import outlet.com.easyrequest.Interfaces.Register;
import outlet.com.easyrequest.R;
import outlet.com.easyrequest.Views.RegisterView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by orelv on 2/20/2018.
 */

public class RegisterInteractorImpl implements Register.Interactor {

    private APIService mApiServices;
    private Context context;
    private SharedPreferences pref;

    @Override
    public void validator(String user,String email, String password, String confirmPassword, Register.onRegisterFinishListener listener, SharedPreferences prefer) {
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
            listener.inactiveActivity();
            mApiServices = ApiUtils.getAPIService();

            sendPost(user,email,password,listener,prefer);




        }
    }

    public void sendPost(String name, String email, String password, final Register.onRegisterFinishListener listener, final SharedPreferences prefer) {
        mApiServices.savePost(name, email, password,"client").enqueue(new Callback<RegisterPost>() {
            @Override
            public void onResponse(Call<RegisterPost> call, Response<RegisterPost> response) {

                if(response.isSuccessful()) {
                    //solicitud entregada
                    SharedPreferences.Editor edit = prefer.edit();
                    edit.putString("token",response.body().getToken());
                    edit.commit();
                    listener.onBack();
                    listener.showMessage(R.string.pleaseConfirmUser);

                }else{
                    //error de solicitud
                    listener.errorRequest();
                    listener.activeActivity();
                }
            }

            @Override
            public void onFailure(Call<RegisterPost> call, Throwable t) {
                //error de red
                listener.errorNetwork();
                listener.activeActivity();
            }
        });
    }

}
