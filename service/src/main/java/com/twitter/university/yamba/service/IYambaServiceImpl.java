package com.twitter.university.yamba.service;

import android.util.Log;

import com.twitter.university.yamba.api.IYambaService;
import com.twitter.university.yamba.api.TweetRequest;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IYambaServiceImpl extends IYambaService.Stub {
    private static final String TAG = IYambaServiceImpl.class.getSimpleName();
    private final YambaClient yambaClient;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public IYambaServiceImpl(YambaClient yambaClient) {
        this.yambaClient = yambaClient;
    }

    @Override
    public void post(final TweetRequest tweetRequest) {
        Runnable run = new Runnable() {
            public void run() {
                Log.d(TAG, "Posting " + tweetRequest);
                try {
                    IYambaServiceImpl.this.yambaClient.postStatus(tweetRequest.getBody(), tweetRequest.getLatitude(), tweetRequest.getLongitude());
                } catch (YambaClientException e) {
                    Log.e(TAG, "Failed to post " + tweetRequest, e);
                }
            }
        };
        this.executorService.submit(run);
    }
}
