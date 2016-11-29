package com.meluha.monlashsolutions.meluha;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SingleProductViewActivity extends AppCompatActivity {


    ImageView productimage;
    RadioGroup buytype;
    RadioButton online,onsd,onusb;
    TextView productname,product_price,product_description_link,product_description,product_fullprize;
    Button addtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

                /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        Intent fromlist = getIntent();
        ProductModel productModel = (ProductModel) fromlist.getSerializableExtra("product");




        productimage = (ImageView)findViewById(R.id.imageView);

        productname =(TextView) findViewById(R.id.textView);
        /*productname.setText(productModel.getProduct_name());*/

        product_price = (TextView) findViewById(R.id.textView2);
       /* product_price.setText(productModel.getProduct_offerprice());*/

        product_fullprize = (TextView) findViewById(R.id.fullprice);
        product_fullprize.setPaintFlags(product_fullprize.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
       /* product_fullprize.setText(productModel.getProduct_fullprice());*/

        product_description = (TextView) findViewById(R.id.textView4);

        product_description_link = (TextView) findViewById(R.id.textView3);
        product_description_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  product_description.setText(productModel.getProduct_description());*/
            }
        });

        buytype = (RadioGroup) findViewById(R.id.buytype);
        online = (RadioButton) findViewById(R.id.online);
        onsd = (RadioButton) findViewById(R.id.onsd);
        onusb = (RadioButton) findViewById(R.id.onusb);
        buytype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.online)
                {
                    Toast.makeText(getApplicationContext(),"You selected online buy option",Toast.LENGTH_LONG).show();
                }
                else if(i == R.id.onsd)
                {
                    Toast.makeText(getApplicationContext(),"You selected Offline with SD Card buy option",Toast.LENGTH_LONG).show();
                }
                else if(i == R.id.onusb)
                {
                    Toast.makeText(getApplicationContext(),"You selected Offline with USB buy option",Toast.LENGTH_LONG).show();
                }

            }
        });
        addtocart = (Button) findViewById(R.id.button2);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Order Placed Successfully",Toast.LENGTH_LONG).show();

            }
        });









    }

}
