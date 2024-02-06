package com.example.kemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Controller {

    public TableView<NumberFacts> Numbertriva;
    public TableColumn<NumberFacts, String> NumberColumn;
    public TableColumn<NumberFacts, String> DataColumn;
    public TextField InputNumber;
    public Button Randombutton;
    @FXML
    public void initialize() throws Exception {
        NumberColumn.setCellValueFactory(new PropertyValueFactory<NumberFacts, String>("text"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<NumberFacts, String>("number"));
    }

    public void getRandomFact() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://numbersapi.p.rapidapi.com/random/trivia?fragment=true&notfound=floor&json=true"))
            .header("X-RapidAPI-Key", "f4b1225234msha1e4d434db92f7dp127cdajsn53f5cc803a02")
            .header("X-RapidAPI-Host", "numbersapi.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        NumberFacts fact = objectMapper.readValue(response.body(), NumberFacts.class);
        Numbertriva.getItems().add(fact);}
}