package co.ak.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import co.ak.coronatracker.retrofit.ApiClient;
import co.ak.coronatracker.retrofit.ApiInterface;
import co.ak.coronatracker.retrofit.ItemModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    private static final String TAG = "MainActivity";

    private Spinner spinner;
    private TextView dateTxt, infectedTxt, deathTxt, recoverTxt;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        dateTxt = findViewById(R.id.date_txt);
        infectedTxt = findViewById(R.id.infected_txt);
        deathTxt = findViewById(R.id.death_txt);
        recoverTxt = findViewById(R.id.recover_txt);

        ArrayAdapter<CharSequence> spinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.country_drop_down, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemSelected: item " + parent.getItemAtPosition(position));
        Call<List<ItemModel>> list = apiInterface.getCountry(String.valueOf(parent.getItemAtPosition(position)));
        list.enqueue(new Callback<List<ItemModel>>() {
            @Override
            public void onResponse(Call<List<ItemModel>> call, Response<List<ItemModel>> response) {
                if(response.isSuccessful()){
                    ItemModel model = response.body().get(response.body().size()-1);
                    infectedTxt.setText(String.valueOf(model.getActive()));
                    recoverTxt.setText(String.valueOf(model.getRecovered()));
                    deathTxt.setText(String.valueOf(model.getDeaths()));
                    dateTxt.setText(String.valueOf(model.getDate()));
                }else{
                    Log.d(TAG, "onResponse: failed");
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<ItemModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}