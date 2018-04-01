import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Stage {

    private Writer writer = new Writer("George Martin");
    private Reader reader = new Reader("Dmitry Emelyanov");

    private Scene scene;
    private Label[] labels;
    private Button[] buttons;
    private TextField[] text;
    private int numberBook = -1;

    public GUI() {

        this.text = new TextField[]{new TextField(null), new TextField(null)};
        this.labels = new Label[]{
                new Label("Книжный КЛУБ"),
                new Label("Писатель"),
                new Label("Читатель"),
                new Label("Для ввода количества страниц"),
                new Label("Для ввода отзыва")
        };
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                this.labels[0].setFont(new Font("Arial",25));
                continue;
            }
            this.labels[i].setFont(new Font(20));
        }
        this.buttons = new Button[]{
                new Button("Написать книгу..."),
                new Button("Прочитать книгу и дать отзыв"),
                new Button("Выход")
        };

        GridPane Pane = new GridPane();
        Pane.setPadding(new Insets(20.0));
        Pane.setVgap(15.0); // Vertical distance between components
        Pane.setHgap(10.0); // Horizontal

        for (int i = 0; i < this.labels.length; i++)
            GridPane.setHalignment(this.labels[i], HPos.CENTER);

        for (int i = 0; i < this.buttons.length; i++)
            GridPane.setHalignment(this.buttons[i], HPos.CENTER);

        Pane.add(this.labels[0], 0, 0, 2, 1);
        Pane.add(this.labels[1], 0, 1);
        Pane.add(this.labels[2], 1, 1);
        Pane.add(this.labels[3], 0, 2);
        Pane.add(this.labels[4], 1, 2);
        Pane.add(this.text[0], 0, 3);
        Pane.add(this.text[1], 1, 3);
        Pane.add(this.buttons[0], 0, 4);
        Pane.add(this.buttons[1], 1, 4);
        Pane.add(this.buttons[2], 1, 6);

        for (int i = 0; i < this.buttons.length; i++) {

            switch (i) {

                case 0:

                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        try {
                            this.writer.writeBook(new Book(Integer.parseInt(text[0].getText())));
                            GUI.showDialogMessage("Книга написана!");
                            numberBook++;
                            text[0].setText(null);
                        }catch (Exception ex ) {
                            GUI.showDialogMessage("WARNING!!!", "Чтобы написать книгу, сначала введите кол-во страниц");}
                    });
                    break;

                case 1:

                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        try {
                            if(text[1].getText() != null) {
                                reader.readBook(writer.getBook().get(numberBook), text[1].getText());
                                GUI.showDialogMessage("Кол-во страниц в прочитанной книге = " + reader.getWriter().getBook().get(numberBook).getPages()
                                    + "\nОтзыв отправлен:\n"+text[1].getText());
                                text[1].setText(null);
                            }
                            else {
                                GUI.showDialogMessage("Вы не ввели отзыв!");
                            }
                        }catch (Exception ex ) {
                            GUI.showDialogMessage("WARNING!!!", "Вы не можете прочитать книгу и оправить по ней отзыв, если она еще не написана :)");}
                    });
                    break;

                case 2:
                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        this.close();
                    });
                    break;
            }
        }

        this.scene = new Scene(Pane);
        setTitle("Application");
        setResizable(false);
        setScene(this.scene);
        show();
    }

    private static void showDialogMessage(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setHeaderText("");
        alert.showAndWait();
    }

    public static void showDialogMessage(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText("");
        alert.showAndWait();

    }

}
