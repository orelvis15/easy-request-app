package outlet.com.easyrequest.Data.Remote;

import outlet.com.easyrequest.Data.Model.RegisterPost;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by orelv on 2/21/2018.
 */

public interface APIService {

    @POST("register")
    @FormUrlEncoded
    Call<RegisterPost> savePost(@Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password,
                                @Field("role") String role);
}