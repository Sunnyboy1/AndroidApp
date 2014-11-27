package com.example.swiperefreshlayout;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends Activity implements OnRefreshListener {
	private SwipeRefreshLayout mSwipeLayout;
	private ListView mListView;
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.listview);
		mListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getData()));

		mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
		mSwipeLayout.setOnRefreshListener(this);
		mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
	}

	private ArrayList<String> getData() {
		list.add("Hello");
		list.add("This is stormzhang");
		list.add("An Android Developer");
		list.add("Love Open Source");
		list.add("My GitHub: stormzhang");
		list.add("weibo: googdev");
		return list;
	}

	@Override
	public void onRefresh() {
		Toast.makeText(getApplicationContext(), "刷新", Toast.LENGTH_SHORT)
				.show();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				mSwipeLayout.setRefreshing(false);
			}
		}, 5000);
	}
}
