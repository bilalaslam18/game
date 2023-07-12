package com.bilal.game;

import java.util.ArrayList;

public class Helper {

    public String[] converter(ArrayList<HistoryModel>historyModels){
        String rights="";
        String yours="";

        for (int i=0;i<historyModels.size();i++){
            rights=rights+"-"+historyModels.get(i).getRightAnswer();
            yours=yours+"-"+historyModels.get(i).getYourAnswer();
        }

        String[]ans={rights,yours};

        return ans;
    }
}
