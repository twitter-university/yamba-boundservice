package com.twitter.university.yamba.api;

import com.twitter.university.yamba.api.TweetRequest;

interface IYambaService {
    void post(in TweetRequest tweetRequest);
}
