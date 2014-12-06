package GUI;

import java.awt.Button;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignUpPage extends Page {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public SignUpPage() {
		super();
		addAdminLoginBtn();
		addFormFields();
		addSendBtn();
	}

	private void addAdminLoginBtn() {
		Button button = new Button("Log in as an admin");
		button.setBounds(623, 10, 167, 40);
		add(button);
	}
	
	private void addFormFields() {
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(65, 156, 112, 15);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(65, 183, 112, 15);
		add(lblPassword);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(65, 210, 112, 15);
		add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(65, 237, 112, 15);
		add(lblAddress);
		
		JLabel lblProfession = new JLabel("Profession:");
		lblProfession.setBounds(65, 264, 112, 15);
		add(lblProfession);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(195, 154, 114, 19);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 181, 114, 19);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(195, 208, 114, 19);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(195, 237, 114, 19);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(195, 262, 114, 19);
		add(textField_4);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"a normal customer", "a student", "an academic"}));
		comboBox.setBounds(195, 293, 197, 24);
		add(comboBox);
		
		JLabel lblIAm = new JLabel("I am:");
		lblIAm.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIAm.setBounds(120, 298, 70, 15);
		add(lblIAm);
	}
	
	private void addSendBtn() {
		Button button_1 = new Button("Send");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openHomePage();
			}
		});
		button_1.setBounds(195, 345, 167, 29);
		add(button_1);
	}
}
