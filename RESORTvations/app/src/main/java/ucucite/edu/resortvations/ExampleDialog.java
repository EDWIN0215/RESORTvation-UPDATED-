package ucucite.edu.resortvations;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class ExampleDialog extends DialogFragment {
    LayoutInflater inflater;
    TextView r_resort1, r_fullname, r_resort2,r_resort3,r_resort4,r_resort5, r_date,r_gcashnumber;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("Please Check Carefully before confirming!")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Thank you for Reservation!", Toast.LENGTH_SHORT).show();
                        String g_res1 = r_resort1.getText().toString();
                        String g_res2 = r_resort2.getText().toString();
                        String g_res3 = r_resort3.getText().toString();
                        String g_res4 = r_resort4.getText().toString();
                        String g_res5 = r_resort5.getText().toString();
                        String str2 = r_fullname.getText().toString();
                        String g_date = r_date.getText().toString();
                        String g_gcashnumber = r_gcashnumber.getText().toString();

                        Intent intent = new Intent(getContext(), confirm.class);
                        intent.putExtra("message1", g_res1);
                        intent.putExtra("message2", g_res2);
                        intent.putExtra("message3", g_res3);
                        intent.putExtra("message4", g_res4);
                        intent.putExtra("message5", g_res5);
                        intent.putExtra("message6", str2);
                        intent.putExtra("message7", g_date);
                        intent.putExtra("message8", g_gcashnumber);

                        startActivity(intent);
                    }

                });

        r_resort1 = view.findViewById(R.id.edit_resort1);
        r_resort2 = view.findViewById(R.id.edit_resort2);
        r_resort3 = view.findViewById(R.id.edit_resort3);
        r_resort4 = view.findViewById(R.id.edit_resort4);
        r_resort5 = view.findViewById(R.id.edit_resort5);
        r_fullname = view.findViewById(R.id.edit_fullname);
        r_date = view.findViewById(R.id.edit_date);
        r_gcashnumber = view.findViewById(R.id.edit_gcashnumber);



        Bundle args = getArguments();
        String resort1 = args.getString("message1");
        String resort2 = args.getString("message2");
        String resort3 = args.getString("message3");
        String resort4 = args.getString("message4");
        String resort5 = args.getString("message5");
        String fullname = args.getString("message6");
        String date = args.getString("message7");
        String gcashnum = args.getString("message8");

        r_resort1.setText(resort1);
        r_resort2.setText(resort2);
        r_resort3.setText(resort3);
        r_resort4.setText(resort4);
        r_resort5.setText(resort5);
        r_fullname.setText(fullname);
        r_date.setText(date);
        r_gcashnumber.setText(gcashnum);


        builder.setView(view);
        AlertDialog dialog=builder.create();

        return dialog;

    }

}
