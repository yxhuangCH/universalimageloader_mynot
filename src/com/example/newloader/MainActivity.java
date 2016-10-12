package com.example.newloader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainActivity extends Activity {
	private static final String TAG = "yxh";
	
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) findViewById(R.id.imageView);
		
		doImageLoader();
	}

	private void doImageLoader(){
		// ImageLoaderConfiguration 使用了 Build 模式
		ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
		// ImageLoader 使用单例模式
		ImageLoader.getInstance().init(configuration);
		
		String url  = "http://img14.poco.cn/mypoco/myphoto/20130131/22/17323571520130131221457027_640.jpg";
		ImageLoader.getInstance().loadImage(url, new ImageLoadingListener() {
			
			@Override
			public void onLoadingStarted(String imageUri, View view) {
				Log.i(TAG, "onLoadingStarted");
			}
			
			@Override
			public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
				Log.i(TAG, "onLoadingFailed");
			}
			
			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
				Log.i(TAG, "onLoadingComplete");
			}
			
			@Override
			public void onLoadingCancelled(String imageUri, View view) {
				Log.i(TAG, "onLoadingCancelled");
			}
		});
		
		ImageLoader.getInstance().displayImage(url, imageView);
	}

}
