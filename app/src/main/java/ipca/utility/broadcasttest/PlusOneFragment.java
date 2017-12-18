package ipca.utility.broadcasttest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 */
public class PlusOneFragment extends Fragment {

    public static final String BROADCAST_MESSAGE_TEST = "ipca.utility.broadcasttest.message";
    public static final String BRD_MESSAGE = "message";

    Button buttonSend;

    int counter = 0;

    public PlusOneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);

        buttonSend=(Button)view.findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                broadcastMessage();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void broadcastMessage(){
        Intent intent=new Intent(BROADCAST_MESSAGE_TEST);
        intent.putExtra(BRD_MESSAGE,"Button clicked "+counter+" times!");
        getContext().sendBroadcast(intent);
    }


}
