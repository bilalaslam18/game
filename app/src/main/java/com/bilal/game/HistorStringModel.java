package com.bilal.game;

public class HistorStringModel {

  private String yours,rigths;
  private int count;


    public HistorStringModel(String yours, String rigths, int count) {
        this.yours = yours;
        this.rigths = rigths;
        this.count = count;
    }

    public String getYours() {
        return yours;
    }

    public String getRigths() {
        return rigths;
    }

    public int getCount() {
        return count;
    }

    public void setYours(String yours) {
        this.yours = yours;
    }

    public void setRigths(String rigths) {
        this.rigths = rigths;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
