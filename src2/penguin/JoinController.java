package penguin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JoinController implements Initializable {
	
	//������ Ŭ����������...
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/penguin_game?useUnicode=true&characterEncoding=utf8";	
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		/////////////////////////////////////////////////////////////////////////
		
	@FXML private Button btnJoin;
	@FXML private Button btnIdCheck;
	@FXML private Button btnCancel;
	@FXML private TextField tfId;
	@FXML private TextField tfPw;

	String inputId, inputPw;
	private Stage primaryStage;	
	boolean idCheck=true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnJoin.setOnAction(event->join(event));
		btnCancel.setOnAction(event->cancel(event));
		btnIdCheck.setOnAction(event->idCheck(event));
		dbCon();//��񿬰�;
	}
	public void join(ActionEvent event) 
	{ 
		inputId = tfId.getText().toString();
		inputPw = tfPw.getText().toString();

		if(inputId.equals("")){	dlgMsg("���̵� �Է����ּ���.");	return;	}
		else if(inputPw.equals("")){	dlgMsg("�н����带 �Է����ּ���.");	return;	}
	
		insert(inputId,inputPw);	
	}
	public void cancel(ActionEvent event) 
	{	
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}
	void dbCon()
	{
		////////////////////////////////////////
		///����Ÿ���̽�����..	
		try {	Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {System.exit(0);}	

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		////////////////////////////////////////////
	}
	void idCheck(ActionEvent event)
	{
		String query = "select * from game_userdb";				
		try 
		{								
			rs = stmt.executeQuery(query);			
			while (rs.next()) 
			{		
				if(tfId.getText().toString().equals(""))
				{
					System.out.println("���̵� �Է����ּ���!");
					dlgMsg("���̵� �Է����ּ���!");
					tfId.setText("");
					idCheck = false;					
					break;										
				}
				else if(tfId.getText().toString().equals(rs.getString("id")))
				{
					System.out.println("���̵� �ߺ��˴ϴ�!");
					dlgMsg("���̵� �ߺ��˴ϴ�!");
					tfId.setText("");
					idCheck = false;					
					break;										
				}
			}
			if(idCheck==true)
			{
				System.out.println("��� ������ ���̵� �Դϴ�!");
				dlgMsg("��밡���� ���̵��Դϴ�!");
				tfId.setDisable(true);
				btnIdCheck.setDisable(true);				
			}
			
		} 
		catch (SQLException ee) 
		{
			System.err.println("������ ȹ�� ����!!");
		}
		idCheck=true;	
	}
	void insert(String inputId,String inputPw)
	{	
		if(idCheck != true)
		{
			dlgMsg("���̵� �ߺ�üũ Ȯ��!");
			return;
		}
		String pquery = "insert into game_userdb values (null, ?, ?)";	
		try 
		{
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);		
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} 
		catch (SQLException ee) 
		{
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}		
		tfId.setText("");
		tfPw.setText("");
	}
	void dlgMsg(String msg){
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("ȸ������ ���� �˸�");
		
		Parent parent;
		try 
		{
			parent = FXMLLoader.load(getClass().getResource("dialog.fxml"));
			Label txtTitle = (Label) parent.lookup("#txtTitle");
			txtTitle.setText(msg);
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(event->dialog.close());	
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} 
		catch (IOException e) {}
	}
}
