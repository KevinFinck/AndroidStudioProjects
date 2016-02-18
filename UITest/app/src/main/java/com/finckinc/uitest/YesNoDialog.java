package com.finckinc.uitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Kevin_2 on 8/6/2015.
 */
public class YesNoDialog extends DialogFragment
{
    public YesNoDialog()
    {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Bundle args = getArguments();
        String title = args.getString("title", "");
        String message = args.getString("message", "");

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, null);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_CANCELED, null);
                    }
                })
                .create();
    }
}

    /*
    Then call it using the following:

    DialogFragment dialog = new YesNoDialog();
    Bundle args = new Bundle();
    args.putString("title", title);
    args.putString("message", message);
    dialog.setArguments(args);
    dialog.setTargetFragment(this, YES_NO_CALL);
    dialog.show(getFragmentManager(), "tag");
    */

