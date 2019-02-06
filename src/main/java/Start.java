import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Start implements Initializable {

    Stage stage;
    @FXML private TextField title;
    @FXML private TextField text1;
    @FXML private TextField text2;
    @FXML private TextField text3;
    @FXML private TextField text4;
    @FXML private TextField num1;
    @FXML private TextField num2;
    @FXML private TextField num3;
    @FXML private TextField num4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title.setPromptText("題を入力してください");
        text1.setPromptText("1つ目の名前");
        text2.setPromptText("2つ目の名前");
        text3.setPromptText("3つ目の名前");
        text4.setPromptText("4つ目の名前");
        num1.setPromptText("1つ目の値");
        num2.setPromptText("2つ目の値");
        num3.setPromptText("3つ目の値");
        num4.setPromptText("4つ目の値");
    }

    @FXML
    public void showFXBarChart() throws IOException {

        Task task1 = new Task(num1.getText());
        int resultText1 = task1.getResultText();

        Task task2 = new Task(num2.getText());
        int resultText2 = task2.getResultText();

        Task task3 = new Task(num3.getText());
        int resultText3 = task3.getResultText();

        Task task4 = new Task(num4.getText());
        int resultText4 = task4.getResultText();

        Stage newStage = new Stage();

        newStage.initModality(Modality.APPLICATION_MODAL);

        newStage.initOwner(stage);

        Parent root;

        if((resultText1 != -1) && (resultText2 != -1)&& (resultText3 != -1)&& (resultText4 != -1 )) {

            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("something.fxml"));
            root = fxmlLoader.load();

            FXBarChart fxBarChart = fxmlLoader.getController();

            //System.out.println(text1.getText());

            fxBarChart.setTitle1(title.getText());
            fxBarChart.setData1(text1.getText(), resultText1);
            fxBarChart.setData2(text2.getText(), resultText2);
            fxBarChart.setData3(text3.getText(), resultText3);
            fxBarChart.setData4(text4.getText(), resultText4);
            fxBarChart.showPie();

        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("reWrite.fxml"));
            root =fxmlLoader.load();
        }

        newStage.setScene(new Scene(root));

        newStage.show();
    }

    public void setStage(Stage stage) { this.stage = stage; }
}