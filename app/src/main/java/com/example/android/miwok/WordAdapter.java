package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Antonella on 19/03/18.
 * <p>
 * Copyright (C) 2017 The Android Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
             private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of Words objects to display in a list
     */
    WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        /*
        Here, we initialize the WordAdapter's internal storage for the context and the list.
        the second argument is used when the ArrayAdapter is populating a single TextView.
        Because this is a custom adapter for two TextViews the adapter is not
        going to use this second argument, so it can be any value. Here, we used 0.
        */
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        /* Check if the existing view is being reused, otherwise inflate the view */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /* Get the {@link Word} object located at this position in the list */
        Word currentWord = getItem(position);

        /* Find the TextView in the list_item.xml layout with the ID first_line */
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.first_line);

        /*
        Get the version name from the current AndroidFlavor object and
        set this text on the name TextView
        */
        if (currentWord != null) {
            miwokTextView.setText(currentWord.getMiwokTranslation());
        }

        /* Find the TextView in the list_item.xml layout with the ID second_line */
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.second_line);
        /*
        Get the default translation from the current word object and
        set this text on the number TextView
        */
        if (currentWord != null) {
            defaultTextView.setText(currentWord.getDefaultTranslation());
        }


        /* Find the ImageView in the list_item.xml layout with the  */
        ImageView imageView =  (ImageView) listItemView.findViewById(R.id.list_item_icon);
        /*
        Get the resource id of image from the current word object and
        set this id to the ImageView
        */
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
            View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        /*
        Return the whole list item layout (containing 2 TextViews )
        so that it can be shown in the ListView
        */
        return listItemView;
    }
}
