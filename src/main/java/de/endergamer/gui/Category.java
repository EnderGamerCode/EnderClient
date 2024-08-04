package de.endergamer.gui;

import java.util.ArrayList;
import java.util.List;

public class Category {
     List<String> categories = new ArrayList<String>();
    String currentCategory = "main";
    public Category() {
        categories.add(0,"main");
        categories.add(1,"ui");
    }
    public String getCategory(){
        return currentCategory;
    }
    public void setCategory(String arg){
        if(categories.contains(arg)){
            currentCategory = arg;
        }else{
            System.out.println("Category does not exist!");
        }
    }
}
