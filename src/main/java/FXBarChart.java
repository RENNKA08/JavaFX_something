import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXBarChart implements Initializable {

    @FXML
    PieChart pieChart;

    Title title1;

    Data data1;
    Data data2;
    Data data3;
    Data data4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title1 = new Title();
        data1 = new Data();
        data2 = new Data();
        data3 = new Data();
        data4 = new Data();
    }

    public void setTitle1(String title){
        title1.setTitle(title);
    }

    public void setData1(String name, int value){
        data1.setName(name);
        data1.setValue(value);
    }

    public void setData2(String name, int value){
        data2.setName(name);
        data2.setValue(value);
    }

    public void setData3(String name, int value){
        data3.setName(name);
        data3.setValue(value);
    }

    public void setData4(String name, int value){
        data4.setName(name);
        data4.setValue(value);
    }

    public void showPie(){
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                new PieChart.Data(data1.getName(), data1.getValue()),
                new PieChart.Data(data2.getName(), data2.getValue()),
                new PieChart.Data(data3.getName(), data3.getValue()),
                new PieChart.Data(data4.getName(), data4.getValue())
        );
        pieChart.setData(pieChartData);
        pieChart.setTitle(title1.getTitle());
    }

}
