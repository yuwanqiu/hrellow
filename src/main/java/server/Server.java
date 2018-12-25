package server;

import bean.Bean;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Server {
    @GET("moreAnchor.android?&type=0&index=0")
    Call<Bean> onReset();
}
