import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


import java.io.IOException;


public class GUI extends Stage {

    private Writer writer = new Writer("George Martin");
    private Reader reader = new Reader("Dmitry Emelyanov");
    private Critic critic = new Critic("Vanya Nicanov");
    private Book book[] = {null, null, null};

    private Scene scene;
    private Label[] labels;
    private Button[] buttons;
    private TextField[] text;
    private ComboBox<String> combo_box;

    public GUI() {

        this.text = new TextField[]{
                new TextField(null),
                new TextField(null),
                new TextField(null)
        };

        this.labels = new Label[]{
                new Label("Книжный КЛУБ"),
                new Label("Писатель"),
                new Label("Читатель"),
                new Label("Критик"),
                new Label("Введите отзыв:"),
                new Label("Введите количество страниц в книге:"),
                new Label("Введите количество страниц в рецензии:")
        };

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                this.labels[0].setFont(new Font("Arial",25));
                continue;
            }
            this.labels[i].setFont(new Font(20));
        }

        this.buttons = new Button[]{
                new Button("Написать книгу"),
                new Button("Прочитать книгу и дать отзыв"),
                new Button("Прочитать рецензию"),
                new Button("Написать рецензию"),
                new Button("Выход")
        };

        this.combo_box = new ComboBox<String>();
        this.combo_box.getItems().addAll("Роман", "Рассказ");
        this.combo_box.setPromptText("Жанр книги");

        GridPane Pane = new GridPane();
        Pane.setPadding(new Insets(20.0));
        Pane.setVgap(15.0); // Vertical distance between components
        Pane.setHgap(10.0); // Horizontal

        for (int i = 0; i < this.labels.length; i++)
            GridPane.setHalignment(this.labels[i], HPos.CENTER);

        for (int i = 0; i < this.buttons.length; i++)
            GridPane.setHalignment(this.buttons[i], HPos.CENTER);
        GridPane.setHalignment(this.combo_box, HPos.CENTER);

        Pane.add(this.text[0], 0, 3);
        Pane.add(this.labels[0], 0, 0, 3, 1);
        Pane.add(this.labels[1], 0, 1);
        Pane.add(this.labels[2], 1, 1);
        Pane.add(this.buttons[0], 0, 5);
        Pane.add(this.buttons[1], 1, 4);
        Pane.add(this.buttons[2], 0, 6);
        Pane.add(this.buttons[3], 2, 4);
        Pane.add(this.buttons[4], 1, 7);
        Pane.add(this.text[1], 1, 3);
        Pane.add(this.text[2], 2, 3);
        Pane.add(this.labels[4], 1, 2);
        Pane.add(this.labels[5], 0, 2);
        Pane.add(this.labels[6], 2, 2);
        Pane.add(this.labels[3], 2, 1);
        Pane.add(this.combo_box, 0, 4);

        for (int i = 0; i < this.buttons.length; i++) {

            switch (i) {

                case 0: //Написать книгу

                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        try {

                            if (Integer.parseInt(text[0].getText())<=0) throw new Exception();

                            switch (this.combo_box.getValue()) {

                                case "Роман":
                                    this.book[0] = writer.writeBook(Integer.parseInt(text[0].getText()), this.combo_box.getValue());
                                    break;
                                case "Рассказ":
                                    this.book[1] = this.writer.writeBook(Integer.parseInt(text[0].getText()), this.combo_box.getValue());
                                    break;
                                }
                                GUI.showDialogMessage(this.combo_box.getValue() + " написан!");
                                text[0].setText(null);

                        }catch (Exception ex ) {
                            text[0].setText(null);
                            GUI.showDialogMessage("WARNING!!!", "Чтобы написать книгу, выберите жанр и введите количество страниц (число должно быть положительным) :(");}
                    });
                    break;

                case 1: // Прочитать книгу и дать отзыв

                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        try {
                            if(text[1].getText() == null) throw new IOException();
                            int amountPage = 1;
                            String answerFromWriter = " ";

                            switch (this.combo_box.getValue()) {

                                case "Роман":
                                    amountPage = reader.readBook(book[0]);
                                    answerFromWriter =  reader.giveFeedback(this.writer, text[1].getText());
                                    break;
                                case "Рассказ":
                                    amountPage = reader.readBook(book[1]);
                                    answerFromWriter =  reader.giveFeedback(this.writer, text[1].getText());
                                    break;
                            }
                            GUI.showDialogMessage("В прочитанном "+ this.combo_box.getValue()+ "е "  + amountPage +
                                    " страниц" + "\nОтзыв отправлен:" + "<" + text[1].getText() +
                                    ">" + "\nОтвет писателя: <" +answerFromWriter+ ">  :DDD" );
                            text[1].setText(null);
                        }
                    catch (IOException ex ) {
                            text[1].setText(null);
                            GUI.showDialogMessage("WARNING!!!", "Вы забыли ввести отзыв :(");}
                    catch (Exception ex ) {
                            text[1].setText(null);
                            GUI.showDialogMessage("WARNING!!!", "Вы не можете прочитать книгу и оправить по ней отзыв, пока она не написана :(");}
                    });
                    break;

               case 2:  // Прочитать рецензию

                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        try {
                            if (book[2]!= null) {
                                int amountPageInReview = this.writer.readBook(book[2]);
                                GUI.showDialogMessage("В прочитанной рецензии " + amountPageInReview + " страниц");
                            }
                            else throw new Exception();
                        }catch (Exception ex ) {GUI.showDialogMessage("WARNING!!!", "Вы не можете прочитать рецензию, пока она не написана :(");}
                    });
                    break;

                case 3:  // Написать рецензию
                    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        try {
                           if (Integer.parseInt(text[2].getText())<=0) throw new Exception();
                           this.book[2] = critic.writeReview(Integer.parseInt(text[2].getText()));
                           GUI.showDialogMessage("Рецензия написана!");
                           text[2].setText(null);
                        }catch (Exception ex ) {GUI.showDialogMessage("WARNING!!!", "Чтобы написать рецензию, введите количество страниц (число должно быть положительным) :(");}
                    });
                    break;

                case 4: // Выход
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

