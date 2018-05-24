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
        if(!name.getString("mainName").equals(""))
            san.setMainName(name.getString("mainName"));
        else
            san.setMainName("*Unknown*");

        if(!details.getString("placeOfOrigin").equals(""))
            san.setPlaceOfOrigin(details.getString("placeOfOrigin"));
        else
            san.setPlaceOfOrigin("*Unknown*");

        if(!details.getString("description").equals(""))
            san.setDescription(details.getString("description"));
        else
            san.setDescription("*Unknown*");
        if(!details.getString("image").equals(""))
            san.setImage(details.getString("image"));
        else
            san.setImage("https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg");

        ArrayList<String> nicknamesList = new ArrayList<>();
        ArrayList<String> ingredientsList = new ArrayList<>();
        JSONArray nicknamesArray = name.getJSONArray("alsoKnownAs");
        JSONArray ingredientsArray = details.getJSONArray("ingredients");
        for(int i =0; i< nicknamesArray.length(); i++){
            nicknamesList.add(nicknamesArray.getString(i));
        }
        for(int i=0; i<ingredientsArray.length(); i++){
            ingredientsList.add(ingredientsArray.getString(i));
        }
        san.setAlsoKnownAs(nicknamesList);
        san.setIngredients(ingredientsList);

        return san;
    }
}
