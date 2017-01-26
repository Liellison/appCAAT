package com.liellison.caat.caatapi16.api;

import com.liellison.caat.caatapi16.domain.rss;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by liellison on 17/01/17.
 */

public interface RssAPI {
    @GET("rss.asp")
    Call <rss.Channel> getRSS();
}
