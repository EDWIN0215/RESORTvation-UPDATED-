package ucucite.edu.resortvations.ui.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ucucite.edu.resortvations.Payments;
import ucucite.edu.resortvations.R;

public class ReservationFragment extends Fragment {

    private ReservationViewModel galleryViewModel;


    Button mbutton;
    Button mbutton1;
    Button mbutton2;
    Button mbutton3;
    Button mbutton4;

    Button mConfirmbtn;
    Button mbackbtn;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = new ViewModelProvider(this).get(ReservationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reservation, container, false);

        mbutton = root.findViewById(R.id.buttoncolor);
        mbutton1 = root.findViewById(R.id.buttoncolor1);
        mbutton2 = root.findViewById(R.id.buttoncolor2);
        mbutton3 = root.findViewById(R.id.buttoncolor3);
        mbutton4 = root.findViewById(R.id.buttoncolor4);

//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
////                textView.setText(s);
//            }
//        });

//        mbackbtn = root.findViewById(R.id.backbtn);
//
//        mbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                startActivity(new Intent(getApplicationContext(),Page3.class));
//            }
//        });

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton.isSelected()==true){
                    mbutton.setSelected(false);
                    Toast.makeText(getContext(), "DeSelect Listland Resort", Toast.LENGTH_SHORT).show();
                }else if(mbutton.isSelected()==false){
                    mbutton.setSelected(true);
                    mbutton1.setSelected(false);
                    mbutton2.setSelected(false);
                    mbutton3.setSelected(false);
                    mbutton4.setSelected(false);
                    Toast.makeText(getContext(), "Listland Resort Selected", Toast.LENGTH_SHORT).show();


                }
            }


        });
        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton1.isSelected()==true){
                    mbutton1.setSelected(false);
                    Toast.makeText(getContext(), "DeSelect GoldLand Resort", Toast.LENGTH_SHORT).show();

                }else if(mbutton1.isSelected()==false){
                    mbutton1.setSelected(true);
                    mbutton.setSelected(false);
                    mbutton2.setSelected(false);
                    mbutton3.setSelected(false);
                    mbutton4.setSelected(false);
                    Toast.makeText(getContext(), "GoldLand Resort Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton2.isSelected()==true){
                    mbutton2.setSelected(false);
                    Toast.makeText(getContext(), "DeSelect Springland Resort", Toast.LENGTH_SHORT).show();
                }else if(mbutton2.isSelected()==false){
                    mbutton2.setSelected(true);
                    mbutton.setSelected(false);
                    mbutton1.setSelected(false);
                    mbutton3.setSelected(false);
                    mbutton4.setSelected(false);
                    Toast.makeText(getContext(), "Springland Resort Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton3.isSelected()==true){
                    mbutton3.setSelected(false);
                    Toast.makeText(getContext(), "DeSelect Urdaneta Garden Resort", Toast.LENGTH_SHORT).show();
                }else if(mbutton3.isSelected()==false){
                    mbutton3.setSelected(true);
                    mbutton.setSelected(false);
                    mbutton1.setSelected(false);
                    mbutton2.setSelected(false);
                    mbutton4.setSelected(false);
                    Toast.makeText(getContext(), "Urdaneta Garden Resort Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbutton4.isSelected()==true){
                    mbutton4.setSelected(false);
                    Toast.makeText(getContext(), "DeSelect Al-Jen's Resort", Toast.LENGTH_SHORT).show();
                }else if(mbutton4.isSelected()==false){
                    mbutton4.setSelected(true);
                    mbutton.setSelected(false);
                    mbutton1.setSelected(false);
                    mbutton2.setSelected(false);
                    mbutton3.setSelected(false);
                    Toast.makeText(getContext(), "Al-Jen's Resort Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });





        mConfirmbtn = root.findViewById(R.id.confirmbtn);

        mConfirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mbutton.isSelected()){
                    Intent intent = new Intent(getContext(), Payments.class);
                    String str1 = mbutton.getText().toString();
                    intent.putExtra("message1", str1);
                    startActivity(intent);

                }else if(mbutton1.isSelected()){
                    Intent intent = new Intent(getContext(), Payments.class);
                    String str2 = mbutton1.getText().toString();
                    intent.putExtra("message2", str2);
                    startActivity(intent);

                }else if(mbutton2.isSelected()){
                    Intent intent = new Intent(getContext(), Payments.class);
                    String str3 = mbutton2.getText().toString();
                    intent.putExtra("message3", str3);
                    startActivity(intent);

                }else if(mbutton3.isSelected()){
                    Intent intent = new Intent(getContext(), Payments.class);
                    String str4 = mbutton3.getText().toString();
                    intent.putExtra("message4", str4);
                    startActivity(intent);

                } else if(mbutton4.isSelected()){
                    Intent intent = new Intent(getContext(), Payments.class);
                    String str5 = mbutton4.getText().toString();
                    intent.putExtra("message5", str5);
                    startActivity(intent);

                } else{
                    Toast.makeText(getContext(), "Please Select Resort to Proceed!", Toast.LENGTH_SHORT).show();

                }

            }
        });


        return root;
    }
}