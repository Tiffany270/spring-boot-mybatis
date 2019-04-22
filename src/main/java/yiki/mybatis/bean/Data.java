package yiki.mybatis.bean;

public class Data {

    private int t;
    private String b;

    @Override
    public String toString() {
        return "Data{" +
         "t=" + t +
         ", b='" + b + '\'' +
         '}';
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getT() {

        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
}
