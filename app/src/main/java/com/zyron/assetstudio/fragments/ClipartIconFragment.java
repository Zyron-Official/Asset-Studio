package com.zyron.assetstudio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AlertDialogLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.zyron.assetstudio.R;

public class ClipartIconFragment extends Fragment {

    private ImageButton iconFilter;
    private String[] itemList = {"Material Symbols(new)", "Material Icons"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cliparticon, container, false);
        
        iconFilter = view.findViewById(R.id.iconFilter);
        iconFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showItemListDialog(v);
            }
        });

        return view;
    }

    private void showItemListDialog(View view) {
        
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        builder.setItems(itemList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedItem = itemList[which];
                Snackbar snackbar = Snackbar.make(view, selectedItem, Snackbar.LENGTH_LONG);
                snackbar.setAction("Done", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackbar.show();
            }
        });
        builder.show();
    } 
}