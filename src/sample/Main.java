package sample;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

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

        totalTextArea.setEditable(false);
        rootNode.add(interestRateLabel, 0,0);
        rootNode.add(interestRateTextArea, 1,0);
        rootNode.add(numYearsLabel, 0,1);
        rootNode.add(numYearsTextArea, 1,1);
        rootNode.add(amountLabel, 0,2);
        rootNode.add(amountTextArea, 1,2);
//        rootNode.add(amountLabel, 0,3);
//        rootNode.add(amountTextArea, 1,3);
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
}
