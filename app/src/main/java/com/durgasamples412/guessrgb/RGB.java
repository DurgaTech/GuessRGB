package com.durgasamples412.guessrgb;

/**
 * Created by USER on 19-06-2018.
 */

public class RGB {

    double r,g,b;
    boolean isrowvisible;

    public boolean isIsrowvisible() {
        return isrowvisible;
    }

    public void setIsrowvisible(boolean isrowvisible) {
        this.isrowvisible = isrowvisible;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "RGB("+ r +"," + g + "," + b + ')';
    }
}
