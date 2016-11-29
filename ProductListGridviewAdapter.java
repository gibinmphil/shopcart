package com.meluha.monlashsolutions.meluha;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;

/**
 * Created by Monlash on 11/26/2016.
 */

public class ProductListGridviewAdapter extends BaseAdapter {

    Activity context;

    List<ProductModel> productlist;


    public ProductListGridviewAdapter(Activity context,List<ProductModel> products )
    {
        this.context = context;
        this.productlist = products;

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this.context)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();
        ImageLoader.getInstance().init(config);
    }

    @Override
    public int getCount() {
        return productlist.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher).build();

        LayoutInflater layoutinflater = context.getLayoutInflater();
        View vie = layoutinflater.inflate(R.layout.single_product_list_gridview,null);
        TextView product_name = (TextView) vie.findViewById(R.id.textView7);
        TextView product_price = (TextView) vie.findViewById(R.id.fullprice);
        TextView offer_price = (TextView) vie.findViewById(R.id.offerprice);
        ImageView product_image = (ImageView) vie.findViewById(R.id.imageView2);
        ProductModel productModel = productlist.get(i);
        product_name.setText(productModel.getProduct_name());
        product_price.setPaintFlags(product_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        product_price.setText(product_price.getText().toString()+productModel.getProduct_fullprice());
        offer_price.setText(offer_price.getText().toString()+productModel.getProduct_offerprice());

        imageLoader.displayImage(productModel.getProduct_image(), product_image, options);



        return vie;
    }


}
