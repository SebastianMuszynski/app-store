package GUI.Customer;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import AppShop.App;
import AppShop.Category;
import GUI.AppWindow;
import GUI.Page;

@SuppressWarnings("serial")
public class ListAppsPage extends Page {
	
	private JList<App> list;
	private JComboBox<Category> appCategory;
	private Label noAppsTxt;

	/**
	 * Create the panel.
	 */
	public ListAppsPage() {
		super();
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setBounds(79, 193, 137, 15);
		add(categoryLabel);
		
		appCategory = new JComboBox<Category>();
		appCategory.setModel(new DefaultComboBoxModel<Category>(Category.values()));
		appCategory.setBounds(173, 188, 170, 24);
		add(appCategory);
		
		appCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshListContentAndHideIfEmpty();
			}
		});
		
		JButton btnBack = new JButton("Go back to the home page");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openHomePage();
			}
		});
		btnBack.setBounds(290, 525, 220, 25);
		add(btnBack);
		
		addAppsList();
	}
	
	private void addAppsList() {
		addNoAppsInfoTxt();
		list = new JList<App>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(79, 224, 388, 228);
		add(list);
		refreshListContentAndHideIfEmpty();
	}
	
	private void refreshListContentAndHideIfEmpty() {
		list.setModel(new AbstractListModel<App>() {
			ArrayList<App> apps = AppWindow.SHOP.getAppsByCategoryName(getSelectedCategoryName());
			public int getSize() { 
				return apps.size();
			}
			public App getElementAt(int index) {
				return apps.get(index);
			}
		});
		
		if(list.getModel().getSize() == 0) {
			list.setVisible(false);
			setNoAppsInfoVisibility(true);
		} else {
			list.setSelectedIndex(0);
			list.setVisible(true);
			setNoAppsInfoVisibility(false);
		}
	}
	
	private void addNoAppsInfoTxt() {
		noAppsTxt = new Label("There are no apps in selected category.");
		noAppsTxt.setBounds(79, 224, 315, 21);
		add(noAppsTxt);
	}
	
	private void setNoAppsInfoVisibility(boolean isVisible) {
		noAppsTxt.setVisible(isVisible);
	}
	
	private String getSelectedCategoryName() {
		return appCategory.getSelectedItem().toString();
	}
}
