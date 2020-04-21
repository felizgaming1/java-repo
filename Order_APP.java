package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Order_APP extends Application {

    Button Reset, OK, Cancel;
    Text Welcome, item, extra_item, pcs;
    //    TextField sam,pav,bread;
    Stage stage;
    CheckBox Samosa, Vada_Pav, Breadpakoda;
    CheckBox green_chutney, red_chutney, chilly;

    public static void main(String[] args) {
        launch(args);
        System.out.println("Ended");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;


//        creating the text and setting the position of the txt

        Welcome = new Text("Welcome To the Canteen !");
        Welcome.setFill(Color.BLUE);
        Welcome.setFont(Font.font(20));

        //        Title Pane(child node for teh main pane)

        HBox pane1 = new HBox(10);
        pane1.getChildren().addAll(Welcome);
        pane1.setAlignment(Pos.TOP_CENTER);


//          creating checkbox for selecting the item
        item = new Text("Select the Items :      ");
        item.setFill(Color.BLACK);
        item.setFont(Font.font(15));

        Samosa = new CheckBox("Samosa");
        Vada_Pav = new CheckBox("Vada Pav");
        Breadpakoda = new CheckBox("BreadPakoda");

        //        selecting item pane(child node for teh main pane)

        VBox pane2 = new VBox();
        pane2.getChildren().addAll(item, Samosa, Vada_Pav, Breadpakoda);
        pane2.setSpacing(10);


//        extra item CheckBox
        extra_item = new Text("Extra Things :");
        extra_item.setFill(Color.BLACK);
        extra_item.setFont(Font.font(15));
        green_chutney = new CheckBox("Green Chutney");
        red_chutney = new CheckBox("Red Chutney");
        chilly = new CheckBox("Chilly");


//     creating pane for extra item
        VBox pane4 = new VBox();
        pane4.getChildren().addAll(extra_item, green_chutney, red_chutney, chilly);
        pane4.setSpacing(10);

//        creating button ok,reset,cancel

        Reset = new Button("Reset");
//        Reset.setOnAction(e -> );
        OK = new Button("OK");
        OK.setOnAction(e -> confirm());
        Cancel = new Button("Cancel");
        Cancel.setOnAction(e -> primaryStage.close());

//        making the size of button similar to the button having max width
//        (But it's not working if you can do anything try it

        OK.setMaxWidth(Double.MAX_VALUE);
        Reset.setMaxWidth(Double.MAX_VALUE);
        Cancel.setMaxWidth(Double.MAX_VALUE);


//        Confirmation reset cancel pane(child node for teh main pane)
        HBox pane3 = new HBox(Reset, OK, Cancel);
        pane3.setMargin(Reset, new Insets(10));
        pane3.setMargin(OK, new Insets(10));
        pane3.setMargin(Cancel, new Insets(10));
        pane3.setAlignment(Pos.BOTTOM_RIGHT);


//        main pane

        BorderPane pane = new BorderPane();
        pane.setTop(pane1);
        pane.setLeft(pane2);
        pane.setBottom(pane3);

        pane.setRight(pane4);

        Scene scene = new Scene(pane, 500, 200);
        stage.setScene(scene);
        stage.setTitle("ORDER");
        stage.show();
    }

    public void confirm() {
        Text contain, samT, pavT, breadT;
        TextField sam, pav, bread;
        Button confirm;
//        Stage stage;
        Scene scene;

        contain = new Text("Here are your selected Items :");
        contain.setFont(Font.font(20));
        contain.setFill(Color.BLACK);

        samT = new Text("Samosa(pcs):         ");
        samT.setFont(Font.font(15));
        pavT = new Text("VadaPav(pcs):        ");
        pavT.setFont(Font.font(15));
        breadT = new Text("BreadPakoda(pcs): ");
        breadT.setFont(Font.font(15));

        sam = new TextField();
        sam.setMaxWidth(40);

        pav = new TextField();
        pav.setMaxWidth(40);

        bread = new TextField();
        bread.setMaxWidth(40);

        confirm = new Button("Confirm");
        confirm.setOnAction(e -> ordered(sam, pav, bread));


        if (Samosa.isSelected() && !Vada_Pav.isSelected() && !Breadpakoda.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(samT, sam);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));

            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(hbox);
            pane.setBottom(hbox3);
            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();


        } else if (Vada_Pav.isSelected() && !Samosa.isSelected() && !Breadpakoda.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(pavT, pav);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));

            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(hbox);
            pane.setBottom(hbox3);
            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();

        } else if (Breadpakoda.isSelected() && !Vada_Pav.isSelected() && !Samosa.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(breadT, bread);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));

            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(hbox);
            pane.setBottom(hbox3);
            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();


        } else if (Samosa.isSelected() && Vada_Pav.isSelected() && !Breadpakoda.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(samT, sam);
            HBox hbox1 = new HBox();
            hbox1.getChildren().addAll(pavT, pav);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));
            VBox vbox = new VBox();
            vbox.getChildren().addAll(hbox, hbox1);
            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(vbox);
            pane.setBottom(hbox3);

            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();


        } else if (Samosa.isSelected() && Breadpakoda.isSelected() && !Vada_Pav.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(samT, sam);
            HBox hbox1 = new HBox();
            hbox1.getChildren().addAll(breadT, bread);
            VBox vbox = new VBox();
            vbox.getChildren().addAll(hbox, hbox1);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));
            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(vbox);
            pane.setBottom(hbox3);
            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();


        } else if (Vada_Pav.isSelected() && Breadpakoda.isSelected() && !Samosa.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(pavT, pav);
            HBox hbox1 = new HBox();
            hbox1.getChildren().addAll(breadT, bread);
            VBox vbox = new VBox();
            vbox.getChildren().addAll(hbox, hbox1);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));
            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(vbox);
            pane.setBottom(hbox3);
            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();


        } else if (Breadpakoda.isSelected() && Vada_Pav.isSelected() && Samosa.isSelected()) {
            HBox hbox = new HBox();
            hbox.getChildren().addAll(samT, sam);
            HBox hbox1 = new HBox();
            hbox1.getChildren().addAll(pavT, pav);
            HBox hbox2 = new HBox();
            hbox2.getChildren().addAll(breadT, bread);
            VBox vbox = new VBox();

            vbox.getChildren().addAll(hbox, hbox1, hbox2);
            HBox hbox3 = new HBox();
            hbox3.getChildren().addAll(confirm);
            hbox3.setAlignment(Pos.BOTTOM_RIGHT);
            hbox3.setMargin(confirm, new Insets(10));
            BorderPane pane = new BorderPane();
            pane.setTop(contain);
            pane.setCenter(vbox);
            pane.setBottom(hbox3);
            scene = new Scene(pane, 500, 200);
            stage = new Stage();
            stage.setTitle("ORDER");
            stage.setScene(scene);
            stage.show();


        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have not Selected an Item.");
            a.showAndWait();
        }
    }


    public void ordered(TextField sam, TextField pav, TextField bread) {
        if ((!(sam.getText().length() == 0) && (pav.getText().length() == 0) && (bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(sam.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Your order:\n Samosa pcs:" + message);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }
        if (((sam.getText().length() == 0) && !(pav.getText().length() == 0) && (bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(pav.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Your order:\n Vada Pav pcs:" + message);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }
        if (((sam.getText().length() == 0) && (pav.getText().length() == 0) && !(bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(bread.getText());

                Alert a = new Alert(Alert.AlertType.INFORMATION, "Your order:\n Bread Pakoda pcs:" + message);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }
        if ((!(sam.getText().length() == 0) && !(pav.getText().length() == 0) && (bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(sam.getText());
                int message1=Integer.parseInt(pav.getText());
                String no= "Your Order :\nSamosa  :"+message + "\nVada Pav :"+message1;
                Alert a = new Alert(Alert.AlertType.INFORMATION, no);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }
        if ((!(sam.getText().length() == 0) && (pav.getText().length() == 0) && !(bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(sam.getText());
                int message1=Integer.parseInt(bread.getText());
                String no= "Your Order :\nSamosa:"+message + "\nBread Pakoda:"+message1;
                Alert a = new Alert(Alert.AlertType.INFORMATION, no);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }
        if (((sam.getText().length() == 0) && !(pav.getText().length() == 0) && !(bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(bread.getText());
                int message1=Integer.parseInt(pav.getText());
                String no= "Your Order :\n Vada Pav   :"+message + "\nBread Pakoda:"+message;
                Alert a = new Alert(Alert.AlertType.INFORMATION, no);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }if ((!(sam.getText().length() == 0) && !(pav.getText().length() == 0) && !(bread.getText().length() == 0))) {


            try {
                int message = Integer.parseInt(sam.getText());
                int message1=Integer.parseInt(pav.getText());
                int message2=Integer.parseInt(bread.getText());
                String no= "Your Order :\nSamosa:"+message + "\n Vada Pav :"+message1+"\n BreadPakoda :"+message2;
                Alert a = new Alert(Alert.AlertType.INFORMATION, no);
                a.showAndWait();
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You have enter wrong thing");
                a.showAndWait();
            }

        }
    }

}