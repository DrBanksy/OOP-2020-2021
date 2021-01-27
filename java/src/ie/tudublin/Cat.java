package ie.tudublin;

import java.util.jar.Attributes.Name;

public class Cat extends Animal
{
    private int numLives;

    public Cat(String name, Integer lives)
    {
        super(name);
        this.numLives = lives;
    }

    public Integer getNumLives() {
        return numLives;
    }

    public void setName(Integer n) {
        this.numLives = n;
    }
    
    public void kill() {
        System.out.println("Ouch");
        this.numLives -= 1;
    }


  
}