	package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Choice;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;
/**
 * Esta clase permite modificar los articulos añadidos
 * @author Jose
 *@version 0.5
 *@since 15 febrero 2021
 */
public class ModificarArticulo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDescrip;
	private JTextField textPrecio;
	private JTextField textCant;



	public ModificarArticulo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lbSeleccionar = new JLabel("Seleccionar");
		GridBagConstraints gbc_lbSeleccionar = new GridBagConstraints();
		gbc_lbSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_lbSeleccionar.gridx = 3;
		gbc_lbSeleccionar.gridy = 0;
		contentPane.add(lbSeleccionar, gbc_lbSeleccionar);
		
		Choice choice = new Choice();
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 3;
		gbc_choice.gridy = 1;
		contentPane.add(choice, gbc_choice);
		
		JLabel lbdescripcion = new JLabel("Descripci\u00F3n");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lbdescripcion, gbc_lblNewLabel);
		
		textDescrip = new JTextField();
		GridBagConstraints gbc_textDescrip = new GridBagConstraints();
		gbc_textDescrip.insets = new Insets(0, 0, 5, 5);
		gbc_textDescrip.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDescrip.gridx = 3;
		gbc_textDescrip.gridy = 4;
		contentPane.add(textDescrip, gbc_textDescrip);
		textDescrip.setColumns(10);
		
		JLabel LBPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 5;
		contentPane.add(LBPrecio, gbc_lblNewLabel_1);
		
		textPrecio = new JTextField();
		GridBagConstraints gbc_textPrecio = new GridBagConstraints();
		gbc_textPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_textPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrecio.gridx = 3;
		gbc_textPrecio.gridy = 6;
		contentPane.add(textPrecio, gbc_textPrecio);
		textPrecio.setColumns(10);
		
		JLabel LBCantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 7;
		contentPane.add(LBCantidad, gbc_lblNewLabel_2);
		
		textCant = new JTextField();
		GridBagConstraints gbc_textCant = new GridBagConstraints();
		gbc_textCant.insets = new Insets(0, 0, 5, 5);
		gbc_textCant.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCant.gridx = 3;
		gbc_textCant.gridy = 8;
		contentPane.add(textCant, gbc_textCant);
		textCant.setColumns(10);
		
		JButton btnMod = new JButton("Modificar");
		GridBagConstraints gbc_btnMod = new GridBagConstraints();
		gbc_btnMod.insets = new Insets(0, 0, 0, 5);
		gbc_btnMod.gridx = 1;
		gbc_btnMod.gridy = 9;
		contentPane.add(btnMod, gbc_btnMod);
		
		JButton btnRellenar = new JButton("Rellenar");
		GridBagConstraints gbc_btnRellenar = new GridBagConstraints();
		gbc_btnRellenar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRellenar.gridx = 3;
		gbc_btnRellenar.gridy = 9;
		contentPane.add(btnRellenar, gbc_btnRellenar);
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.anchor = GridBagConstraints.NORTH;
		gbc_btnVolver.gridx = 5;
		gbc_btnVolver.gridy = 9;
		contentPane.add(btnVolver, gbc_btnVolver);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});

		// Montar el Choice
		choice.add("Seleccionar uno...");
		// Conectar a la base de datos
		Connection con = conectar();
		// Sacar los datos de la tabla edificios
		// Rellenar el Choice
		String sqlSelect = "SELECT * FROM articulo";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				choice.add(rs.getInt("idArticulo")+
						"-"+rs.getString("Descripcion")+
						", "+rs.getInt("Precio")+" €"+
						", "+rs.getInt("Cantidad"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}
		// Cerrar la conexión
		desconectar(con);
		btnRellenar.addActionListener(new ActionListener() {
			Connection con = conectar();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				textDescrip.selectAll();
				textDescrip.setText("");
				textDescrip.requestFocus();
				
				textPrecio.selectAll();
				textPrecio.setText("");
				textPrecio.requestFocus();
				
				textCant.selectAll();
				textCant.setText("");
				textCant.requestFocus();
				
				String[] Client=choice.getSelectedItem().split("-");
				 CompletarDescripcion(con, Integer.parseInt(Client[0]),textDescrip);
				 CompletarPrecio(con, Integer.parseInt(Client[0]),textPrecio);
				 CompletarCantidad(con, Integer.parseInt(Client[0]),textCant);
		
				
				
			}
			/**
			 * Selecciona la cantidad de un articulo que hay en la BD y la muestra en su zona de texto correspondiente
			 * @param con2 permite contectar con la base de datos
			 * @param id guarda la id del articulo
			 * @param textCant muestra la cantidad
			 */
			private void CompletarCantidad(Connection con2, int id, JTextField textCant) {
				String sqlSelect = "SELECT * FROM articulo WHERE idArticulo =" + id;
				try {
					// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
					Statement stmt = con2.createStatement();
					ResultSet rs = stmt.executeQuery(sqlSelect);
					while (rs.next()) 
					{
						if(textCant.getText().length()==0)
						{
							textCant.setText(rs.getString("Cantidad"));
						}
						else
						{
							textCant.setText(textCant.getText() + "\n" 
									+rs.getString("Cantidad"));
						}
					}
					rs.close();
					stmt.close();
				} catch (SQLException ex) {
					System.out.println("ERROR:al consultar");
					ex.printStackTrace();
				}
			}
			
			/**
			 * Selecciona el precio de un articulo que hay en la BD y la muestra en su zona de texto correspondiente
			 * @param con2 permite contectar con la base de datos
			 * @param parseInt guarda la id del articulo
			 * @param textPrecio guarda el precio del articulo
			 */
			private void CompletarPrecio(Connection con2, int parseInt, JTextField textPrecio) {
				String sqlSelect = "SELECT * FROM articulo WHERE idArticulo =" + parseInt;
				try {
					// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
					Statement stmt = con2.createStatement();
					ResultSet rs = stmt.executeQuery(sqlSelect);
					while (rs.next()) 
					{
						if(textPrecio.getText().length()==0)
						{
							textPrecio.setText(rs.getString("Precio"));
						}
						else
						{
							textPrecio.setText(textPrecio.getText() + "\n" 
									+rs.getString("Precio"));
						}
					}
					rs.close();
					stmt.close();
				} catch (SQLException ex) {
					System.out.println("ERROR:al consultar");
					ex.printStackTrace();
				}
				
			}
			/**
			 * Selecciona la descripcion de un articulo que hay en la BD y la muestra en su zona de texto correspondiente
			 * @param con2 permite contectar con la base de datos
			 * @param parseInt guarda la id del articulo
			 * @param textDescrip guarda el nombre del articulo
			 */
			private void CompletarDescripcion(Connection con2, int parseInt, JTextField textDescrip) {
				String sqlSelect = "SELECT * FROM articulo WHERE idArticulo =" + parseInt;
				try {
					// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
					Statement stmt = con2.createStatement();
					ResultSet rs = stmt.executeQuery(sqlSelect);
					while (rs.next()) 
					{
						if(textDescrip.getText().length()==0)
						{
							textDescrip.setText(rs.getString("Descripcion"));
						}
						else
						{
							textDescrip.setText(textDescrip.getText() + "\n" 
									+rs.getString("Descripcion"));
						}
					}
					rs.close();
					stmt.close();
				} catch (SQLException ex) {
					System.out.println("ERROR:al consultar");
					ex.printStackTrace();
				}
				
			}
		});
		
		btnMod.addActionListener(new ActionListener() {
			Connection con = conectar(); 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//realaizar to la pesca
				String[] Clin=choice.getSelectedItem().split("-");
				int respuesta = modificar(con,Integer.parseInt(Clin[0]), textDescrip.getText(),textPrecio.getText(),
						textCant.getText());
				// Mostramos resultado
				if(respuesta == 0)
				{
					System.out.println("Articulo Modificado");
				}
				else
				{
					System.out.println("Error en la modificación");
				}
				// Actualizar el Choice
				choice.removeAll();
				choice.add("Seleccionar uno...");
				String sqlSelect = "SELECT * FROM articulo";
				try {
					// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sqlSelect);
					while (rs.next()) 
					{
						choice.add(rs.getInt("idArticulo")+
								"-"+rs.getString("Descripcion")+
								", "+rs.getInt("Precio")+" €"+
								", "+rs.getString("Cantidad"));
					}
					rs.close();
					stmt.close();
					// Borrar
					textDescrip.selectAll();
					textDescrip.setText("");
					textDescrip.requestFocus();
					
					textPrecio.selectAll();
					textPrecio.setText("");
					textPrecio.requestFocus();
					
					textCant.selectAll();
					textCant.setText("");
					textCant.requestFocus();
				} catch (SQLException ex) {
					System.out.println("ERROR:al consultar");
					ex.printStackTrace();
				}
				// Desconectar
				desconectar(con);
				
				
			}
			/**
			 * Modifica el articulo seleccionado con los datos nuevos y los agrega a la BD
			 * @param con2 permite contectar con la base de datos
			 * @param parseInt guarda la id del articulo	
			 * @param textDescrip guarda el nombre del articulo
			 * @param textPrecio guarda el precio del articulo
			 * @param textcantidad guarda la cantidad del articulo
			 * @return si regresa 0 la insercción a sido lograda, si devuelve 1 es que a fallado 
			 */
			private int modificar(Connection con2, int parseInt, String textDescrip, String textPrecio, String textcantidad) {
				int respuesta = 0;
				String sql = "update articulo set Descripcion ='"+textDescrip+"', Precio = '"+textPrecio+"'"
						+ ", Cantidad = '"+textcantidad+"' where idArticulo = '"+parseInt+"'";
				System.out.println(sql);
				try 
				{
					// Creamos un STATEMENT para una consulta SQL INSERT.
					Statement sta = con.createStatement();
					sta.executeUpdate(sql);
					sta.close();
				} 
				catch (SQLException ex) 
				{
					System.out.println("ERROR:al hacer un Update");
					ex.printStackTrace();
					respuesta = 1;
				}
				return respuesta;
			}
		});
		
		setVisible(true);
	}
	//conectar y desconectar  Connection con = conectar();  desconectar(con);
	/**
	 *  Conecta con la base de datos
	 * @return si regresa "null" la conexión ha fallado 
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
				// Establecer la conexión con la BD empresa
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
		 * @param con con llama a la funcion conectar para cerrarla y desconectar de la BD
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
