/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an arrayList of words from one until ten

        ArrayList<String> words = new ArrayList<>();
        words.add(0, "one");
        words.add(1, "two");
        words.add(2, "three");
        words.add(3, "four");
        words.add(4, "five");
        words.add(5, "six");
        words.add(6, "seven");
        words.add(7, "eight");
        words.add(8, "nine");
        words.add(9, "ten");

        // Find the external layout that contains the column of words

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.rootView);

        // variable for count the numbers of cicles and the right position
        // of the elements of ArrayList


        int index = 0;

        // loop until the last position

        while (index < words.size()) {

            // create a texView at each cicle

            TextView wordView = new TextView(this);

            // set the text with that one stored at position referred by index
            wordView.setText(words.get(index));


            //add another child textView
            if (rootLayout != null) {
                rootLayout.addView(wordView);
            }

            // update position

            index++;
        }
    }


}

