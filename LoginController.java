package controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

public class LoginController {
    private VBox view;
    private TextField usernameField;
    private PasswordField passwordField;
    private ComboBox<String> roleCombo;
    private Label errorLabel;
    private Stage stage;

    public LoginController(Stage stage) {
        this.stage = stage;
        buildView();
    }

    private void buildView() {
        view = new VBox(10);
        view.setAlignment(Pos.CENTER);
        view.setPadding(new Insets(20));

        Label title = new Label("InnoVote Login");
        title.setStyle("-fx-font-size: 20px;");

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Participant", "Judge");
        roleCombo.getSelectionModel().selectFirst();

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> handleLogin());

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        view.getChildren().addAll(title, usernameField, passwordField, roleCombo, loginBtn, errorLabel);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleCombo.getValue();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Field tidak boleh kosong.");
            return;
        }

        EventUser user;
        if (role.equals("Participant")) {
            user = new Participant(username, password);
        } else {
            user = new Judge(username, password);
        }

        goToDashboard(user);
    }

    private void goToDashboard(EventUser user) {
        DashboardController dashboard = new DashboardController(stage, user);
        Scene dashboardScene = new Scene(dashboard.getView(), 600, 500);
        stage.setScene(dashboardScene);
    }

    public VBox getView() {
        return view;
    }
} 
