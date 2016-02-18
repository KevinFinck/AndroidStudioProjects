package com.finckinc.uitest;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
    implements View.OnClickListener
{
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        MyOnClickListener Listener = new MyOnClickListener();

        button.setOnClickListener(Listener);
        button.setOnClickListener(this);
        /*
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Implement event handling
                    }
                });
*/

        EditText email = (EditText) findViewById(R.id.editText);
        email.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v,
                                                  int actionId,
                                                  KeyEvent event) {
                        EditText email=(EditText) v;
                        ShowYesNo("Testing", "Like, any buttons??");
                        alert("Hi there");
                        TextView tv=(TextView) findViewById(R.id.textView);
                        if(actionId== EditorInfo.IME_ACTION_SEND){
                            tv.setText(email.getText());
                        }
                        return true;
                    }
                });
    }

    private Context getActivity()
    {
        return null; //(Context)R.layout.activity_main;
    }
    public void alert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("What's Up?")
                .setMessage(message);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void ShowYesNo(String title, String message) {
        DialogFragment dialog = new YesNoDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        dialog.setArguments(args);
        //dialog.setTargetFragment(this, 0);
        dialog.show(getFragmentManager(), "tag");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();

        int value = Integer.parseInt(bText);
        total += value;

        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Integer.toString(total));

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(txt.getText() + ".");
    }
}
