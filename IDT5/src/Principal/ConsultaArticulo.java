package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 * Clase que muestra los articulos creados/ dados de alta
 * @author Jose
 *@version 0.5
 *@since 15 febrero 2021
 */
public class ConsultaArticulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConsultaArticulo() {
		Connection con = conectar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lbArticulos = new JLabel("ListaArticulos");
		GridBagConstraints gbc_lbArticulos = new GridBagConstraints();
		gbc_lbArticulos.insets = new Insets(0, 0, 5, 5);
		gbc_lbArticulos.gridx = 4;
		gbc_lbArticulos.gridy = 1;
		contentPane.add(lbArticulos, gbc_lbArticulos);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 6;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 2;
		contentPane.add(textArea, gbc_textArea);
		rellenarTextArea(con,textArea);

		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.anchor = GridBagConstraints.SOUTH;
		gbc_btnVolver.gridx = 4;
		gbc_btnVolver.gridy = 8;
		contentPane.add(btnVolver, gbc_btnVolver);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});
		setVisible(true);
		desconectar(con);
	}
	/**
	 * Rellena una zona de texto con los articulos de la BD
	 * @param con permite contectar con la base de datos
	 * @param t muestra todos los articulos agregados
	 */
	public void rellenarTextArea(Connection con, JTextArea t) {

		String sqlSelect = "SELECT * FROM articulo";
		try {

			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) 
			{
				if(t.getText().length()==0)
				{
					t.setText(rs.getInt("idArticulo")+
							"-"+rs.getString("Descripcion")+
							", "+rs.getString("Precio")+" �"+
							", "+rs.getString("Cantidad"));
				}
				else
				{
					t.setText(t.getText() + "\n" +
							rs.getInt("idArticulo")+
							"-"+rs.getString("Descripcion")+
							", "+rs.getString("Precio")+" �"+
							", "+rs.getString("Cantidad"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}

	}
	//conectar y desconectar  Connection con = conectar();  desconectar(con);
	/**
	 * Conecta con la base de datos
	 * @return si regresa "null" la conexi�n ha fallado 
	 */
	public static Connection conectar()
	{
		String BD = "tienda";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/"+BD+"?autoReconnect=true&useSSL=false";
		String user = "root2";
		String password = "12345678A";
		Connection con = null;
		try {
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexi�n con la BD empresa
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());
		}

		return con;
	}
	/**
	 * Desconecta con la base de datos
	 * @param con llama a la funcion conectar para cerrarla y desconectar de la BD
	 */
	public static void desconectar(Connection con)
	{
		try
		{
			con.close();
		}
		catch(Exception e) {}
	}
}
