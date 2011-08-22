package droidWork.TheBeamers.ca;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TicTacToe extends Activity {
	TicTacToeController mController = new TicTacToeController();
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);
        
        // get the button
        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {       	
        	public void onClick(View v) {
                //get the TextView for Status updates 
                TextView txtStatus = (TextView) findViewById(R.id.txtStatus);

                mController.resetGame();
                txtStatus.setText("Game Reset");

                GridView gridview = (GridView) findViewById(R.id.gridview);
                for (int i=0; i < 9; i++) {
                	ImageView iv;
                	
                	iv = (ImageView)gridview.getChildAt(i);
                	iv.setImageResource(R.drawable.sample_5);
                	//iv.setImageResource(R.drawable.cat_pictures2);
                }
        	}        	
        });
        
        // Get the gridview on this screen
        GridView gridview = (GridView) findViewById(R.id.gridview);
        
        // Hook up our ImageAdapter subclass.  This will look like an empty TicTacToe board 
        gridview.setAdapter(new ImageAdapter(this));

        // We need a state machine for whose turn it is, to handle their selections, and to 
        // identify the winner or stale mate as appropriate.
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Bulk of the work gets handled here.
            	int row, col;
            	
            	//get the TextView for Status updates 
                TextView txtStatus = (TextView) findViewById(R.id.txtStatus);
            	
            	// Resolve the position into Row/Col and hand to the Controller
            	switch (position) {
            		case 0:
            		case 1:
            		case 2:
            			row = 0;
            		    col = position;
            		    break;
            		case 3:
            		case 4:
            		case 5:            				
            			row = 1;
            		    col = position -3;
            		    break;
            		case 6:
            		case 7:
            		case 8:
            			row = 2;
            		    col = position -6;
            		    break;  
            		default:
            			row=-1;
            			col=-1;
            	}

            	if (mController.takeTurn(row, col)) {
            		if (mController.getCurrentPlayer() == 1) {
            			((ImageView) v).setImageResource(R.drawable.sample_0);
            			//((ImageView) v).setImageResource(R.drawable.cat_picture1);
            			//((ImageView) v).setImageResource(parent. mThumbIDs[1]);
            		} else {
              		  //((ImageView) v).setImageResource(R.drawable.sample_6);            			
            			((ImageView) v).setImageResource(R.drawable.cat_picture1);
            		}

            		if (mController.isGameOver()) {
            			txtStatus.setText("You win!");
                        //Toast.makeText(TicTacToe.this, "You Win!", Toast.LENGTH_SHORT).show();
            		} else {
            			txtStatus.setText("Turn successful.");
            			//Toast.makeText(TicTacToe.this, "Turn successful", Toast.LENGTH_SHORT).show();
            		}
            	} else {
            		txtStatus.setText("Invalid Position.  Try again");
                    //Toast.makeText(TicTacToe.this, "Invalid Position.  Try again", Toast.LENGTH_SHORT).show();
            	}          	
            }
        }
        );
        
    }
    // references to our images
    /*
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };*/
    
}
