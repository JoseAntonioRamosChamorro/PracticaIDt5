package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JButton;

public class IreportTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public IreportTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lbFechaDesde = new JLabel("Fecha desde");
		GridBagConstraints gbc_lbFechaDesde = new GridBagConstraints();
		gbc_lbFechaDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lbFechaDesde.gridx = 2;
		gbc_lbFechaDesde.gridy = 1;
		contentPane.add(lbFechaDesde, gbc_lbFechaDesde);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lbFechaHasta = new JLabel("Fecha Hasta");
		GridBagConstraints gbc_lbFechaHasta = new GridBagConstraints();
		gbc_lbFechaHasta.insets = new Insets(0, 0, 5, 5);
		gbc_lbFechaHasta.gridx = 2;
		gbc_lbFechaHasta.gridy = 3;
		contentPane.add(lbFechaHasta, gbc_lbFechaHasta);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnAcept = new JButton("Aceptar");
		GridBagConstraints gbc_btnAcept = new GridBagConstraints();
		gbc_btnAcept.insets = new Insets(0, 0, 0, 5);
		gbc_btnAcept.gridx = 3;
		gbc_btnAcept.gridy = 5;
		contentPane.add(btnAcept, gbc_btnAcept);
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.gridx = 4;
		gbc_btnVolver.gridy = 5;
		contentPane.add(btnVolver, gbc_btnVolver);
		
		btnAcept.addActionListener(new ActionListener() {
			// SELECT * FROM ticket WHERE date_ticket BETWEEN $P{dateFrom} AND $P{dateTo};
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					// Compilar el informe generando fichero jasper
					JasperCompileManager.compileReportToFile("IDt5.jrxml");
					System.out.println("Fichero ticket.jasper generado CORRECTAMENTE!");
					// Objeto para guardar parámetros necesarios para el informe
					HashMap<String,Object> parametros = new HashMap<String,Object>();
					parametros.put("fechadesde",textField.getText());
					parametros.put("fechahasta",textField_1.getText());
					
					// Cargar el informe compilado
					JasperReport report = (JasperReport)
							JRLoader.loadObjectFromFile("IDt5.jasper");
					// Conectar a la base de datos para sacar la información
					Class.forName("com.mysql.jdbc.Driver");
					String servidor = "jdbc:mysql://localhost/tienda?characterEncoding=utf8";
					String usuarioDB = "root2";
					String passwordDB = "12345678A";
					Connection conexion = (Connection) DriverManager.getConnection(servidor, usuarioDB,passwordDB);
					
					
					// Completar el informe con los datos de la base de datos
					JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
					// Mostrar el informe en JasperViewer
					JasperViewer.viewReport(print, false);
					// Para exportarlo a pdf
					JasperExportManager.exportReportToPdfFile(print, "IDt5.pdf");
					// Abrir el fichero PDF generado
					File path = new File ("IDt5.pdf");
					Desktop.getDesktop().open(path);

				}
				catch (Exception e)
				{
					System.out.println("Error: " + e.toString());
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});
		setVisible(true);
	}
}
