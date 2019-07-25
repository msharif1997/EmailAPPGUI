import java.awt.EventQueue;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;

public class EmailInput extends JFrame {
	private JTextField textFname;
	private JTextField textLname;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailInput frame = new EmailInput();
					 // Creating the JFrame
					frame.setTitle("Email Administrator");
			        frame.setSize(900,400);
			        frame.setLocationRelativeTo(null);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmailInput() {
		getContentPane().setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][grow]"));
		
		JLabel lblTittle = new JLabel("Email Administrator Generator");
		getContentPane().add(lblTittle, "cell 4 0,alignx left");
		
		JLabel lblFname = new JLabel("First Name");
		lblFname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblFname, "cell 0 1,alignx trailing");
		
		textFname = new JTextField();
		textFname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(textFname, "cell 1 1,alignx left");
		textFname.setColumns(10);
		
		JLabel lblLName = new JLabel("Last Name");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblLName, "cell 3 1,alignx trailing");
		
		textLname = new JTextField();
		textLname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(textLname, "cell 4 1,alignx left");
		textLname.setColumns(10);
		
		JLabel lblDep = new JLabel("Departments");
		lblDep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblDep, "cell 0 3,alignx trailing");
		
		JComboBox<String> comboDept = new JComboBox<String>();
		comboDept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboDept.addItem("Sales");
		comboDept.addItem("Development");
		comboDept.addItem("Accounting");
		comboDept.addItem("None");
		comboDept.setSelectedItem("None");
		getContentPane().add(comboDept, "cell 1 3,alignx left");
		
		JComboBox<String> comboMail = new JComboBox<String>();
		comboMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboMail.addItem("500mgb");
		comboMail.addItem("1Gig"); 
		comboMail.addItem("5Gig");
		comboMail.addItem("10Gig");
		
		JLabel lblmailBox = new JLabel("MailBox");
		lblmailBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblmailBox, "cell 3 3,alignx trailing");
		comboMail.setSelectedItem("500mgb");
		getContentPane().add(comboMail, "cell 4 3,alignx left");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(btnAdd, "cell 0 5");
		
		//ScrollPanel
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 6 5 1,grow");  
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Object[] row = new Object[5];
		
		String columnName [] = {"First Name", "Last Name", "Deportment", "MailBox", "Email"};
		
		DefaultTableModel model = new  DefaultTableModel();
		model.setColumnIdentifiers(columnName);
		table.setModel(model);
		
		
		// This button Add's columns to the table
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// Creating the Company email
				String companyName = "@techmail.com";
				
				row[0] = textFname.getText();
				row[1] = textLname.getText();
				
				String fname = textFname.getText();
				String lname = textLname.getText();
				
				String Email = fname + "." + lname + companyName;
				
				row[2] = comboDept.getItemAt(comboDept.getSelectedIndex());
				row[3] = comboMail.getItemAt(comboMail.getSelectedIndex());
				row[4] = Email;
				
				model.addRow(row);
				
			}
			
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(btnDelete, "cell 1 5");
		
		// This button Delete columns of the table
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int i = table.getSelectedRow();
				
				if(i >= 0) {
					model.removeRow(i);
				} else {
					System.out.println("Detele Error");
				}
				
			}
			
		});
		

		
		
	}
}
