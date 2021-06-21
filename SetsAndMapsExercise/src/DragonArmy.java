import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Dragon>> typesOfDragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("\\s+");

            String type = data[0];
            String name = data[1];

            if (!input.contains("null")){
                int damage = Integer.parseInt(data[2]);
                int health = Integer.parseInt(data[3]);
                int armor = Integer.parseInt(data[4]);

                Dragon dragon = new Dragon(type, name, damage, health, armor);
                if (isEqual(dragon, typesOfDragons)){
                    for (Map.Entry<String, List<Dragon>> e : typesOfDragons.entrySet()) {
                        for (int j = 0; j < e.getValue().size(); j++) {
                            if (e.getValue().get(j).getType().equals(dragon.getType())){
                                if (e.getValue().get(j).getName().equals(dragon.getName())){
                                    e.getValue().get(j).setDamage(dragon.getDamage());
                                    e.getValue().get(j).setHealth(dragon.getHealth());
                                    e.getValue().get(j).setArmor(dragon.getArmor());
                                }
                            }
                        }
                    }
                }else {
                    if (typesOfDragons.get(type) != null){
                        List<Dragon> dragons = typesOfDragons.get(type);
                        dragons.add(dragon);
                        typesOfDragons.put(type, dragons);
                    }else {
                        List<Dragon> dragons = new ArrayList<>();
                        dragons.add(dragon);
                        typesOfDragons.put(type, dragons);
                    }
                }
            }else {
                String damage = data[2];
                String health = data[3];
                String armor = data[4];

                Dragon dragon = new Dragon(type, name);

                if (!damage.equals("null")){
                    dragon.setDamage(Integer.parseInt(damage));
                }
                if (!health.equals("null")){
                    dragon.setHealth(Integer.parseInt(health));
                }
                if (!armor.equals("null")){
                    dragon.setArmor(Integer.parseInt(armor));
                }

                if (typesOfDragons.get(dragon.getType()) != null){
                    List<Dragon> dragons = typesOfDragons.get(type);
                    dragons.add(dragon);
                    typesOfDragons.put(type, dragons);
                }else {
                    List<Dragon> dragons = new ArrayList<>();
                    dragons.add(dragon);
                    typesOfDragons.put(type, dragons);
                }
            }
        }
        typesOfDragons.entrySet()
                .forEach(stringDragonEntry -> {
                    double avgDamage = getAverageDamage(stringDragonEntry);
                    double avgHealth = getAverageHealth(stringDragonEntry);
                    double avgArmor = getAverageArmor(stringDragonEntry);

                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n",stringDragonEntry.getKey(),
                            avgDamage, avgHealth, avgArmor);

                    List<Dragon> drakes = stringDragonEntry.getValue();
                    drakes.stream()
                            .sorted(Comparator.comparing(Dragon::getName))
                            .forEach(e -> System.out.println(e.toString()));
                });
    }

    private static double getAverageArmor(Map.Entry<String, List<Dragon>> stringDragonEntry) {
        int sum = 0;
        int count = 0;
        for (Dragon dragon : stringDragonEntry.getValue()) {
            sum += dragon.getArmor();
            count++;
        }
        return 1.0 * sum / count;
    }

    private static double getAverageHealth(Map.Entry<String, List<Dragon>> stringDragonEntry) {
        int sum = 0;
        int count = 0;
        for (Dragon dragon : stringDragonEntry.getValue()) {
            sum += dragon.getHealth();
            count++;
        }
        return 1.0 * sum / count;
    }

    private static double getAverageDamage(Map.Entry<String,List<Dragon>> stringDragonEntry) {
        int sum = 0;
        int count = 0;
        for (Dragon dragon : stringDragonEntry.getValue()) {
            sum += dragon.getDamage();
            count++;
        }
        return 1.0 * sum / count;
    }

    private static boolean isEqual(Dragon dragon, Map<String, List<Dragon>> typesOfDragons) {
        for (Map.Entry<String, List<Dragon>> e : typesOfDragons.entrySet()) {
            for (int i = 0; i < e.getValue().size(); i++) {
                if (e.getValue().get(i).getType().equals(dragon.getType())){
                    if (e.getValue().get(i).getName().equals(dragon.getName())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static public class Dragon {
        String type;
        String name;
        int damage = 45;
        int health = 250;
        int armor = 10;

        Dragon(String type, String name){
            this.type = type;
            this.name = name;
        }

        Dragon(String type, String name, int damage, int health, int armor){
            this.type = type;
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getArmor() {
            return armor;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }


        @Override
        public String toString() {
            return String.format("-%s -> damage: %d, health: %d, armor: %d",getName(), getDamage(), getHealth(), getArmor());
        }
    }
}
