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

    @Override
    public String toString() {
        return String.format("Figure { (%.2f,%.2f)-(%.2f,%.2f) color= [%.2f,%.2f,%.2f] }",
                x1,y1,x2,y2,r,g,b);
    }
}
