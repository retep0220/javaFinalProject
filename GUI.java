package FinalProject;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;


public class GUI extends Application{
	
//	public static void main(String[] args) {
//		launch(args);
//	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene firstpage = new Scene(root,600,600);
		Text title = new Text();
		title.setText("NCKU Info");
		title.setX(250);
		title.setY(50);
		title.setFill(Color.MAROON);
		title.setFont(new Font(25));
		root.getChildren().add(title);
		//set button
		Button rent = new Button("Rent Space");
		Button login_register = new Button("login / register");
		login_register.setTextFill(Color.MAROON);
		AnchorPane.setTopAnchor(login_register, 30.0);
		AnchorPane.setLeftAnchor(login_register, 425.0);
		rent.setTextFill(Color.MAROON);
		AnchorPane.setTopAnchor(rent, 475.0);
		AnchorPane.setLeftAnchor(rent, 80.0);
		Button calendar = new Button("Calendar");
		AnchorPane.setTopAnchor(calendar, 475.0);
		AnchorPane.setLeftAnchor(calendar, 275.0);
		calendar.setTextFill(Color.MAROON);
		Button curriculum = new Button("Curriculum");
		AnchorPane.setTopAnchor(curriculum, 475.0);
		AnchorPane.setLeftAnchor(curriculum, 450.0);
		curriculum.setTextFill(Color.MAROON);
		AnchorPane bottonPane = new AnchorPane();
		
		login_register.setDefaultButton(true);
		
		//LOGIN WINDOW
		login_register.setOnAction((ActionEvent e) -> {
			Stage logstage = new Stage();
			Group root2 = new Group();
			Scene logscene = new Scene(root2,300,300);
			TextField id = new TextField();
			id.setTooltip(new Tooltip("Student ID:"));
			AnchorPane.setTopAnchor(id, 100.0);
			AnchorPane.setLeftAnchor(id, 90.0);
			PasswordField pwd = new PasswordField();
			AnchorPane.setTopAnchor(pwd, 150.0);
			AnchorPane.setLeftAnchor(pwd, 90.0);
			AnchorPane pane = new AnchorPane();
			pane.getChildren().addAll(id,pwd);
			
			Text sid = new Text("Student Id");
			Text psw = new Text("Password");
			sid.setX(20.0);
			sid.setY(120.0);
			sid.setFill(Color.MAROON);
			psw.setX(20.0);
			psw.setY(170.0);
			psw.setFill(Color.MAROON);
			
			Button login = new Button();
			Button register = new Button();
			login.setText("login");
			register.setText("register");
			AnchorPane.setTopAnchor(login, 220.0);
			AnchorPane.setLeftAnchor(login, 170.0);
			AnchorPane.setTopAnchor(register, 220.0);
			AnchorPane.setLeftAnchor(register, 90.0);
			login.setTextFill(Color.MAROON);
			register.setTextFill(Color.MAROON);
			pane.getChildren().addAll(login, register);
			
			root2.getChildren().add(pane);
			root2.getChildren().add(sid);
			root2.getChildren().add(psw);
			
			logstage.setScene(logscene);
			logstage.setTitle("Log In");
			
			logstage.show();
			
			//login api
			login.setOnAction((ActionEvent e1) -> {
				System.out.println(id.getText());
				System.out.println(pwd.getText());
				logstage.close();
			});
			
			//register
			register.setOnAction((ActionEvent e2) -> {
				logstage.close();
				Stage registage = new Stage();
				Group root3 = new Group();
				Scene regiscene = new Scene(root3,300,300);
				
				Text warnning = new Text("Teacher Only");
				warnning.setFill(Color.MAROON);
				warnning.setX(120.0);
				warnning.setY(30.0);
				root3.getChildren().add(warnning);
				
				registage.setScene(regiscene);
				registage.show();
			});
		});
		
		
		bottonPane.getChildren().addAll(login_register,rent,calendar,curriculum);
		root.getChildren().add(bottonPane);
		
		//set text area
		TextArea textarea = new TextArea();
		textarea.prefWidth(300.0);
		textarea.prefHeight(600.0);
		textarea.setEditable(false);
		AnchorPane.setTopAnchor(textarea, 100.0);
		AnchorPane.setLeftAnchor(textarea, 40.0);
		AnchorPane textPane = new AnchorPane();
		textPane.getChildren().add(textarea);
		root.getChildren().add(textPane);
		
		//set event
		curriculum.setOnAction((ActionEvent e) -> {
			Stage curstage = new Stage();
			Group root4 = new Group();
			Scene curscene = new Scene(root4, 645, 700);
			TableView cur = new TableView();
			TableColumn col0 = new TableColumn();
			TableColumn col1 = new TableColumn("Monday");
			TableColumn col2 = new TableColumn("Tuesday");
			TableColumn col3 = new TableColumn("Wednesday");
			TableColumn col4 = new TableColumn("Thursday");
			TableColumn col5 = new TableColumn("Friday");
			TableColumn col6 = new TableColumn("Saturday");
			TableColumn col7 = new TableColumn("Sunday");
			cur.getColumns().addAll(col0,col1,col2,col3,col4,col5,col6,col7);
			root4.getChildren().add(cur);



			curstage.setScene(curscene);
			curstage.show();
		});
		
		stage.setScene(firstpage);

		stage.show();
		
	}
	
	

}
