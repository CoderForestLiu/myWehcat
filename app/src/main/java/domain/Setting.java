package domain;

import java.io.Serializable;

public class Setting implements Serializable {
    private int arrow;
    private String text;

    public Setting( String text,int arrow) {
        this.arrow = arrow;

        this.text = text;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }


    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }



}
