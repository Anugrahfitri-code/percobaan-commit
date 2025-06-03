package controller;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

public class DashboardController {
    private BorderPane view;
    private Label welcomeLabel;
    private VBox contentBox;
    private EventUser user;
    private Stage stage;

    public DashboardController(Stage stage, EventUser user) {
        this.stage = stage;
        this.user = user;
        buildView();
        loadContent();
    }

    private void buildView() {
        welcomeLabel = new Label("Welcome, " + user.getUsername() + " (" + user.getRole() + ")");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        contentBox = new VBox(10);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-alignment: top-center;");

        view = new BorderPane();
        view.setTop(welcomeLabel);
        view.setCenter(contentBox);
    }

    private void loadContent() {
        contentBox.getChildren().clear();

        if (user instanceof Participant participant) {
            TextField titleField = new TextField();
            titleField.setPromptText("Judul Ide");

            TextArea descArea = new TextArea();
            descArea.setPromptText("Deskripsi Ide");

            Button submitBtn = new Button("Submit Ide");
            submitBtn.setOnAction(e -> {
                String title = titleField.getText();
                String desc = descArea.getText();
                if (!title.isEmpty() && !desc.isEmpty()) {
                    participant.submitIdea(title, desc);
                    showAlert("Sukses", "Ide berhasil dikirim!");
                    titleField.clear();
                    descArea.clear();
                    loadContent();
                }
            });

            contentBox.getChildren().addAll(new Label("Submit Ide Inovatif:"), titleField, descArea, submitBtn);
            contentBox.getChildren().add(new Label("Ide Anda:"));
            for (Idea idea : participant.getSubmittedIdeas()) {
                contentBox.getChildren().add(new Label("- " + idea.getTitle()));
            }

        } else if (user instanceof Judge judge) {
            Idea[] ideas = {
                new Idea("Smart Waste Bin", "Tempat sampah pintar pakai sensor", null),
                new Idea("EcoPrinter", "Printer hemat tinta pakai AI", null)
            };

            contentBox.getChildren().add(new Label("Pilih Ide untuk Di-Vote:"));
            for (Idea idea : ideas) {
                VBox ideaBox = new VBox(5);
                ideaBox.setPadding(new Insets(10));
                ideaBox.setStyle("-fx-border-color: gray;");

                Label title = new Label("Judul: " + idea.getTitle());
                Label desc = new Label("Deskripsi: " + idea.getDescription());
                Label votes = new Label("Votes: " + idea.getVotes());

                Button voteBtn = new Button("Vote");
                voteBtn.setOnAction(e -> {
                    judge.voteIdea(idea);
                    showAlert("Vote Terkirim", "Kamu telah memberikan vote untuk ide ini.");
                    voteBtn.setDisable(true);
                    votes.setText("Votes: " + idea.getVotes());
                });

                ideaBox.getChildren().addAll(title, desc, votes, voteBtn);
                contentBox.getChildren().add(ideaBox);
            }
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public BorderPane getView() {
        return view;
    }
    //sxjkbdyuedhbdhdwbhrcbrbc dw cef3unc djhsbr cdn bgfyrgfrygfrygfyrfyrfgyrfgry
} 