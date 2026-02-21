import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegistrationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Student Name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        Label courseLabel = new Label("Course Code:");
        ComboBox<String> courseComboBox = new ComboBox<>();
        courseComboBox.getItems().addAll(
                "CMP 167 - Programming I",
                "CMP 168 - Programming II",
                "CMP 269 - Programming III",
                "CMP 232 - Discrete Math",
                "CMP 1001 - Put The Fries In The Bag Bro"
        );
        courseComboBox.setPromptText("Select a course");

        grid.add(courseLabel, 0, 1);
        grid.add(courseComboBox, 1, 1);

        Button registerButton = new Button("Register");

        grid.add(registerButton, 1, 2);

        Label statusLabel = new Label("");

        grid.add(statusLabel, 0, 3, 2, 1);

        registerButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String course = courseComboBox.getValue();

            if (name.isEmpty() && course == null) {
                statusLabel.setText("Please enter your name and select a course.");
            } else if (name.isEmpty()) {
                statusLabel.setText("Please enter your student name.");
            } else if (course == null) {
                statusLabel.setText("Please select a course.");
            } else {
                statusLabel.setText("Registration Successful for " + name + " in " + course + "!");
            }
        });

        Scene scene = new Scene(grid, 450, 200);
        primaryStage.setTitle("Lehman Course Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}