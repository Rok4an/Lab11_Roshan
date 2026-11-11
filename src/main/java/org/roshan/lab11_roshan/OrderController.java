package org.roshan.lab11_roshan;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderController {

    @FXML private ListView<String> entreeListView;
    @FXML private ToggleGroup drinkGroup;
    @FXML private CheckBox waterCheckBox;
    @FXML private TextField specialField;
    @FXML private Label currentOrderLabel;

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
    }

    @FXML
    private void handleClearOrder() {
    }

    @FXML
    private void handleExit() {
    }

    @FXML
    private void handleClearEntree() {
    }

    @FXML
    private void handleClearDrink() {
    }

    @FXML
    private void handleClearSpecial() {
    }

    @FXML
    private void handleAbout() {
    }

}