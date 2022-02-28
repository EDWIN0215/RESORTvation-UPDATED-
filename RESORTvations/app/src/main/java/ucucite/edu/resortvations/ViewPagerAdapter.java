package ucucite.edu.resortvations;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.listland,R.drawable.goldlandpic,R.drawable.springlandpic,R.drawable.urdanetagardenpic,R.drawable.aljenpic};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        //Onclick listener to view the data on view pager
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0){
//                    exitonlick();
                    //add Builder.. Are you sure you want to choose Lisland Resort ? YES/NO
                      Intent intent=new Intent(context,firstResort.class);
                      context.startActivity(intent);
                      Toast.makeText(context, "Welcome to Listland Reinforest Resort!", Toast.LENGTH_SHORT).show();

                }else if(position == 1){
                    Intent intent=new Intent(context,secondresort.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "Welcome to Goldland Resort!", Toast.LENGTH_SHORT).show();


                }else if(position == 2){
                    Intent intent=new Intent(context,thirdresort.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "Welcome to Springland Resort!", Toast.LENGTH_SHORT).show();


                }else if(position == 3){
                    Intent intent=new Intent(context,fourthresort.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "Welcome to Urdaneta Garden Resort!", Toast.LENGTH_SHORT).show();


                }else {
                    Intent intent=new Intent(context,fifthresort.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "Welcome to Al-Jen's Resort!", Toast.LENGTH_SHORT).show();

                }
            }

//            private void exitonlick() {
//                new AlertDialog.Builder(context)
//                        .setTitle("Lisland Resort!")
//                        .setMessage("Are you sure you want to Choose Listland Reinforest Resort ?")
//                        .setIcon(R.drawable.resortvationlogo)
//                        .setPositiveButton("YES",
//                                new DialogInterface.OnClickListener() {
//                                    @TargetApi(11)
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        Intent intent=new Intent(context,firstResort.class);
//                                        context.startActivity(intent);
//                                        Toast.makeText(context, "Welcome to Listland Reinforest Resort!", Toast.LENGTH_SHORT).show();
//                                    }
//                                })
//                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                            @TargetApi(11)
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        }).show();
//            }


        });


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
