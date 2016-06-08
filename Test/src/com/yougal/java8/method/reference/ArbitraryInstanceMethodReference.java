package com.yougal.java8.method.reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArbitraryInstanceMethodReference {



    public static void main(String[] args) {
        List<Person> personList = createList();
         List allNames = ArbitraryInstanceMethodReference.listAllNames (personList, Person::getFirstName);
         Collections.sort(personList, Person::compareByName);
         System.out.println("" + allNames);
        
    }
    
    //Utitlity method to create list
    private static List<Person> createList(){
        List<Person> tempList = new ArrayList<Person>();
        Person person = new Person("Ram","Tiwari", 50, 'M');
        tempList.add(person);
        person = new Person("Prem", "Chopra", 13, 'M');
        tempList.add(person);
        person =  new Person("Tanuja", "Trivedi", 30, 'F');
        tempList.add(person);
        person = new Person("Manoj", "Sharma", 40, 'M');
        tempList.add(person);
        person = new Person("John", "Trevor", 70, 'M');
        tempList.add(person);
        person =  new Person("Alicia", "Sliver", 17, 'F');
        tempList.add(person);
        System.out.println("List elements are - ");
        System.out.println(tempList);
        return tempList;
    }

    private static List<String> listAllNames(List<Person> person, IMyFunc<Person, String> func){
        List<String> result = new ArrayList<String>();
        person.forEach(x -> result.add(func.stringFunc(x)));
        return result;
    }
	
}
