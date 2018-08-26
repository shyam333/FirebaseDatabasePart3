package apps.royallucky.com.firebasedemo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.txt1);

        mRootRef = new Firebase("https://fir-demo3-4bb96.firebaseio.com/");

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               // String value = dataSnapshot.getValue(String.class);

                String value;
                Map<String,String> map = (Map<String,String>)dataSnapshot.getValue();
                value  = map.get("key");

                textView.setText(value);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }
}
