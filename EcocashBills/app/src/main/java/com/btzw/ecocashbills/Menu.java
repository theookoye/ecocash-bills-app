package com.btzw.ecocashbills;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    private Button merchant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        merchant = (Button) findViewById(R.id.merchant) ;
//        merchant.setOnClickListener(new View.OnClickListener(){
//          public void onClick(View v){
//
//              Intent merchantIntent = new Intent(Intent.ACTION_CALL);
//              merchantIntent.setData(Uri.parse("tel:"));
//
//              if(ActivityCompat.checkSelfPermission(Menu.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//                  return;
//              }
//
//              startActivity(merchantIntent);
//          }
//        });
    }

    public void invoke(View v){
        String code = "";
        switch(v.getId()){
            case R.id.zesa:
                code="*151*2*6*1*1";
                break;

            case R.id.kwese:
                code="*151*2*6*2*1";
                break;

            case R.id.tollgates:
                code="*151*2*6*5";
                break;

            case R.id.merchant :
                code="*151*2*2";
                break;

            case R.id.biller:
                code="*151*2*1";
                break;

            case R.id.fees:
                code="*151*2*3";
                break;
        }
        Intent merchantIntent = new Intent(Intent.ACTION_CALL);
        merchantIntent.setData(Uri.parse("tel:" + code +  Uri.encode("#")));

        if(ActivityCompat.checkSelfPermission(Menu.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
          ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
          return ;
        }

        startActivity(merchantIntent);

    }
}
