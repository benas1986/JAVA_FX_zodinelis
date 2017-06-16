package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    @FXML
    private TextField inputEng;

    @FXML
    private TextField inputLt;

    @FXML
    private TextArea output;

    private Map<String, List<String>> engMap = new HashMap<>();
    private Map<String, List<String>> ltMap = new HashMap<>();

    public void versti(ActionEvent event){
        if (engMap.isEmpty() || ltMap.isEmpty()){
            ReadFile readFile = new ReadFile(engMap, ltMap);
            readFile.read();
        }

        String word = inputEng.getText();
        //String inp2 = inputLt.getText();

        List<String> words = engMap.get(word);

        if(words == null){
            words = ltMap.get(word);
        }

        printResult(words);
    }

    private void printResult(List<String> words){
        if (words != null && !words.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(String w: words){
                sb.append(w).append("\n");
            }
            output.setText(sb.toString());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Tokio zodzio nera!!!");
            alert.show();
        }
    }
}

