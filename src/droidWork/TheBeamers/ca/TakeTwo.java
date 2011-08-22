package droidWork.TheBeamers.ca;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TakeTwo extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.taketwo);

            Button btnTransfer = (Button)findViewById(R.id.btnTransfer);       
            btnTransfer.setOnClickListener(this);

            Button btnAppend = (Button)findViewById(R.id.btnAppend);       
            btnAppend.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // do something when the button is clicked
                    EditText edtSource = (EditText)findViewById(R.id.edtSource);
                    EditText edtDestination = (EditText)findViewById(R.id.edtDestination);
                    
                    edtDestination.append(edtSource.getText());
                  }} ); 

            EditText edtSource = (EditText)findViewById(R.id.edtSource);
            edtSource.setText("Isn't this interesting?");
            
        }
        
        public void onClick(View v) {
            // do something when the button is clicked
            EditText edtSource = (EditText)findViewById(R.id.edtSource);
            EditText edtDestination = (EditText)findViewById(R.id.edtDestination);
            
            edtDestination.setText(edtSource.getText());    
          }  

}