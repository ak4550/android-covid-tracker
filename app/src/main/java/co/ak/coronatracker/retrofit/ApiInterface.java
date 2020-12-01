package co.ak.coronatracker.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/country/{countryName}")
    Call<List<ItemModel>> getCountry(@Path("countryName") String countryName);
}
