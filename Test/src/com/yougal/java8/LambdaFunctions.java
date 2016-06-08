package com.yougal.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaFunctions {
	
	
	public static void main(String[] args) {
		MyIntf inf = (Person p1,Person p2)-> {
									if(p1.birthday.compareTo(p2.birthday)>0){
										return p1;
									}else{
										return p2;
									}
								};
								
								new ArrayList<String>().sort(new Comparator<String>() {

									@Override
									public int compare(String o1, String o2) {
										// TODO Auto-generated method stub
										return 0;
									}
								});
								
	//	Arrays.sort(new Person[5], );
		
		Function<Person, Integer> x = Person::compareByAge;
		Supplier<Person> supplier = Person::new;
		Person person = supplier.get();
		Function<Person, Integer> f = person::compareTo;
		//p.get();
		System.out.println(x);
	}
	
	
	
	public List<Person> filterAdultMalePerson(List<Person> personList, Predicate<Person> function){
		return personList.stream().filter(function).collect(Collectors.toList());
	}
	
}

interface MyIntf{
	
	public Person checkOld (Person p1, Person p2);
	
}

class Person implements Comparable<Person> {

    enum Sex {
        MALE, FEMALE
    }

    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    
    public int compareByAge() {
        return 0;//a.birthday.compareTo(b.birthday);
    }
    
    public int get() {
    	return 0;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
