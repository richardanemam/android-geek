package com.example.alertlist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListDialog extends DialogFragment {

    public static ListDialog newInstance(ArrayList<String> list){
        ListDialog dialog = new ListDialog();
        Bundle args = new Bundle();
        args.putStringArrayList("EXTRA_LIST", list);
        dialog.setArguments(args);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_custom_alert_dialog, container, false);

        ListView listView = view.findViewById(R.id.lv_list);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        assert getArguments() != null;
        List<String> list = getArguments().getStringArrayList("EXTRA_LIST");

        assert list != null;
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);
        builder.create();

        return view;
    }
}
