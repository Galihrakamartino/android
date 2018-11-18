package com.example.garong.networking;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.garong.networking.Adapter.MyAdapter;
import com.example.garong.networking.Rest.ApiClient;
import com.example.garong.networking.Rest.ApiInterface;
import com.example.garong.networking.model.GetPembelian;
import com.example.garong.networking.model.Pembelian;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btGet;
    ApiInterface mApiInterface;
    FloatingActionButton fb,fc;

    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGet = (Button) findViewById(R.id.btGet);
        fb = (FloatingActionButton) findViewById(R.id.btnuntukpindahsecepatkilatsebelumpakfaridbisamelihatnya);
        fc = (FloatingActionButton) findViewById(R.id.btnuntukpindahyanglambat);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLayoutManager);

        mApiInterface  = ApiClient.getClient().create(ApiInterface.class);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this,LayarDetail.class);
                startActivity(myintent);
            }
        });
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<GetPembelian> pembelianCall = mApiInterface.getPembelian();
                pembelianCall.enqueue(new Callback<GetPembelian>() {
                    @Override
                    public void onResponse(Call<GetPembelian> call, Response<GetPembelian> response) {
                        List<Pembelian> pembelianList = response.body().getListDataPembelian();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " + String.valueOf(pembelianList.size()));


                        mAdapter = new MyAdapter(pembelianList);
                        mRecyclerview.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetPembelian> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetPembelian> pembelianCall = mApiInterface.getPembelian();
                pembelianCall.enqueue(new Callback<GetPembelian>() {
                    @Override
                    public void onResponse(Call<GetPembelian> call, Response<GetPembelian> response) {
                        List<Pembelian> pembelianList = response.body().getListDataPembelian();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " + String.valueOf(pembelianList.size()));


                        mAdapter = new MyAdapter(pembelianList);
                        mRecyclerview.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetPembelian> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {

            case R.id.menuTambahTransPembelian:
                mIntent = new Intent(this, LayarDetail.class);
                startActivity(mIntent);
                return true;

            case R.id.menuListPembeli:
                mIntent = new Intent(this, LayarListPembeli.class);
                startActivity(mIntent);
                return true;

            case R.id.menuInsertDataPembeli:
                Intent intent = new Intent(this, LayarInsertPembeli.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
