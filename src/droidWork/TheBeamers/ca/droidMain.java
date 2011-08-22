package droidWork.TheBeamers.ca;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class droidMain extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, TakeTwo.class);
        spec = tabHost.newTabSpec("takeTwo").setIndicator("TakeTwo",
                          res.getDrawable(R.drawable.ic_tab_take_two))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, TicTacToe.class);
        spec = tabHost.newTabSpec("ticTacToe").setIndicator("TicTacToe",
                          res.getDrawable(R.drawable.ic_tab_ttt))
                      .setContent(intent);
        tabHost.addTab(spec);
    
        tabHost.setCurrentTab(1);
    }
}