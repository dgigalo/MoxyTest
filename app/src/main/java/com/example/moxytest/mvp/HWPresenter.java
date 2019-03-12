package com.example.moxytest.mvp;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.moxytest.model.DataFull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


@InjectViewState
public class HWPresenter extends MvpPresenter<HWView> {
    private Retrofit retrofit;
    private DefaultApi defaultApi;

    public HWPresenter(){
        retrofit  = new Retrofit.Builder()
                .baseUrl("https://prnk.blob.core.windows.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        defaultApi = retrofit.create(DefaultApi.class);
        defaultApi.getFullData().enqueue(new Callback<DataFull>() {
            @Override
            public void onResponse(Call<DataFull> call, Response<DataFull> response) {
                DataFull dataFull = response.body();
                getViewState().getViews(dataFull.getView());
                getViewState().getData(dataFull.getData());
            }

            @Override
            public void onFailure(Call<DataFull> call, Throwable t) {
                Log.e("onFailure ", t.getMessage());
            }
        });

    }
    public interface DefaultApi {
        @GET("/tmp/JSONSample.json")
        Call<DataFull> getFullData();
    }
}
