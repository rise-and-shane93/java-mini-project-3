package sample;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import java.lang.*;

public class Main extends Application {

    private Label interestRateLabel;
    private Label numYearsLabel;
    private Label amountLabel;
    private Label monthlyLabel;
    private Label totalLabel;
    private TextField interestRateTextArea;
    private TextField numYearsTextArea;
    private TextField amountTextArea;
    private TextField monthlyTextArea;
    private TextField totalTextArea;
    private Button calcBtn;

    @Override
    public void start(Stage myStage) throws Exception{
        myStage.setTitle("Loan Calculator");
        GridPane rootNode = new GridPane();
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 400, 300);
        interestRateLabel = new Label("Annual Interest Rate:");
        numYearsLabel = new Label("Number of Years:");
        amountLabel = new Label("Loan Amount:");
        monthlyLabel = new Label("Monthly Payment:");
        totalLabel = new Label("Total Payment:");
        interestRateTextArea = new TextField();
        numYearsTextArea = new TextField();
        amountTextArea = new TextField();
        monthlyTextArea = new TextField();
        totalTextArea = new TextField();
        calcBtn = new Button("Calculate");
        calcBtn.setOnAction(new ButtonHandler());

        totalTextArea.setEditable(false);
        rootNode.add(interestRateLabel, 0,0);
        rootNode.add(interestRateTextArea, 1,0);
        rootNode.add(numYearsLabel, 0,1);
        rootNode.add(numYearsTextArea, 1,1);
        rootNode.add(amountLabel, 0,2);
        rootNode.add(amountTextArea, 1,2);
        rootNode.add(monthlyLabel, 0,3);
        rootNode.add(monthlyTextArea, 1,3);
        rootNode.add(totalLabel, 0,4);
        rootNode.add(totalTextArea, 1,4);
        rootNode.add(calcBtn, 1,5);
        myStage.setScene(myScene);
        myStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    class ButtonHandler implements EventHandler<ActionEvent> {
        public double amountDbl = 0;
        public double interestRateDbl = 0;
        public double numYearsDbl = 0;
        public double monthlyDbl = 0;
        public double totalDbl = 0;
        public double monthlyInterestRateDbl = 0;

        public double monthlyDblRound = 0;
        public double totalDblRound = 0;

        public String amountStr = "";
        public String interestRateStr = "";
        public String numYearsStr = "";
        public String monthlyStr = "";
        public String totalStr = "";

        public void handle(ActionEvent e) {
            amountStr = amountTextArea.getText();
            amountDbl = Double.parseDouble(amountStr);

            interestRateStr = interestRateTextArea.getText();
            interestRateDbl = Double.parseDouble(interestRateStr);

            numYearsStr = numYearsTextArea.getText();
            numYearsDbl = Double.parseDouble(numYearsStr);

            calcBtn.setText("Clicked");

            monthlyInterestRateDbl = (interestRateDbl/100)/12;
            monthlyDbl = ((monthlyInterestRateDbl * amountDbl)/(1-(Math.pow((1+monthlyInterestRateDbl), (numYearsDbl * -12)))));
            totalDbl = monthlyDbl * (numYearsDbl * 12);
            monthlyDblRound = Math.round(monthlyDbl * 100.0) / 100.0;
            totalDblRound = Math.round(totalDbl * 100.0) / 100.0;
//            testing = 1-(Math.pow((1+.00417), -24));
//            testing = (.05/12) * 2000;
            monthlyTextArea.setText(String.valueOf(monthlyDblRound));
            totalTextArea.setText(String.valueOf(totalDblRound));
        }
    }
}
