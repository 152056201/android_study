package com.example.fragmentnews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPan;

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<News> mNewsList;

        public NewsAdapter(List<News> newsList) {
            mNewsList = newsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(viewHolder.getAdapterPosition());
                    if (isTwoPan) {
                        NewsFragmentContent content = (NewsFragmentContent) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        content.refresh(news.getTitle(), news.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            News news = mNewsList.get(i);
            viewHolder.newsTitle.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitle;

            public ViewHolder(View view) {
                super(view);
                newsTitle = view.findViewById(R.id.news_title);
            }
        }
    }
    private List<News> getNews() {
        List<News> news = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            News news1 = new News();
            news1.setTitle("This is news " + i);
            news1.setContent(getRandoContent("This is news content") + i);
            news.add(news1);
        }
        return news;
    }
    private String getRandoContent(String content){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<length;i++){
            stringBuilder.append(content);
        }
        return stringBuilder.toString();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newsTitle = view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitle.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPan = true;
        } else {
            isTwoPan = false;
        }
    }
}
