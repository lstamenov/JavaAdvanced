package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainers = new ArrayList<>();
        String input = br.readLine();
        while (!input.equals("Tournament")){
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (isSuchTrainer(trainerName, trainers) == -1){
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);
                trainers.add(trainer);
            }else {
                trainers.get(isSuchTrainer(trainerName, trainers)).addPokemon(pokemon);
            }
            input = br.readLine();
        }

        input = br.readLine();
        while (!input.equals("End")){
            for (Trainer e : trainers) {
                if (e.hasElement(input)){
                    e.addBadge();
                }else {
                    e.reducePokemonHealth();
                }
            }
            input = br.readLine();
        }
        trainers.stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges)
                        .reversed())
                .forEach(trainer -> System.out.println(trainer.getName() + " " + trainer.getNumberOfBadges()
                + " " + trainer.getPokemons().size()));
    }

    private static int isSuchTrainer(String trainerName, List<Trainer> trainers) {
        for (Trainer t : trainers) {
            if (t.getName().equals(trainerName)){
                return trainers.indexOf(t);
            }
        }
        return -1;
    }
}
