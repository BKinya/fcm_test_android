package Rest;

import model.Fcm_tokens;
import model.Message_model;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("token")
    @FormUrlEncoded
    Call<Fcm_tokens>saveToken(
       @Field("token_string") String token_string
    );

    @POST
    @FormUrlEncoded
    Call<Message_model> saveMessage(
            @Field("message" )String message
    );
}
