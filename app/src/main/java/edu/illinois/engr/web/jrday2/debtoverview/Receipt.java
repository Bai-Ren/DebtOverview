package edu.illinois.engr.web.jrday2.debtoverview;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Brian on 2/20/2016.
 */
public class Receipt extends Fragment
{
    Button button;
    View rootview;
    ImageView imageView;
    static final int CAM_REQUEST = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.receipt, container, false);
        button = (Button) getActivity().findViewById(R.id.angry_btn);
        imageView = (ImageView) getActivity().findViewById(R.id.image_view);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);
            }
        });
        return rootview;
    }

    private File getFile()
    {
        File folder = new File("sdcard/camera_app");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");

        return image_file;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}
