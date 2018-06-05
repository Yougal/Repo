package com.yougal.serialization.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.yougal.serialization.obj.SerializedChildNonSerializedParent;
import com.yougal.serialization.obj.SerializedChildSerializedParent;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		System.out.println("Test case -1");
		SerializedChildNonSerializedParent child = new SerializedChildNonSerializedParent();
		child.setAge(12);
		child.setName("Yougal Bisht");
		child.setSchoolId(13);
		child.setSchoolName("School Name");
		System.out.println(child);
		System.out.println("serializing....");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		objectOutputStream.writeObject(child);
		System.out.println("de serializing....");
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);
		SerializedChildNonSerializedParent readObject = (SerializedChildNonSerializedParent)objectInputStream.readObject();
		System.out.println(readObject);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Test case -2");
		SerializedChildSerializedParent child1 = new SerializedChildSerializedParent();
		child1.setAge(12);
		child1.setName("Yougal Bisht");
		child1.setSchoolId(13);
		child1.setSchoolName("School Name");
		System.out.println(child1);
		System.out.println("serializing....");
		ByteArrayOutputStream out1 = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(out1);
		objectOutputStream1.writeObject(child1);
		System.out.println("de serializing....");
		ByteArrayInputStream arrayInputStream1 = new ByteArrayInputStream(out1.toByteArray());
		ObjectInputStream objectInputStream1 = new ObjectInputStream(arrayInputStream1);
		SerializedChildSerializedParent readObject1 = (SerializedChildSerializedParent)objectInputStream1.readObject();
		System.out.println(readObject1);
	}
	
	
}
