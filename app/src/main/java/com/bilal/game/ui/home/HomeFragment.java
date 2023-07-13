package com.bilal.game.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bilal.game.DBHelper;
import com.bilal.game.Helper;
import com.bilal.game.HistoryModel;
import com.bilal.game.R;
import com.bilal.game.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    TextView message_text,letter_text;
    Button root_btn,grass_btn,sky_btn,play_pause;
    int play_or_pause;
    int cn=0;
    DBHelper dbHelper;

    // RESOURCES.......
    char[] skyLetters = {'b', 'd', 'f', 'h', 'k', 'l', 't'};
    char[] grassLetters = {'g', 'j', 'p', 'q', 'y'};
    char[] rootLetters = {'a', 'c', 'e', 'i', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'w', 'x', 'z'};
    String answerString = "";

    ArrayList<HistoryModel>historyModels=new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        */
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstance){
        super.onViewCreated(view,savedInstance);

        root_btn=view.findViewById(R.id.root);
        play_pause=view.findViewById(R.id.play);
        grass_btn=view.findViewById(R.id.grass);
        sky_btn=view.findViewById(R.id.sky);
        message_text=view.findViewById(R.id.home_top);
        letter_text=view.findViewById(R.id.letter);

        dbHelper=new DBHelper(view.getContext());
        cn=0;



        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View insideView) {
                try {
                    if (play_or_pause == 1) {
                        play_or_pause = 0;
                        message_text.setText("Game finished");
                        Helper helper=new Helper();
                        String []ans=helper.converter(historyModels);


                        dbHelper.AddHistory(ans[0],ans[1],cn);
                        play_pause.setText("Start");

                    } else {
                        message_text.setText("Let's play");

                        // Wait for 5 seconds and create a new question
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                letter_text.setText(getRandomLetter());
                                message_text.setText("");
                                play_or_pause = 1;
                                play_pause.setText("Finish");
                            }
                        }, 2000); // 5000 milliseconds = 5 seconds


                    }
                }catch (Exception ex){
                    message_text.setText(ex.getMessage());
                }
            }
        });
        root_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View inside_view) {
                if (play_or_pause == 1) {

                    if (answerString == "Root Letter") {
                        message_text.setText("Correct answer");
                        cn++;
                    } else {
                        message_text.setText("Wrong! the answer is " + answerString);
                    }

                    historyModels.add(new HistoryModel("Root Letter",answerString));
                    // Wait for 5 seconds and create a new question
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            letter_text.setText(getRandomLetter());
                            message_text.setText("");
                        }
                    }, 2000); // 5000 milliseconds = 5 seconds

                }else{
                    message_text.setText("First start the game");
                }
            }
        });

        sky_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play_or_pause == 1) {

                    if (answerString == "Sky Letter") {
                        message_text.setText("Correct answer");
                        cn++;
                    } else {
                        message_text.setText("Wrong! the answer is " + answerString);
                    }

                    historyModels.add(new HistoryModel("Sky Letter",answerString));
                    // Wait for 5 seconds and create a new question
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            letter_text.setText(getRandomLetter());
                            message_text.setText("");
                        }
                    }, 2000); // 5000 milliseconds = 5 seconds

                }else{
                    message_text.setText("First start the game");
                }
            }
        });

        grass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play_or_pause == 1) {

                    if (answerString == "Grass Letter") {
                        message_text.setText("Correct answer");
                        cn++;
                    } else {
                        message_text.setText("Wrong! the answer is " + answerString);
                    }

                    historyModels.add(new HistoryModel("Grass Letter",answerString));
                    // Wait for 5 seconds and create a new question
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            letter_text.setText(getRandomLetter());
                            message_text.setText("");
                        }
                    }, 2000); // 5000 milliseconds = 5 seconds

                }else{
                    message_text.setText("First start the game");
                }
            }
        });

    }

    // RANDOM ANSWER STRING GENERATOR.......
    String getRandomLetter() {
        Random random = new Random();
        int category = random.nextInt(3);
        char letter;
        switch (category) {
            case 0:
                letter = skyLetters[random.nextInt(skyLetters.length)];
                answerString = "Sky Letter";
                break;
            case 1:
                letter = grassLetters[random.nextInt(grassLetters.length)];
                answerString = "Grass Letter";
                break;
            default:
                letter = rootLetters[random.nextInt(rootLetters.length)];
                answerString = "Root Letter";
                break;
        }
        return String.valueOf(letter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}