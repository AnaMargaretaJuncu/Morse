package com.morse.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.R;
import com.channels.androidsms.SmsChannel;
import com.channels.twitter.TwitterChannelLoginActivity;
import com.morse.App;
import com.morse.Channel;
import com.morse.ChannelsAdapter;
import com.morse.Constants;

import java.util.ArrayList;
import java.util.List;


public class SelectChannelActivity extends AppCompatActivity {
    App mApp;
    ListView mListView;
    List<Channel> mChannelList;
    ChannelsAdapter mAdapter;
    private Button mButton;

    private void createAdapter() {
        List<String> titles = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        List<Integer> images = new ArrayList<>();
        for (Channel channel : mChannelList) {
            titles.add(channel.getName());
            descriptions.add(channel.getDescription());
            images.add(channel.getImage());
        }
        mAdapter = new ChannelsAdapter(SelectChannelActivity.this, titles, descriptions, images);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = new App(this);
        setContentView(R.layout.activity_select_channel);
        mListView = findViewById(R.id.listView);
        mChannelList = new ArrayList<>();
        mChannelList.addAll(mApp.getChannels());

        createAdapter();
        mAdapter.notifyDataSetChanged();

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(
                (parent, view, position, id) -> startActivity(mChannelList.get(position).getIntent())
        );

        //tried to get the value from the SelectChannel button
        //update : we receive the value from the SelectChannel but can't print the button on our AddChannel page
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //in final_value we store what we receive back from SelectChannel
            int final_value = extras.getInt("Channel");
            System.out.println(final_value);
//            final_title[contor] = mTitle[final_value];
//            final_description[contor] = mDescription[final_value];
//            final_images[contor] = images[final_value];
//            contor++;
//
//            listView = findViewById(R.id.listView);
//            MyAdapter adapter = new MyAdapter(this, final_title, final_description, final_images);
//            listView.setAdapter(adapter);

            //The key argument here must match that used in the other activity
        }

        //this button will redirect you to the SelectChannel Page
        mButton = findViewById(R.id.addchannelbtn);
        mButton.setOnClickListener(v -> openAddChannel());
    }

    public void openAddChannel() {
        Intent intent = new Intent(this, AddChannelActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                int code = data.getIntExtra(Constants.CHANNEL_TYPE, -1);
                if (code == Constants.CHANNEL_ANDROID_SMS) {
                    mChannelList.add(new SmsChannel(SelectChannelActivity.this));
                    mAdapter.add(mChannelList.get(mChannelList.size() - 1));
                    mAdapter.notifyDataSetChanged();
                    mApp.insertIntoChannels("sms");
                } else if (code == Constants.CHANNEL_REDDIT) {
                    /* Here should be reddit, but we're adding Twitter and say it's Reddit */
                    mChannelList.add(new TwitterChannelLoginActivity(SelectChannelActivity.this));
                    mAdapter.add(mChannelList.get(mChannelList.size() - 1));
                    mAdapter.notifyDataSetChanged();
                    mApp.insertIntoChannels("reddit");
                } else if (code == Constants.CHANNEL_TWITTER) {
                    mChannelList.add(new TwitterChannelLoginActivity(this));
                    mAdapter.add(mChannelList.get(mChannelList.size() - 1));
                    mAdapter.notifyDataSetChanged();
                    mApp.insertIntoChannels("twitter");
                }
            }
        }
    }
}