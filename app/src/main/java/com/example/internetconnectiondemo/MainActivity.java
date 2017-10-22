package com.example.internetconnectiondemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  private boolean isNetworkAvailable()
  {
    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    checkInternetConnection();
  }

  private void checkInternetConnection()
  {
    if (isNetworkAvailable())
    {
      Toast.makeText(this, "Internet is working", Toast.LENGTH_SHORT).show();
    }
    else
    {
      Toast.makeText(this, "No internet connection found", Toast.LENGTH_SHORT).show();
    }
  }

  public void onButtonClick(View view)
  {
    checkInternetConnection();
  }
}
