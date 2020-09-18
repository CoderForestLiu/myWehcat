package domain;

public class Explore {
    private int arrow,img;//图标、箭头
    private String text;//文字

    public int getImg() {
        return img;
    }
    public String getText() {
        return text;
    }

    public int getArrow() {
        return arrow;
    }

    public Explore(int img, String text, int arrow){
        this.img=img;
        this.arrow=arrow;
        this.text=text;
    }
}
