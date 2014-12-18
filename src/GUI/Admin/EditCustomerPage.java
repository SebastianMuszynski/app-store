package GUI.Admin;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import AppShop.Customer;
import AppShop.Serialiser;
import GUI.AppWindow;
import GUI.Page;

@SuppressWarnings("serial")
public class EditCustomerPage extends Page {
	
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JTextField nameTxt;
	private JTextField addressTxt;
	private JTextField professionTxt;
	private JComboBox<String> customerType;
	private final String[] customerTypes = {"a normal customer", "a student", "an academic"};
	private Customer customer;

	/**
	 * Create the panel.
	 */
	public EditCustomerPage(Customer customer) {
		super();
		this.customer = customer;
		addFormFields();
		addEditBtn();
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
		
		usernameTxt = new JTextField(customer.getUsername());
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(195, 154, 114, 19);
		add(usernameTxt);
		
		passwordTxt = new JTextField(customer.getPassword());
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(195, 181, 114, 19);
		add(passwordTxt);
		
		nameTxt = new JTextField(customer.getName());
		nameTxt.setColumns(10);
		nameTxt.setBounds(195, 208, 114, 19);
		add(nameTxt);
		
		addressTxt = new JTextField(customer.getAddress());
		addressTxt.setColumns(10);
		addressTxt.setBounds(195, 237, 114, 19);
		add(addressTxt);
		
		professionTxt = new JTextField(customer.getProfession());
		professionTxt.setColumns(10);
		professionTxt.setBounds(195, 262, 114, 19);
		add(professionTxt);
		
		customerType = new JComboBox<String>();
		customerType.setModel(new DefaultComboBoxModel<String>(customerTypes));
		customerType.setBounds(195, 293, 197, 24);
		add(customerType);
	}
	
	private void addEditBtn() {
		Button button = new Button("Send");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setUsername(usernameTxt.getText());
				customer.setPassword(passwordTxt.getText());
				customer.setName(nameTxt.getText());
				customer.setAddress(addressTxt.getText());
				customer.setProfession(professionTxt.getText());
				Serialiser.serialise(customer, "data/customers/" + customer.getUsername() + ".apu");
				AppWindow.openManageCustomersPage();
			}
		});
		button.setBounds(195, 345, 167, 29);
		add(button);
	}

}
