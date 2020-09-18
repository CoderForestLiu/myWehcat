package domain;

import java.io.Serializable;

public class Myself implements Serializable {
    private int arrow,img;
    private String text;

    public Myself(int img, String text,int arrow) {
        this.arrow = arrow;
        this.img = img;
        this.text = text;
    }
    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public int getImg() {
        return img;
    }



    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
