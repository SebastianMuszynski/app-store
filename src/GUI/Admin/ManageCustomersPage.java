package GUI.Admin;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import AppShop.Customer;
import GUI.AppWindow;
import GUI.Page;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ManageCustomersPage extends Page {

	/**
	 * Create the panel.
	 */
	public ManageCustomersPage() {
		super();
		addCustomersList();
		addCustomerMenuBtns();
	}
	
	private void addCustomersList() {
		JList<Customer> list = new JList<Customer>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel<Customer>() {
			ArrayList<Customer> customers = AppWindow.SHOP.getCustomers();
			public int getSize() { 
				return customers.size();
			}
			public Customer getElementAt(int index) {
				return customers.get(index);
			}
		});
		list.setSelectedIndex(0);
		list.setBounds(79, 175, 388, 228);
		add(list);
	}
	
	private void addCustomerMenuBtns() {
		JButton btnNewButton = new JButton("Show details");
		btnNewButton.setBounds(508, 230, 150, 25);
		add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(508, 267, 150, 25);
		add(btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(508, 304, 150, 25);
		add(btnRemove);
	}
}
