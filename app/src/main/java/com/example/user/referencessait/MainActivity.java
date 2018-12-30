package com.example.user.referencessait;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=(TextView) findViewById(R.id.tv_link1);
        String textToFirstTv="rusdelphi.com";
        SpannableString ss=new SpannableString(textToFirstTv);
        ss.setSpan(new URLSpan(String.valueOf(textToFirstTv)),0, textToFirstTv.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);

         TextView tv_test2=(TextView) findViewById(R.id.tv_link2);
         String dynamicUrl="https://android-tools.ru/help/chetyre-sposoba-dobavit-ssylku-v-razmetku/";
         String linkedText=String.format(
                 "<a href=\"%s\">https://android-tools.ru/help/chetyre-sposoba-dobavit-ssylku-v-razmetku/</a> ", dynamicUrl);
         tv_test2.setText(Html.fromHtml(linkedText));
         tv_test2.setMovementMethod(LinkMovementMethod.getInstance());
         TextView tv_text3=(TextView) findViewById(R.id.tv_link3);
         tv_text3.setText("https://www.materialpalette.com/");
        Linkify.addLinks(tv_text3,Linkify.ALL);
    }

    public  void blogView(View view){
        Uri address=Uri.parse("https://www.materialpalette.com/");
        Intent openlink=new Intent(Intent.ACTION_VIEW,address);
        startActivity(openlink);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//       int id=item.getItemId();
//       if(id==R.id.action_settings) {
//           return true;
//       }
//       return  super.onOptionsItemSelected(item);
//    }
}
