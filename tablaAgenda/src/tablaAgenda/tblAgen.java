package tablaAgenda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class tblAgen extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTable table;
	private JTextField txtName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tblAgen frame = new tblAgen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public tblAgen() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 427);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 96, 378, 226);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Edad" ,"Telefono"
			}
		));
		scrollPane.setViewportView(table);

		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAdd.setBounds(246, 62, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(345, 62, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(444, 62, 89, 23);
		contentPane.add(btnDelete);
		
		txtName = new JTextField();
		txtName.setBounds(37, 100, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		   MaskFormatter mascara = new MaskFormatter("##");
		JFormattedTextField txtEdad = new JFormattedTextField(mascara);
		
		txtEdad.setBounds(37, 161, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		 MaskFormatter mascara1 = new MaskFormatter("###-###-####");
			JFormattedTextField txtNum = new JFormattedTextField(mascara1);		txtNum.setBounds(37, 217, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Voice In My Head", Font.PLAIN, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(133, 103, 77, 17);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Voice In My Head", Font.PLAIN, 14));
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setBounds(133, 164, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblTel = new JLabel("# Tel");
		lblTel.setFont(new Font("Voice In My Head", Font.PLAIN, 14));
		lblTel.setForeground(Color.WHITE);
		lblTel.setBounds(133, 220, 46, 14);
		contentPane.add(lblTel);
		
		btnAdd.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				String [] fila = new String[3]; 
		        String name = txtName.getText();
		        String edad = txtEdad.getText();
		        String num = txtNum.getText();
				if (name.length()==0|| edad.length()==0||num.length()==0) {
					JOptionPane.showMessageDialog(btnAdd, this, "no hay texto en alguna casilla", getDefaultCloseOperation());
				}
				else {
					 fila[0] = name;
					 fila[1] = edad;
					 fila[2] = num;
					 
					 ((DefaultTableModel) table.getModel()).addRow(fila);
					 
					 txtName.setText("");
					 txtEdad.setText("");
					 txtNum.setText("");
					 txtName.requestFocus();
				}
			
			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int filaSelect = table.getSelectedRow();
				if (filaSelect>=0) {
					txtName.setText(table.getValueAt(filaSelect, 0).toString());
					txtEdad.setText(table.getValueAt(filaSelect, 1).toString());
					txtNum.setText(table.getValueAt(filaSelect, 2).toString());
					
					((DefaultTableModel) table.getModel()).removeRow(filaSelect);
				}
				else {
					JOptionPane.showInputDialog(this,  "fila no seleccionada");
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int filaSelect = table.getSelectedRow();
				((DefaultTableModel) table.getModel()).removeRow(filaSelect);
			}
		});
	}
}
