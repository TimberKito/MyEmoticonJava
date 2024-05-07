package com.rinbows.soft.myemoticonjava.tools;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.rinbows.soft.myemoticonjava.App;
import com.rinbows.soft.myemoticonjava.data.Identifier;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import kotlin.io.TextStreamsKt;

public class DataTools {
    public static List<Identifier> parseJsonFile(InputStream jsonInputStream) {
        InputStreamReader reader = new InputStreamReader(jsonInputStream);
        String jsonString = TextStreamsKt.readText(reader);
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
        List<Identifier> IdentifierList = new ArrayList<>();
        for (JsonElement jsonObject : jsonArray) {
            Identifier Identifier = gson.fromJson(jsonObject.toString(), Identifier.class);
            IdentifierList.add(Identifier);
        }
        return IdentifierList;
    }
}
