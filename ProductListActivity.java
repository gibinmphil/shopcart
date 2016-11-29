package com.meluha.monlashsolutions.meluha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {


    String offerprice,fullprice;
    ListView list;
    List<ProductModel> productslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
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
        productslist = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            ProductModel productModel = new ProductModel();
            productModel.setProduct_id(""+i);
            productModel.setProduct_name("Product "+i);
            productModel.setProduct_description("Product Description"+i);
            productModel.setProduct_fullprice("520 "+i);
            productModel.setProduct_offerprice("500 "+i);


            if(i%2 == 0) {

                productModel.setProduct_image("http://cutewallpaper.org/wp-content/uploads/2015/12/Desktop-Cute-Wallpapers-HD-1920x1080-3.jpg");
            }
            else
            {
                productModel.setProduct_image("http://cutewallpaper.org/wp-content/uploads/2015/12/Desktop-Cute-Wallpapers-HD-1920x1080-2.jpg");
            }
            productslist.add(productModel);
        }


        list = (ListView) findViewById(R.id.lv1);
        list.setAdapter(new ProductListAdapter(this,productslist));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProductModel productModel = productslist.get(i);
                Toast.makeText(getApplicationContext()," You Selected "+productModel.getProduct_name(),Toast.LENGTH_LONG).show();
                Intent productdetailedview = new Intent(ProductListActivity.this,SingleProductViewActivity.class);
                //productdetailedview.putExtra("product_name", productModel);
                startActivity(productdetailedview);

            }
        });
    }

}
