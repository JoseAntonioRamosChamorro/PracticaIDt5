package Principal;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.swing.JButton;

public class Main extends JFrame {
	//Frames





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */

	public Main() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblArticulos = new JLabel("Articulos");
		GridBagConstraints gbc_lblArticulos = new GridBagConstraints();
		gbc_lblArticulos.insets = new Insets(0, 0, 5, 5);
		gbc_lblArticulos.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblArticulos.gridx = 2;
		gbc_lblArticulos.gridy = 1;
		contentPane.add(lblArticulos, gbc_lblArticulos);

		JLabel lblTickets = new JLabel("Tickets");
		GridBagConstraints gbc_lblTickets = new GridBagConstraints();
		gbc_lblTickets.insets = new Insets(0, 0, 5, 5);
		gbc_lblTickets.gridx = 7;
		gbc_lblTickets.gridy = 1;
		contentPane.add(lblTickets, gbc_lblTickets);

		JButton btnAltaA = new JButton("Alta");
		GridBagConstraints gbc_btnAltaA = new GridBagConstraints();
		gbc_btnAltaA.insets = new Insets(0, 0, 5, 5);
		gbc_btnAltaA.gridx = 2;
		gbc_btnAltaA.gridy = 3;
		contentPane.add(btnAltaA, gbc_btnAltaA);


		JButton btnAltaT = new JButton("Alta");
		GridBagConstraints gbc_btnAltaT = new GridBagConstraints();
		gbc_btnAltaT.insets = new Insets(0, 0, 5, 5);
		gbc_btnAltaT.gridx = 7;
		gbc_btnAltaT.gridy = 3;
		contentPane.add(btnAltaT, gbc_btnAltaT);

		JButton btnBaja = new JButton("Baja");
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaja.gridx = 2;
		gbc_btnBaja.gridy = 4;
		contentPane.add(btnBaja, gbc_btnBaja);

		JButton btnCon = new JButton("Consulta");
		GridBagConstraints gbc_btnCon = new GridBagConstraints();
		gbc_btnCon.insets = new Insets(0, 0, 5, 5);
		gbc_btnCon.gridx = 2;
		gbc_btnCon.gridy = 5;
		contentPane.add(btnCon, gbc_btnCon);

		JButton btnConT = new JButton("Consulta");
		GridBagConstraints gbc_btnConT = new GridBagConstraints();
		gbc_btnConT.insets = new Insets(0, 0, 5, 5);
		gbc_btnConT.gridx = 7;
		gbc_btnConT.gridy = 5;
		contentPane.add(btnConT, gbc_btnConT);

		JButton btnMd = new JButton("Modificaci\u00F3n");
		GridBagConstraints gbc_btnMd = new GridBagConstraints();
		gbc_btnMd.insets = new Insets(0, 0, 5, 5);
		gbc_btnMd.gridx = 2;
		gbc_btnMd.gridy = 6;
		contentPane.add(btnMd, gbc_btnMd);

		JButton btnReportArticulos = new JButton("Ireport");
		GridBagConstraints gbc_btnReportArticulos = new GridBagConstraints();
		gbc_btnReportArticulos.insets = new Insets(0, 0, 0, 5);
		gbc_btnReportArticulos.gridx = 2;
		gbc_btnReportArticulos.gridy = 7;
		contentPane.add(btnReportArticulos, gbc_btnReportArticulos);

		JButton btnIreport = new JButton("Ireport");
		GridBagConstraints gbc_btnIreport = new GridBagConstraints();
		gbc_btnIreport.insets = new Insets(0, 0, 0, 5);
		gbc_btnIreport.gridx = 7;
		gbc_btnIreport.gridy = 7;
		contentPane.add(btnIreport, gbc_btnIreport);
		btnIreport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				IreportTicket c2t = new IreportTicket();

			}
		});
		btnAltaA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AltaArticulo AA = new AltaArticulo();

			}
		});
		btnAltaT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AltaTicket AT = new AltaTicket();

			}
		});
		btnCon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsultaArticulo CA = new ConsultaArticulo();

			}
		});
		btnConT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsultaTicket CT = new ConsultaTicket();

			}
		});
		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				BajaArticulo BA = new BajaArticulo();
			}
		});
		btnMd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ModificarArticulo MA = new ModificarArticulo();
			}
		});
		btnReportArticulos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					// Compilar el informe generando fichero jasper
					JasperCompileManager.compileReportToFile("ArticulosDIt5.jrxml");
					System.out.println("Fichero EjemploInforme.jasper generado CORRECTAMENTE!");
					// Objeto para guardar parámetros necesarios para el informe
					HashMap<String,Object> parametros = new HashMap<String,Object>();
					// Cargar el informe compilado
					JasperReport report = (JasperReport)
							JRLoader.loadObjectFromFile("ArticulosDIt5.jasper");
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
					JasperExportManager.exportReportToPdfFile(print, "ArticulosDIt5.pdf");
					// Abrir el fichero PDF generado
					File path = new File ("ArticulosDIt5.pdf");
					Desktop.getDesktop().open(path);

				}
				catch (Exception e)
				{
					System.out.println("Error: " + e.toString());
				}

			}
		});

	}

}
