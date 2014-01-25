package com.androidbegin.absviewpagertutorial;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;



public class MainActivity extends SherlockFragmentActivity {

	// Declare Variables
	ActionBar mActionBar;
	ViewPager mPager;
	Tab tab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml

		setContentView(R.layout.activity_main);
		
	
		
		// Activate Navigation Mode Tabs
		mActionBar = getSupportActionBar();
		getSupportActionBar().hide();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


		// Locate ViewPager in activity_main.xml
		mPager = (ViewPager) findViewById(R.id.pager);
		
		// Activate Fragment Manager
		FragmentManager fm = getSupportFragmentManager();

		// Capture ViewPager page swipes
		ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				// Find the ViewPager Position
				mActionBar.setSelectedNavigationItem(position);
			}
		};

		mPager.setOnPageChangeListener(ViewPagerListener);
		// Locate the adapter class called ViewPagerAdapter.java
		ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(fm);
		// Set the View Pager Adapter into ViewPager
		mPager.setAdapter(viewpageradapter);
		
		// Capture tab button clicks
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// Pass the position on tab click to ViewPager
				mPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}
		};

		// Create first Tab
		tab = mActionBar.newTab().setText("Tab1").setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		// Create second Tab
		tab = mActionBar.newTab().setText("Tab2").setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		// Create third Tab
		tab = mActionBar.newTab().setText("Tab3").setTabListener(tabListener);
		mActionBar.addTab(tab);

	}
	
	   /** Called when the user clicks the email button */
    public void email(View view) {
    	  Intent intent = new Intent(Intent.ACTION_MAIN);
          intent.setComponent(new ComponentName("com.d4a.eMailTime","com.fsck.k9.activity.Accounts"));
          intent.putExtra("grace", "Hi");
          startActivity(intent);
        
    } 
    
    /** Called when the user clicks the play button */
    public void play(View view) {
    	Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://play.google.com/store/apps"));
        startActivity(intent);
        
    } 
    

    
    /** Called when the user clicks the web button */
    public void web(View view) {
    	String url = "http://www.google.com";
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(browserIntent);
	
    }	
    
	


}
