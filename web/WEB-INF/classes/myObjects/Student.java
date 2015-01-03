/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myObjects;

import java.util.ArrayList;
import myObjects.Discipline;

/**
 *
 * @author Katya
 */
public class Student {
    int id;
    String firstName;
    String lastName;
    ArrayList<Discipline> disciplineList;

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setFirstName(String Name) {
        this.firstName = Name;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDisciplineList(ArrayList<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public ArrayList<Discipline> getDisciplineList() {
        return disciplineList;
    }
    
    

    @Override
    public String toString(){
        return "ID: "+this.getId()+" Name: "+this.getFirstName()+" SecondName: "+this.getLastName();
    }

    
    
}
