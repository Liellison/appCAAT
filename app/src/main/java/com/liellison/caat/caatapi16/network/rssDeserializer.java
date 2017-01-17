package com.liellison.caat.caatapi16.network;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.liellison.caat.caatapi16.domain.rss;

import java.lang.reflect.Type;

/**
 * Created by liellison on 17/01/17.
 */

public class rssDeserializer implements JsonDeserializer{
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement user = json.getAsJsonObject();
        if (json.getAsJsonObject().get("rss") != null){
            user = json.getAsJsonObject().get("rss");
        }
        return (new Gson().fromJson( user, rss.class));
    }
}
