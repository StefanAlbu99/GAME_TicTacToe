package projeto_final;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/*
CREATE VIEW players_scores AS
SELECT nome_playerX AS player_name, pontos_playerX AS player_score
FROM jogo_tic_tac_toe
UNION ALL
SELECT nome_playerO AS player_name, pontos_playerO AS player_score
FROM jogo_tic_tac_toe;
*/

public class JdbcExer {

	Connection connection = null;
	protected Statement statement = null; //gere as consultas
	public ResultSet resultset = null;//armazena as informacoes das consultas
	
	public void conectar() 
	{
		   String JDBC_DRIVER = "com.mysql.jdbc.Driver";//caminho do driver que foi adicionado
		   String DB_URL = "jdbc:mysql://localhost:3306/projeto_final_programacao";//porta padrao que o mysql usa
		   String user = "root";
		   String pass = "";
		   try {
			   Class.forName(JDBC_DRIVER);
			   this.connection =  (Connection) DriverManager.getConnection(DB_URL, user, pass);
			   this.statement =  (Statement) this.connection.createStatement();
		   }catch (Exception e) //armazena a excecao na var e
		   {
			   System.out.println("erro: " + e.getMessage());
		   }
	}
	
	//metodo que retorna um valor booleano
	//se conseguiu conectar então é diferente de null, dá resultado true
	public boolean estaconectado() {
		if(this.connection != null) {
			return true;
		}else { //senao nao conseguiu connectar entao continua null, entra no false
			return false;
		}
	}
		
	public void logout() {
		try {
			this.connection.close();
		}catch(Exception e) {
				   System.out.println("erro: " + e.getMessage());
		}
	}
	
	public void inserirDataJogo(String nomeX, String nomeO, int pontosX, int pontosO)
	{
		try{
		String query = "INSERT INTO jogo_tic_tac_toe (nome_playerX, nome_playerO, pontos_playerX, pontos_playerO) VALUES ('"+ nomeX + "','"+ nomeO +"','" + pontosX+ "','" + pontosO + "');";
		this.statement.executeUpdate(query);
		
		}catch(Exception e) {
			{
				System.out.println("erro: " + e.getMessage());
			}
		}
	}
	
	
	public void eliminarJogo(int id) {
		
		try{
			String query = "DELETE FROM jogo_tic_tac_toe WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
			
			}catch(Exception e) {
				{
					   System.out.println("erro: " + e.getMessage());
				   }
			}
		
	}
	
	public String[] retorna_nome(int id) {
		
		try{
			String query = "SELECT nome_playerX, nome_playerO FROM jogo_tic_tac_toe WHERE game_id = " + id;
			resultset = this.statement.executeQuery(query);
			if (resultset.next()) { // Verifica se há pelo menos uma linha no resultset
	            String nomes[] = {resultset.getString("nome_playerX"), resultset.getString("nome_playerO")};
	            return nomes;
			}else {
				return null;
			}
			
			}catch(Exception e) {
					System.out.println("erro: " + e.getMessage());
					return null; 
			}
		
	}
	
	
	public void updatePontos(int pontosX, int pontosO) {
	    try {
	        String query = "SELECT * FROM jogo_tic_tac_toe ORDER BY game_id DESC LIMIT 1";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int id = resultSet.getInt("game_id");
	            
	            query = "UPDATE jogo_tic_tac_toe SET pontos_playerX = ?, pontos_playerO = ? WHERE game_id = ?";
	            statement = connection.prepareStatement(query);
	            statement.setInt(1, pontosX);
	            statement.setInt(2, pontosO);
	            statement.setInt(3, id);
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	            	//JOptionPane.showMessageDialog(null, "Registo atualizado com sucesso!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Nenhum registo encontrado com o ID fornecido.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Nenhum registo encontrado.");
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar registo: " + e.getMessage());
	    }
	}
}

