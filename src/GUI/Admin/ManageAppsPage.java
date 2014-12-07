package GUI.Admin;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import AppShop.App;
import GUI.AppWindow;
import GUI.Page;

@SuppressWarnings("serial")
public class ManageAppsPage extends Page {

	private JList<App> list;
	private JTextField appNameTxt;
	private Label noAppFound;
	
	/**
	 * Create the panel.
	 */
	public ManageAppsPage() {
		super();
		addAppsList();
		addMenuButtons();
		addAppSearchFields();
	}
	
	private void addAppsList() {
		list = new JList<App>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel<App>() {
			ArrayList<App> apps = AppWindow.SHOP.getApps();
			public int getSize() { 
				return apps.size();
			}
			public App getElementAt(int index) {
				return apps.get(index);
			}
		});
		list.setSelectedIndex(0);
		list.setBounds(79, 175, 388, 228);
		if(list.getModel().getSize() != 0)
			add(list);
		else
			displayNoAppsInfo();
	}
	
	private void displayNoAppsInfo() {
		Label label = new Label("There are no apps :(");
		label.setBounds(277, 289, 245, 21);
		add(label);
	}
	
	private void addMenuButtons() { 
		addCreateAppBtn();
		if(list != null && list.getModel().getSize() > 0) {
			addShowAppBtn();
			addEditAppBtn();
			addRemoveCustomerBtn();
		}
	}
	
	private void addCreateAppBtn() {
		JButton btnNew = new JButton("Create");
		btnNew.setBounds(508, 193, 150, 25);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openAddAppPage();
			}
		});
		add(btnNew);
	}
	
	private void addShowAppBtn() {
		JButton btnNewButton = new JButton("Show details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openShowAppPage(getSelectedApp());
			}
		});
		btnNewButton.setBounds(508, 230, 150, 25);
		add(btnNewButton);
	}
	
	private void addEditAppBtn() {
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(508, 267, 150, 25);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openEditAppPage(getSelectedApp());
			}
		});
		add(btnEdit);
	}
	
	private void addRemoveCustomerBtn() {
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(508, 304, 150, 25);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				App app = list.getModel().getElementAt(selectedIndex);
				AppWindow.SHOP.deleteApp(app);
				AppWindow.openManageCustomersPage();
			}
		});
		add(btnRemove);
	}
	
	private App getSelectedApp() {
		int selectedIndex = list.getSelectedIndex();
		return list.getModel().getElementAt(selectedIndex);
	}
	
	private void addAppSearchFields() {
		appNameTxt = new JTextField();
		appNameTxt.setBounds(288, 482, 196, 19);
		appNameTxt.setColumns(10);
		add(appNameTxt);
		
		Label label = new Label("Type app's name:");
		label.setBounds(98, 480, 184, 21);
		add(label);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = appNameTxt.getText();
				App app = (App) AppWindow.SHOP.findAppByName(name);
				if(app != null)
					AppWindow.openShowAppPage(app);
				else
					displayNoAppFoundInfo();
			}
		});
		searchBtn.setBounds(496, 479, 117, 25);
		add(searchBtn);
	}
	
	private void displayNoAppFoundInfo() {
		noAppFound = new Label("There is no app with provided name.");
		noAppFound.setBounds(98, 510, 300, 21);
		add(noAppFound);
	}

}
