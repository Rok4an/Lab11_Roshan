package org.roshan.lab11_roshan;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrderController {

    @FXML
    private ListView<String> entreeListView;
    @FXML
    private ToggleGroup drinkGroup;
    @FXML
    private CheckBox waterCheckBox;
    @FXML
    private TextField specialField;
    @FXML
    private Label currentOrderLabel;

    private final Order order = new Order();

    @FXML
    public void initialize() {
        entreeListView.setItems(FXCollections.observableArrayList(order.getEntreeNames()));

        entreeListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    order.setEntree(newVal);
                    updateDisplay();
                });

        drinkGroup.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null) {
                order.setDrink(null);
            } else {
                order.setDrink(((RadioButton) newVal).getText());
            }
            updateDisplay();
        });

        waterCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            order.setWater(newVal);
            updateDisplay();
        });

        specialField.textProperty().addListener((obs, oldVal, newVal) -> {
            order.setSpecialRequests(newVal);
            updateDisplay();
        });

        updateDisplay();
    }

    private void updateDisplay() {
        String entree = (order.getEntree() == null) ? "-" : order.getEntree();
        String drink = (order.getDrink() == null) ? "-" : order.getDrink();
        currentOrderLabel.setText(
                "Current Order: " + entree + " / " + drink + "\n"
                        + String.format("Total: $%.2f", order.getTotal()));
    }

    @FXML
    private void handlePlaceOrder() {
        if (!order.isComplete()) {
            String missing;
            if (order.getEntree() == null && order.getDrink() == null) {
                missing = "an entrée and a drink";
            } else if (order.getEntree() == null) {
                missing = "an entrée";
            } else {
                missing = "a drink";
            }
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Order");
            alert.setHeaderText(null);
            alert.setContentText("Please select " + missing + " before placing your order.");
            alert.showAndWait();
            return;
        }
        showOrderSummary();
    }

    @FXML
    private void handleClearOrder() {
        entreeListView.getSelectionModel().clearSelection();
        drinkGroup.selectToggle(null);
        specialField.clear();
        waterCheckBox.setSelected(false);
        order.clearAll();
        updateDisplay();
    }

    @FXML
    private void handleExit() {
        javafx.application.Platform.exit();
    }

    @FXML
    private void handleClearEntree() {
        entreeListView.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleClearDrink() {
        drinkGroup.selectToggle(null);
    }

    @FXML
    private void handleClearSpecial() {
        specialField.clear();
    }

    @FXML
    private void handleAbout() {
    }

}