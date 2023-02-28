package penguin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginController implements Initializable {
	@FXML private Button btnLogin;
	@FXML private Button btnJoin;
	@FXML private TextField tfId;
	@FXML private TextField tfPw;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnLogin.setOnAction(event->login(event));
		btnJoin.setOnAction(event->join(event));
	}
	

	public void login(ActionEvent event) { 
		String fxId = tfId.getText().toString();
		String fxPw = tfPw.getText().toString();
//		System.out.println("id:"+id); 
//		System.out.println("pw:"+pw);
		
		if(tfId.getText().toString().equals("")){
			System.out.println("아이디를 입력하시오.");
			return;}
		if(tfPw.getText().toString().equals("")){			
			System.out.println("패스워드를 입력하시오.");
			return;}
		
		String inputId = tfId.getText();
		String inputPw = tfPw.getText();
		////////////////////////////////////////
		///데이타베이스접속..
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		//접속 주소 : 3306/디비명
		String url = "jdbc:mysql://localhost:3306/penguin_game?useUnicode=true&characterEncoding=utf8";
		//String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from game_userdb";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			boolean idOk = false;
			while (rs.next()) {				
				if(inputId.equals(rs.getString(2)))
				{
					idOk=true;
					if(inputPw.equals(rs.getString(3)))
					{							
						System.out.println("로그인 성공!!");
						moveTogameMain();
					}
					else
					{						
						System.out.println("비번이 틀립니다!!");
					}
				}
			}				
			if(idOk == false)
			{				
				System.out.println("아이디를 확인하세요.");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}	
	}
	public void join(ActionEvent event) {	
		try {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("user_join.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void moveTogameMain() {	
		try {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("game_main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
