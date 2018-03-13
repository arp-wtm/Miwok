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
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an arrayList of words from one until ten

        ArrayList<String> words = new ArrayList<>();
        words.add(0,"one");
        words.add(1, "two");
        words.add(2, "three");
        words.add(3, "four");
        words.add(4, "five");
        words.add(5, "six");
        words.add(6, "seven");
        words.add(7, "eight");
        words.add(8, "nine");
        words.add(9, "ten");

        // print out each element of the words array to the Android logs
        // use log.v with emulator, log.i with physical device

        Log.i("NumbersActivity", "word at index 0:" + words.get(0));
        Log.i("NumbersActivity", "word at index 1:" + words.get(1));
        Log.i("NumbersActivity", "word at index 2:" + words.get(2));
        Log.i("NumbersActivity", "word at index 3:" + words.get(3));
        Log.i("NumbersActivity", "word at index 4:" + words.get(4));
        Log.i("NumbersActivity", "word at index 5:" + words.get(5));
        Log.i("NumbersActivity", "word at index 6:" + words.get(6));
        Log.i("NumbersActivity", "word at index 7:" + words.get(7));
        Log.i("NumbersActivity", "word at index 8:" + words.get(8));
        Log.i("NumbersActivity", "word at index 9:" + words.get(9));


    }


}

