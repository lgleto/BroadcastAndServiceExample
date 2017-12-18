package ipca.utility.broadcasttest;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 */
public class PlusTwoFragment extends Fragment {

    TextView textView;

    BroadcastReceiver bcTestReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text=intent.getStringExtra(PlusOneFragment.BRD_MESSAGE);
            textView.setText(text);
        }
    };

    public PlusTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_two, container, false);
        textView=(TextView)view.findViewById(R.id.textViewMessage);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(bcTestReceiver,
                new IntentFilter(PlusOneFragment.BROADCAST_MESSAGE_TEST));
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(bcTestReceiver);
    }
}
