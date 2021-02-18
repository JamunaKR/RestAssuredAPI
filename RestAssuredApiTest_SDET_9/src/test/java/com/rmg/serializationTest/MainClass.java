package com.rmg.serializationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass {

	public static void main(String[] args) throws Throwable {
//		NSFGame user1 = new NSFGame("Nithesh", 10, 89, 50);
//		FileOutputStream fis=new FileOutputStream("./nsf.ser");
//		ObjectOutputStream obj=new ObjectOutputStream(fis);
//		obj.writeObject(user1);
//		System.out.println("done");
		
		FileInputStream fis=new FileInputStream("./nsf.ser");
		ObjectInputStream obj=new ObjectInputStream(fis);
		 NSFGame data=(NSFGame)obj.readObject();
		 System.out.println(data.level);
		 System.out.println(data.fuel);
	}
}
