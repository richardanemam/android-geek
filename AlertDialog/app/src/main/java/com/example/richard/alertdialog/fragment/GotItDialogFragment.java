package com.example.richard.alertdialog.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class GotItDialogFragment extends DialogFragment {

    public static GotItDialogFragment newInstance(){
        GotItDialogFragment gotIt = new GotItDialogFragment();
        return gotIt;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("I got this shit!")
                .setPositiveButton("Ok, I got it", null);


        return builder.create();
    }
}

