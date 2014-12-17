package AppShop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
			FileInputStream fileIn = new FileInputStream(fileLocation);
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        o = in.readObject();
	        in.close();
	        fileIn.close();
		}catch(IOException i){
	    }catch(ClassNotFoundException c){
	    }
	    return null;
	}
}
