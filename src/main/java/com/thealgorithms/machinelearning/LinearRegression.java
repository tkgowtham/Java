package com.thealgorithms.machinelearning;

import java.util.ArrayList;

/**
* Author : Gowtham Kamalasekar
* LinkedIn : https://www.linkedin.com/in/gowtham-kamalasekar/
*
* Linear Regression Machine Learning Algorithm is a regression algorithm.
* This programs used for computing y = mx + c
* Where m is slope and c is intercept
* We can use this too predict for a given x.
*/

class LinearRegression {
    private ArrayList<Double> dependentX = new ArrayList<Double>();
    private ArrayList<Double> independentY = new ArrayList<Double>();
    private double m;
    private double c;

    /**
    * @param : X (dependent variable), Y (independent variable) as ArrayList
    */
    public LinearRegression(ArrayList<Double> dependentX, ArrayList<Double> independentY) {
        this.dependentX = dependentX;
        this.independentY = independentY;
        this.Equate();
    }

    private double Sumation(ArrayList<Double> arr){
        double sum = 0.0;

        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }

        return sum;
    }

    private ArrayList<Double> MultiplyNumber(ArrayList<Double> arr1, ArrayList<Double> arr2) {
        ArrayList<Double> temp = new ArrayList<Double>();
        for(int i = 0; i < arr1.size(); i++) {
            temp.add((arr1.get(i) * arr2.get(i)));
        }
        return temp;
    }

    private void Equate(){
        int n = dependentX.size();
        this.m = (n * Sumation(MultiplyNumber(independentY, dependentX)) - (Sumation(dependentX) * Sumation(independentY)));
        this.m = this.m / (n * (Sumation(MultiplyNumber(dependentX, dependentX))) - (Sumation(dependentX) * Sumation(dependentX)));

        this.c = (Sumation(independentY) * Sumation(MultiplyNumber(dependentX, dependentX)) - (Sumation(dependentX) * Sumation(MultiplyNumber(independentY, dependentX))));
        this.c = this.c / (n * (Sumation(MultiplyNumber(dependentX, dependentX))) - (Sumation(dependentX) * Sumation(dependentX)));
    }

    public double getM(){
        return this.m;
    }

    public double getC(){
        return this.c;
    }

    public double PredictForX(double x) {
        return (this.m * x) + this.c;
    }
}