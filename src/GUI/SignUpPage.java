package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import AppShop.Academic;
import AppShop.Customer;
import AppShop.Student;
import AppShop.User;

@SuppressWarnings("serial")
public class SignUpPage extends Page {
	
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JTextField nameTxt;
	private JTextField addressTxt;
	private JTextField professionTxt;
	private JComboBox<String> customerType;
	private final String[] customerTypes = {"a normal customer", "a student", "an academic"};

	/**
	 * Create the panel.
	 */
	public SignUpPage() {
		super();
		addFormFields();
		addSendBtn();
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
		
		JLabel lblIAm = new JLabel("I am:");
		lblIAm.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIAm.setBounds(120, 298, 70, 15);
		add(lblIAm);
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(195, 154, 114, 19);
		add(usernameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(195, 181, 114, 19);
		add(passwordTxt);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(195, 208, 114, 19);
		add(nameTxt);
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		addressTxt.setBounds(195, 237, 114, 19);
		add(addressTxt);
		
		professionTxt = new JTextField();
		professionTxt.setColumns(10);
		professionTxt.setBounds(195, 262, 114, 19);
		add(professionTxt);
		
		customerType = new JComboBox<String>();
		customerType.setModel(new DefaultComboBoxModel<String>(customerTypes));
		customerType.setBounds(195, 293, 197, 24);
		add(customerType);
		
	}
	
	protected void addSendBtn() {
		Button button_1 = new Button("Send");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.SHOP.setCurrentUser(createUser());
				AppWindow.openHomePage();
			}
		});
		button_1.setBounds(195, 345, 167, 29);
		add(button_1);
	}
	
	protected User createUser() {
		User user;
		String selectedCustomerType = customerType.getSelectedItem().toString();
		
		if(selectedCustomerType.equals(customerTypes[1]))
			user = new Student(usernameTxt.getText(), passwordTxt.getText(), nameTxt.getText(), addressTxt.getText(), professionTxt.getText());
		else if(selectedCustomerType.equals(customerTypes[2]))
			user = new Academic(usernameTxt.getText(), passwordTxt.getText(), nameTxt.getText(), addressTxt.getText(), professionTxt.getText());
		else
			user = new Customer(usernameTxt.getText(), passwordTxt.getText(), nameTxt.getText(), addressTxt.getText(), professionTxt.getText());
		
		AppWindow.SHOP.addUser(user);
		return user;
	}
}
