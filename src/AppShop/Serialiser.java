package AppShop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import GUI.AppWindow;

public class Serialiser {
	public static boolean serialise(Object o,String fileLocation){
		try{
			FileOutputStream fileOut = new FileOutputStream(fileLocation);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close(); fileOut.close();
			return true;
		}catch(IOException i){}
		return false;
	}
	
	public static Object deserialise(String fileLocation){
		try{
			Object o = null;
			// load file
			FileInputStream fileIn = new FileInputStream(fileLocation);
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        // save file to o
	        o = in.readObject();
	        in.close();
	        fileIn.close();
	        // send back o
	        return o;
		}catch(IOException i){
			i.printStackTrace();
	    }catch(ClassNotFoundException c){
	    }
	    return null;
	}
	
	public static void loadUsers(){
		File f = new File("data/customers/");
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith("appstore");
		    }
		});
		for(int i = 0; i < matchingFiles.length; i++){
			// loads the object of the current file in the directory.
			Object o = Serialiser.deserialise("data/customers/" + matchingFiles[i].getName());
			if(o instanceof Student){
				AppWindow.SHOP.addUser((Student)o);
			}else if(o instanceof Academic){
				AppWindow.SHOP.addUser((Academic)o);
			}else if(o instanceof Customer){
				AppWindow.SHOP.addUser((Customer)o);
			}
		}
	}
}
