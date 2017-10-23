package com.example.internetconnectiondemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  private NetworkInfo getNetworkInfo()
  {
    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    return activeNetworkInfo;
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
    TextView textView = (TextView)findViewById(R.id.textView);
    TextView textView2 = (TextView)findViewById(R.id.textView2);

    NetworkInfo activeNetworkInfo = getNetworkInfo();

    if (activeNetworkInfo != null && activeNetworkInfo.isConnected())
    {
      Toast.makeText(this, "Internet is working", Toast.LENGTH_SHORT).show();
      Log.d("Demo", activeNetworkInfo.toString());

//      textView.setText("Network Status: Connected");
      textView.setText(activeNetworkInfo.toString().replace(',', '\n'));

      if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI)
      {
        textView2.setText("Type: " + activeNetworkInfo.getTypeName());
      }
      else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
      {
        textView2.setText("Type: " + activeNetworkInfo.getTypeName());
      }
    }
    else
    {
      Toast.makeText(this, "No internet connection found", Toast.LENGTH_SHORT).show();
      textView.setText("Network Status: Not Connected");
      textView2.setText("");
    }
  }

  public void onButtonClick(View view)
  {
    checkInternetConnection();
  }
}
