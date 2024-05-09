package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class HelloController {
    @FXML
    private Label labelFail;
    @FXML
    private Label labelResult;
    @FXML
    private TextField TextA;
    @FXML
    private TextField TextB;
    @FXML
    private TextField TextC;
    @FXML
    private Label labelEquation;
    @FXML
    private void Discriminant(){
        try {
            if (!TextA.getText().isEmpty() && !TextC.getText().isEmpty() && !TextB.getText().isEmpty()) {
                double a = Double.parseDouble(TextA.getText());
                double b = Double.parseDouble(TextB.getText());
                double c = Double.parseDouble(TextC.getText());
                labelEquation.setText("Рівння : "+ a +"*x2 + " + b + "x + " + c + "=0");

                QuadraticEquationModel model = new QuadraticEquationModel(a,b,c);
                double discriminant = model.calculateDiscriminant();

                if (discriminant > 0) {
                    double X1 = model.calculateRoot1();
                    double X2 = model.calculateRoot2();
                    labelResult.setText("Корені рівняння: " + "\nX1 = " + X1 + ", \nX2 = " + X2 + "\nДискрімінат: " + discriminant );
                    labelFail.setText("");
                } else if (discriminant == 0) {
                    double X = model.calculateRoot();
                    labelResult.setText("Один корінь:" + "\nX =" + X + " \nДискрімінант: " + discriminant);
                    labelFail.setText("");
                } else {
                    labelResult.setText("Рівняння не має розв'язків у дійсних числах");
                    labelFail.setText("");
                }
            } else {
                labelFail.setText("Помилка: не всі поля заповнені");
            }
        }catch (IllegalStateException e){
            labelFail.setText(e.getMessage());
        }
        catch (NumberFormatException e) {
            labelFail.setText("Помилка: введено некоректні дані");
        } catch (ArithmeticException e) {
            labelFail.setText("Помилка: ділення на нуль");
        }
    }
}