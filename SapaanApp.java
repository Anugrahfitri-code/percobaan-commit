import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SapaanApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplikasi Sapaan");

        // Membuat Label untuk judul
        Label judulLabel = new Label("Masukkan Nama Anda:");

        // Membuat TextField untuk input nama
        TextField namaField = new TextField();
        namaField.setPromptText("Nama"); // Teks placeholder

        // Membuat Button untuk mengirim sapaan
        Button sapaButton = new Button("Sapa!");

        // Membuat Label untuk menampilkan sapaan
        Label sapaanLabel = new Label();

        // Aksi ketika tombol ditekan
        sapaButton.setOnAction(e -> {
            String nama = namaField.getText();
            if (nama.isEmpty()) {
                sapaanLabel.setText("Halo! Silakan masukkan nama Anda.");
            } else {
                sapaanLabel.setText("Halo, " + nama + "! Selamat datang.");
            }
        });

        // Membuat layout VBox
        VBox vbox = new VBox(10); // Jarak antar elemen 10 piksel
        vbox.setPadding(new Insets(20)); // Padding di sekitar VBox
        vbox.setAlignment(Pos.CENTER); // Pusatkan elemen dalam VBox
        vbox.getChildren().addAll(judulLabel, namaField, sapaButton, sapaanLabel);

        // Membuat Scene
        Scene scene = new Scene(vbox, 300, 200); // Lebar 300, Tinggi 200

        // Menetapkan Scene ke Stage
        primaryStage.setScene(scene);

        // Menampilkan Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}