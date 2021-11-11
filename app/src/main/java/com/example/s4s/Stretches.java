package com.example.s4s;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Stretches")
public class Stretches extends ParseObject {
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_TITLE = "title";

    public String getDescription(){ return getString(KEY_DESCRIPTION ); }
    public void setDescription(String description){ put(KEY_DESCRIPTION, description); }

    public ParseFile getImage(){ return getParseFile(KEY_IMAGE); }
    public void setImage(ParseFile parsefile){ put(KEY_IMAGE, parsefile); }

    public String getTitle(){ return getString(KEY_TITLE); }
    public void setTitle (String title){ put(KEY_TITLE, title); }


}
