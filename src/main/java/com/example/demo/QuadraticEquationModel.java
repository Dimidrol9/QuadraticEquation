package com.example.demo;

public class QuadraticEquationModel {
    private final double a;
    private final double b;
    private final double c;
    public QuadraticEquationModel(double a,double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double calculateDiscriminant(){
           return (b * b - 4 * a * c);
    }
    public double calculateRoot1(){
        double discriminant = calculateDiscriminant();
        if(a!=0 && discriminant>=0) {
            return (-b + Math.sqrt(calculateDiscriminant()) / (2 * a));
        }else {
            throw new IllegalStateException("Неможливо обчислити корінь 1: «a» не може дорівнювати нулю, а дискримінант має бути невід’ємним.");
        }
    }
    public double calculateRoot2(){
        double discriminant = calculateDiscriminant();
        if(a!=0 && discriminant>=0) {
            return (-b - Math.sqrt(calculateDiscriminant()) / (2 * a));
        }else
            throw new IllegalStateException("Неможливо обчислити корінь 2: «a» не може дорівнювати нулю, а дискримінант має бути невід’ємним.");
    }
    public double calculateRoot(){
        if(a!=0) {
            return (-b / (2 * a));
        }else {
            throw new IllegalStateException("Неможливо обчислити корінь: \"a\" не може дорівнювати нулю.");
        }

    }
}

