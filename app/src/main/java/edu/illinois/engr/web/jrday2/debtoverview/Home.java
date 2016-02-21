package edu.illinois.engr.web.jrday2.debtoverview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Brian on 2/20/2016.
 */
public class Home extends Fragment
{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.home, container, false);
        String bibi = "WAZZUP";
        TextView textView = (TextView) rootview.findViewById(R.id.textViewName);
        textView.setText(bibi);
        return rootview;
    }
}
