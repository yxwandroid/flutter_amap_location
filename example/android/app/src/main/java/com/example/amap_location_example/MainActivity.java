package com.example.amap_location_example;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import io.flutter.Log;
import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);
     String sha =  sHA1(this);
    Log.d("wilson",sha);
  }


  public static String sHA1(Context context){
    try {
      PackageInfo info = context.getPackageManager().getPackageInfo(
              context.getPackageName(), PackageManager.GET_SIGNATURES);
      byte[] cert = info.signatures[0].toByteArray();
      MessageDigest md = MessageDigest.getInstance("SHA1");
      byte[] publicKey = md.digest(cert);
      StringBuffer hexString = new StringBuffer();
      for (int i = 0; i < publicKey.length; i++) {
        String appendString = Integer.toHexString(0xFF & publicKey[i])
                .toUpperCase(Locale.US);
        if (appendString.length() == 1)
          hexString.append("0");
        hexString.append(appendString);
        hexString.append(":");
      }
      String result=hexString.toString();
      return result.substring(0, result.length()-1);
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }

}
