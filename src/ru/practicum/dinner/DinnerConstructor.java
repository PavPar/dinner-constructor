package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();

    public void registerNewDish(String type, String name){
        if(dishesByType.containsKey(type)){
            ArrayList<String> dishes = dishesByType.get(type);
            dishes.add(name);//TODO: validate duplicates
        }else{
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(name);
            dishesByType.put(type,dishes);
        }
    }

    public ArrayList<String> generateDishCombo(ArrayList<String> types){
        Random rnd = new Random();
        ArrayList<String> dishCombo = new ArrayList<>();
        for(String type:types){
            ArrayList<String> dishes = dishesByType.get(type);
            int randomIndex = rnd.nextInt(dishes.size());
            String randomDish =dishes.get(randomIndex);
            dishCombo.add(randomDish);
        }
        return dishCombo;
    }

    public Boolean hasDishType(String type){
        return dishesByType.containsKey(type);
    }

    public Boolean hasDishes(){
        return !dishesByType.isEmpty();
    }
}
