package outlet.com.easyrequest.Data.Remote;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by orelv on 2/21/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://easy-request.herokuapp.com/api/";


    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
