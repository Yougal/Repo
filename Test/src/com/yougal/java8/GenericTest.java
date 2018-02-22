package com.yougal.java8;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	static abstract class Animal {
		public abstract void checkup();
	}

	static class Dog extends Animal {
		public void checkup() { // implement Dog-specific code
			System.out.println("Dog checkup");
		}
	}

	static class Cat extends Animal {
		public void checkup() { // implement Cat-specific code
			System.out.println("Cat checkup");
		}
	}

	static class Bird extends Animal {
		public void checkup() { // implement Bird-specific code
			System.out.println("Bird checkup");
		}

	}

	private static class AnimalDoctorGeneric {
		public void addAnimal(List<? super Eagle> animals) {
			animals.add(new Bird()); 
		}
	}

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Bird());
		animals.add(new Eagle());
		AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
		doc.addAnimal(animals); // THIS is where it breaks!
	}
	
	
	static class Eagle extends Bird {
		public void checkup() { // implement Bird-specific code
			System.out.println("Eagle checkup");
		}

	}

}
