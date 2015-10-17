package com.dbco.gpavlovic.shutterstock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;

import com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock.ShutterImageInfo;
import com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock.ShutterResponse;
import com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock.ShutterStock;
import com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock.ShutterStockService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity
{
    private List<ShutterImageInfo> mImageList;
    private ShutterResponseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup the view
        RecyclerView imageGrid = (RecyclerView) findViewById(R.id.image_grid);

        imageGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mImageList = new ArrayList<ShutterImageInfo>();
        mAdapter = new ShutterResponseAdapter(this, mImageList);
        //mAdapter.setOnItemClockListener();
        imageGrid.setAdapter(mAdapter);

        // Make HTTP request for images
        ShutterStockService shutterStockService = ShutterStock.getServiceInstance();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -5);
        String formattedDate = (String) DateFormat.format("yyyy-MM-dd", cal);
        Call<ShutterResponse> getRecentImages = shutterStockService.recentImages(formattedDate);
        getRecentImages.enqueue(new Callback<ShutterResponse>()
        {
            @Override
            public void onResponse(Response<ShutterResponse> response, Retrofit retrofit)
            {
                updateImages(response);
            }

            @Override
            public void onFailure(Throwable t)
            {

            }
        });
    }

    private void updateImages(retrofit.Response<ShutterResponse> response)
    {
        mImageList.clear();
        mImageList.addAll(response.body().getImageInfo());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
