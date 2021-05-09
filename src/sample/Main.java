package sample;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
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
    private Text messageText;

    @Override
    public void start(Stage myStage) throws Exception{
        myStage.setTitle("Loan Calculator");
        GridPane rootNode = new GridPane();
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 400, 325);
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
        messageText = new Text("");
        calcBtn.setOnAction(new ButtonHandler());
        monthlyTextArea.setOnMouseClicked(e -> {
            messageText.setText("This text field will display\nthe calculation's result.");
        });
        totalTextArea.setOnMouseClicked(e -> {
            messageText.setText("This text field will display\nthe calculation's result.");
        });

        monthlyTextArea.setEditable(false);
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
        rootNode.add(messageText, 1, 6);
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

//        public String amountStr = "";
//        public String interestRateStr = "";
//        public String numYearsStr = "";

        public void handle(ActionEvent e) {

            try {
//                amountStr = amountTextArea.getText();
//                interestRateStr = interestRateTextArea.getText();
//                numYearsStr = numYearsTextArea.getText();

                amountDbl = Double.parseDouble(amountTextArea.getText());
                interestRateDbl = Double.parseDouble(interestRateTextArea.getText());
                numYearsDbl = Double.parseDouble(numYearsTextArea.getText());

                monthlyInterestRateDbl = (interestRateDbl/100)/12;
                monthlyDbl = ((monthlyInterestRateDbl * amountDbl)/(1-(Math.pow((1+monthlyInterestRateDbl), (numYearsDbl * -12)))));
                totalDbl = monthlyDbl * (numYearsDbl * 12);
                monthlyDblRound = Math.round(monthlyDbl * 100.0) / 100.0;
                totalDblRound = Math.round(totalDbl * 100.0) / 100.0;
                monthlyTextArea.setText("$ " + String.valueOf(monthlyDblRound));
                totalTextArea.setText("$ " + String.valueOf(totalDblRound));
                messageText.setText("Here are the monthly payment\nand total payment amounts.");
            } catch (NumberFormatException err) {
                messageText.setText("Incomplete or incorrect data.\nPlease fill out the fields\nfor the interest rate,\nnumber of years and\nloan amount then try again.");
            }

        }
    }
}
