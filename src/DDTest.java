import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.*;

public class DDTest extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTextField txtPassword;
	private JTextField txtName;
	
	static Hashtable titleToFileName = new Hashtable();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DDTest frame = new DDTest();
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
	public DDTest() {

		titleToFileName.put("A","a");
		titleToFileName.put("B","b");
		titleToFileName.put("C","c");
		
		String a[] =(String[])  Collections.list(titleToFileName.keys()).toArray();

		

	
		getContentPane().setLayout(null);

		txtPassword = new JTextField();
		txtPassword.setBounds(66, 29, 86, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(66, 75, 86, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//System.out.println();
				label.setText((String)titleToFileName.get(String.valueOf(comboBox.getSelectedItem())));
			}
		});

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"A", "B", "C" }));
		comboBox.setBounds(73, 62, 266, 20);
		contentPane.add(comboBox);

		label = new JLabel("");
		label.setBounds(224, 151, 46, 14);
		contentPane.add(label);

		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title = textField.getText();
				comboBox.addItem(textField.getText());
				String fileName = "1";
				titleToFileName.put(title, "1" );
			}
		});

		btnAdd.setBounds(73, 169, 89, 23);
		contentPane.add(btnAdd);
		
		textField = new JTextField();
		textField.setBounds(73, 136, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemove = new JButton("remove");
		btnRemove.setBounds(234, 169, 89, 23);
		contentPane.add(btnRemove);

	}
}
