package com.example.fragmentnews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsFragmentContent extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String title, String content) {
        View vis = view.findViewById(R.id.invisible);
        vis.setVisibility(View.VISIBLE);
        TextView newsTitle = view.findViewById(R.id.news_title);
        TextView newsContent = view.findViewById(R.id.news_content);
        newsTitle.setText(title);
        newsContent.setText(content);
    }
}
