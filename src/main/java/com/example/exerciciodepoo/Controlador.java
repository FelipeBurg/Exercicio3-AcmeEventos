package com.example.exerciciodepoo;
import Aplicacao.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable {

    @FXML
    private Label   labelCadEvento;
    @FXML
    private TextField textFieldLong;
    @FXML
    private TextField textFieldLat;
    @FXML
    private TextField textFieldData;
    @FXML
    private ChoiceBox<String> choiceBoxEventos;
    private String[] evento = {"Ciclone","Terremoto", "Seca"};
    @FXML
    private Label labelConfirma;
    @FXML
    private TextField textFieldVelocidade;
    @FXML
    private TextField textFieldMagnitude;
    @FXML
    private TextField textFieldSeca;
    @FXML
    private TextField textFieldPrecipitacao;
    @FXML
    private Label labelMagnitude;
    @FXML
    private Label labelVelocidade;
    @FXML
    private Label labelSeca;
    @FXML
    private Label labelPrecipitacao;
    @FXML
    private Label labelCodigo;
    @FXML
    private TextField textFieldCodigo;
    @FXML
    private TextArea textAreaDados;
    AcmeEventos acmeEventos = new AcmeEventos();
    private Main main;

    public void fecharApp(){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxEventos.getItems().addAll(evento);
        choiceBoxEventos.setOnAction(event -> choiceBoxChange()); // Chama o método quando a escolha inicial muda
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public void getEvento(ActionEvent event){
        String myEvento = choiceBoxEventos.getValue();
    }
    public void choiceBoxChange() {
        String selectedEvent = choiceBoxEventos.getValue();
        limparCampos();
        if ("Ciclone".equals(selectedEvent)) {
            textFieldVelocidade.setVisible(true);
            labelVelocidade.setVisible(true);
            textFieldPrecipitacao.setVisible(true);
            labelPrecipitacao.setVisible(true);
        } else if ("Terremoto".equals(selectedEvent)) {
            textFieldMagnitude.setVisible(true);
            labelMagnitude.setVisible(true);
            textFieldPrecipitacao.setVisible(false);
            labelPrecipitacao.setVisible(false);
        } else if ("Seca".equals(selectedEvent)) {
            textFieldSeca.setVisible(true);
            labelSeca.setVisible(true);
            textFieldPrecipitacao.setVisible(false);
            labelPrecipitacao.setVisible(false);
        }
    }
    @FXML
    private void buttonClickAction() {
        try {
            String mensagem = "";
            String codigo = textFieldCodigo.getText();
            String data = textFieldData.getText();
            double longitude = Double.parseDouble(textFieldLong.getText());
            double latitude = Double.parseDouble(textFieldLat.getText());
            String selectedEvent = choiceBoxEventos.getValue();
            if (selectedEvent.equals("Terremoto")){
                double magnitude = Double.parseDouble(textFieldMagnitude.getText());
                mensagem = acmeEventos.cadT(codigo,data,longitude,latitude,magnitude);
                exibirMensagem(mensagem);
            }
            else if(selectedEvent.equals("Ciclone")){
                double velocidade = Double.parseDouble(textFieldVelocidade.getText());
                double precipitacao = Double.parseDouble(textFieldPrecipitacao.getText());
                mensagem = acmeEventos.cadC(codigo,data,longitude,latitude,velocidade,precipitacao);
                exibirMensagem(mensagem);
            }
            else if (selectedEvent.equals("Seca")) {
                int seca = Integer.parseInt(textFieldSeca.getText());
                mensagem = acmeEventos.cadS(codigo,data,longitude,latitude,seca);
                exibirMensagem(mensagem);
            }
        } catch (NumberFormatException e) {
            exibirMensagem("Erro de formato numérico: Por favor, insira valores numéricos válidos.");
        } catch (NullPointerException e) {
            exibirMensagem("Erro de referência nula: Certifique-se de preencher todos os campos obrigatórios.");
        } catch (IllegalArgumentException e) {
            exibirMensagem("Erro de argumento inválido: O evento selecionado não é válido."); // tem nem como, mas coloquei
        } catch (Exception e) {
            exibirMensagem("Erro desconhecido: " + e.getMessage());
        }
    }
    private void limparCampos() {
        textFieldMagnitude.setVisible(false);
        labelMagnitude.setVisible(false);
        textFieldVelocidade.setVisible(false);
        labelVelocidade.setVisible(false);
        textFieldSeca.setVisible(false);
        labelSeca.setVisible(false);
    }
    public void limparDados(){
        textFieldMagnitude.setText(null);
        textFieldVelocidade.setText(null);
        textFieldData.setText(null);
        textFieldLat.setText(null);
        textFieldLong.setText(null);
        textFieldSeca.setText(null);
        textFieldPrecipitacao.setText(null);
        textFieldCodigo.setText(null);
        textAreaDados.setText(null);
        labelCadEvento.setVisible(false);
    }
    public void exibirMensagem(String mensagem){
        labelConfirma.setVisible(true);
        labelConfirma.setText(mensagem);
    }
    public void mostrarDados() {
        String eventosStr = acmeEventos.mostrarEventos();
        textAreaDados.setVisible(true);
        textAreaDados.setText(eventosStr);
        labelCadEvento.setVisible(true);
    }

}