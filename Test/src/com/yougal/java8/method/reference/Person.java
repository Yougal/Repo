package com.yougal.java8.method.reference;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    public Person(String firstName, String lastName, int age, char gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(getFirstName()).append(" ");
        sb.append(getLastName()).append(" ");
        sb.append(getAge()).append(" ");
        sb.append(getGender());
        return sb.toString();
        
    }
    public static int compareByName(Person p1,Person p2){
    	return p1.firstName.compareTo(p2.firstName);
    }

}
