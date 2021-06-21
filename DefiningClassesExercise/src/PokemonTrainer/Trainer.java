package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private List<Pokemon> pokemons;
    private int numberOfBadges;
    
    Trainer (String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.numberOfBadges = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    
    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }
    
    public boolean hasElement(String element){
        for (Pokemon p : pokemons) {
            if (p.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }
    
    public void addBadge(){
        numberOfBadges++;
    }
    
    public void reducePokemonHealth(){
        for (Pokemon p : pokemons) {
            p.reduceHealth();
            if (p.getHealth() <= 0){
                pokemons.remove(p);
                if (pokemons.size() == 0){
                    break;
                }
            }
        }
    }
}
