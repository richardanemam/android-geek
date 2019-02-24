package com.example.richard.alertdialog.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.richard.alertdialog.R;

public class GotItDialogFragment extends DialogFragment {

    public static GotItDialogFragment newInstance(){
        GotItDialogFragment gotIt = new GotItDialogFragment();
        Bundle bundle = new Bundle();
        gotIt.setArguments(bundle);
        return gotIt;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.alert_dialog_layout, null));
        return builder.create();
    }
}

