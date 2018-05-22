package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        if(json == null)
            return null;
        Sandwich san = new Sandwich();
        JSONObject details = new JSONObject(json);
        JSONObject name = details.getJSONObject("name");
        san.setMainName(name.getString("mainMane"));
        san.setPlaceOfOrigin(details.getString("placeOfOrigin"));
        san.setDescription(details.getString("description"));
        san.setImage(details.getString("image"));

//        ArrayList<String> nicknamesList = new ArrayList<String>();
//        ArrayList<String> ingredientsList = new ArrayList<String>();
//        JSONArray nicknamesArray = name.getJSONArray("alsoKnownAs");
//        JSONArray ingredientsArray = name.getJSONArray("ingredients");
//        for(int i =0; i< nicknamesArray.length(); i++){
//            nicknamesList.add(nicknamesArray.getString(i));
//        }
//        for(int i=0; i<ingredientsArray.length(); i++){
//            ingredientsList.add(ingredientsArray.getString(i));
//        }
//        san.setAlsoKnownAs(nicknamesList);
//        san.setIngredients(ingredientsList);

        return san;
    }
}
