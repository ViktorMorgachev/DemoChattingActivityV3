package viktor.demo.ru.demochattingactivity.fragments;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import viktor.demo.ru.demochattingactivity.R;
import viktor.demo.ru.demochattingactivity.activity.AnimalActivity;
import viktor.demo.ru.demochattingactivity.interfaces.AnimalListener;

/**
 * Created by Developer on 12.04.2018.
 */

public class FragmentCat extends Fragment implements View.OnClickListener{

    private TextView textViewDescriprion;
    private ImageView imageView;
    private AnimalListener animalListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_animal_fragment_layout, container, false);

        textViewDescriprion = (TextView) view.findViewById(R.id.text_animal);
        imageView = (ImageView) view.findViewById(R.id.image_animal);
        imageView.setOnClickListener(this);

        textViewDescriprion.setText(R.string.cat_description);

        imageView.setImageBitmap(getBitmapFromAssets("cat.png"));

        return  view;

    }

    // Custom method to get assets folder image as bitmap
    private Bitmap getBitmapFromAssets(String fileName){

        AssetManager am = getContext().getAssets();
        InputStream is = null;
        try{
            is = am.open(fileName);
        }catch(IOException e){
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AnimalActivity) {
            animalListener = (AnimalActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " context must implement OwnerListener");
        }

    }

    @Override
    public void onClick(View v) {
        animalListener.showCatOwner();
    }
}
