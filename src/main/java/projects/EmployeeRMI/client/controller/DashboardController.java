package projects.EmployeeRMI.client.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projects.EmployeeRMI.client.model.Employee;
import projects.EmployeeRMI.client.services.EmployeeService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private TableColumn<Employee, String> employeeAddressColumn;

    @FXML
    private TableColumn<Employee, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Employee, String> employeeNameColumn;

    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TextField idInputField;

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private EmployeeService employeeService = new EmployeeService();

    public void initialize() {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        employeeNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        employeeAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());

        // Make the name and address columns editable
        employeeNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        employeeNameColumn.setOnEditCommit(this::onNameEditCommit);

        employeeAddressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        employeeAddressColumn.setOnEditCommit(this::onAddressEditCommit);

        employeeTableView.setItems(employeeList);

    }

    private void onNameEditCommit(TableColumn.CellEditEvent<Employee, String> event) {
        Employee editedEmployee = event.getRowValue();
        editedEmployee.setName(event.getNewValue());
        employeeService.updateEmployee(editedEmployee);
    }

    private void onAddressEditCommit(TableColumn.CellEditEvent<Employee, String> event) {
        Employee editedEmployee = event.getRowValue();
        editedEmployee.setAddress(event.getNewValue());
    }


    @FXML
    void addNewEmployee(ActionEvent event) {
        // Create a Dialog
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Enter Employee Details");

        // Set the header text
        dialog.setHeaderText(null);

        // Create Labels and TextFields for ID, Name, and Address
        Label idLabel = new Label("ID:");
        TextField idTextField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();

        Label addressLabel = new Label("Address:");
        TextField addressTextField = new TextField();

        // Create a GridPane for the input fields
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add the components to the GridPane
        gridPane.add(idLabel, 0, 0);
        gridPane.add(idTextField, 1, 0);

        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameTextField, 1, 1);

        gridPane.add(addressLabel, 0, 2);
        gridPane.add(addressTextField, 1, 2);

        // Set the GridPane as the content of the Dialog
        dialog.getDialogPane().setContent(gridPane);

        // Add buttons to the dialog
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);

        // Show the dialog and wait for the user's response
        dialog.showAndWait().ifPresent(result -> {
            if (result.equals(okButton)) {
                // User clicked OK, handle the entered values
                //Must add verification here
                int id = Integer.parseInt(idTextField.getText());
                String name = nameTextField.getText();
                String address = addressTextField.getText();

                // Handle the values as needed
                employeeService.addEmployee(new Employee(id, name, address));
                System.out.println("Employee details Successfully sent to ServiceLayer");


            }
        });
    }

    @FXML
    void deleteSelectedEmployee(ActionEvent event) {
        Employee selectedEmployee = employeeTableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employeeService.deleteEmployee(selectedEmployee);
            employeeTableView.getItems().remove(selectedEmployee);
        }
    }

    @FXML
    void searchById(ActionEvent event) {
        if (!idInputField.getText().isEmpty()) {
            int employeeId = Integer.parseInt(idInputField.getText());
            Employee employee = employeeService.getEmployeeById(employeeId);

            if (employee != null) {
                // Replace all table data with the selected employee
                employeeList.setAll(employee);
            } else {
                // Employee not found, show a modal alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Employee Not Found");
                alert.setHeaderText(null);
                alert.setContentText("The employee with the specified details was not found.");

                // Customize the alert dialog pane
                alert.getDialogPane().setPrefWidth(300);
                Label label = new Label("Employee Not Found");
                label.setStyle("-fx-font-weight: bold;");
                alert.getDialogPane().setHeader(label);

                // Add OK button
                alert.getButtonTypes().setAll(ButtonType.OK);

                // Show the alert and wait for the user to acknowledge
                alert.showAndWait();
            }
        }
    }

    @FXML
    void selectAllEmployees(ActionEvent event) {
        // Call the service to get all employees
        employeeList.setAll(employeeService.getAllEmployees());


    }

    @FXML
    void updateSelectedEmployee(ActionEvent event) {
        Employee selectedEmployee = employeeTableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            // Make the selected row editable
            employeeTableView.setEditable(true);
            // Start the edit on the selected row
            employeeTableView.edit(employeeTableView.getSelectionModel().getSelectedIndex(), employeeNameColumn);
            // Disable the update button
            // You may want to enable it again when the user finishes editing or cancels the edit
            // For simplicity, let's disable it for now
            employeeTableView.getColumns().forEach(column -> column.setSortable(false));
        }
    }


}





