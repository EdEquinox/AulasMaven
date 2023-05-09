package pt.isec.pa.exerc29.model.data;

import pt.isec.pa.exerc29.model.ModelLog;

public class Figure {
    private double x1,y1;
    private double x2,y2;
    private double r,g,b; //values 0..1
    private boolean fill;

    public Figure() {
        x1 =  50; y1 =  20;
        x2 = 250; y2 = 150;
        r = 0;
        g = 0.75;
        b = 0.25;
        fill = false;
        ModelLog.getInstance().add("new "+toString());
    }

    public void defineColor() {
        r = Math.random();
        g = Math.random();
        b = Math.random();
    }

    public void defineColor(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setP1(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public void setP2(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getR() {
        return r;
    }

    public double getG() {
        return g;
    }

    public double getB() {
        return b;
    }

    public boolean isFill() {
        return fill;
    }

    public double getCX() {
        return (x1+x2)/2.0;
    }

    public double getCY() {
        return (y1+y2)/2.0;
    }

    @Override
    public String toString() {
        return String.format("Figure { (%.2f,%.2f)-(%.2f,%.2f) color= [%.2f,%.2f,%.2f] }",
                x1,y1,x2,y2,r,g,b);
    }
}
