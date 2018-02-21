package outlet.com.easyrequest.Interactors;

import android.util.Log;
import android.widget.Toast;

import outlet.com.easyrequest.Data.Model.RegisterPost;
import outlet.com.easyrequest.Data.Remote.APIService;
import outlet.com.easyrequest.Data.Remote.ApiUtils;
import outlet.com.easyrequest.Interfaces.Register;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by orelv on 2/20/2018.
 */

public class RegisterInteractorImpl implements Register.Interactor {

    private APIService mApiServices;

    @Override
    public void validator(String user,String email, String password, String confirmPassword, Register.onRegisterFinishListener listener) {
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

            mApiServices = ApiUtils.getAPIService();
            sendPost(user,email,password);


        }
    }

    public void sendPost(String name, String email, String password) {
        mApiServices.savePost(name, email, password).enqueue(new Callback<RegisterPost>() {
            @Override
            public void onResponse(Call<RegisterPost> call, Response<RegisterPost> response) {

                if(response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    Log.d("okok", response.code()+"");

                }else{
                    Log.d("prueba mal", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<RegisterPost> call, Throwable t) {
                Log.d("Error", "Fallo al enviar el post");
            }
        });
    }

}
