package com.bilal.game;

public class HistoryModel {
   private String yourAnswer;
   private String rightAnswer;


   public HistoryModel(String yourAnswer, String rightAnswer) {
      this.yourAnswer = yourAnswer;
      this.rightAnswer = rightAnswer;
   }

   public String getYourAnswer() {
      return yourAnswer;
   }

   public String getRightAnswer() {
      return rightAnswer;
   }

   public void setYourAnswer(String yourAnswer) {
      this.yourAnswer = yourAnswer;
   }

   public void setRightAnswer(String rightAnswer) {
      this.rightAnswer = rightAnswer;
   }

}
