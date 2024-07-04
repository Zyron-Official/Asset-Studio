package com.zyron.assetstudio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.zyron.assetstudio.R;

public class ImageIconFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imageicon, container, false);

        ConstraintLayout rootLayout = view.findViewById(R.id.constrainRootImageUplaoder);
        MaterialCardView imageUploaderCard = rootLayout.findViewById(R.id.imageIconUploader);

        imageUploaderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        return view;
    }

    private void showBottomSheet() {
        ImageUploaderSheet bottomSheetFragment = new ImageUploaderSheet();
        bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
    }
}