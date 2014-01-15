package com.example.lineproject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;


@SuppressLint("NewApi")
public class QuantityDialogFragment extends DialogFragment implements OnClickListener {

    private EditText editQuantity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        editQuantity = new EditText(getActivity());
        editQuantity.setInputType(InputType.TYPE_CLASS_TEXT);

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.app_name).setMessage("Please Enter Comment")
                .setPositiveButton("OK", this).setNegativeButton("CANCEL", null).setView(editQuantity).create();

    }

    @Override
    public void onClick(DialogInterface dialog, int position) {

        String value = editQuantity.getText().toString();
        //Log.d("Quantity: ", value);
        MainActivity callingActivity = (MainActivity) getActivity();
        callingActivity.addtheLayouts(value);
        dialog.dismiss();
    }
	

}