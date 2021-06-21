package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jarOne = new Jar<>();
        Jar<String> jarTwo = new Jar<>();

        jarOne.add(13);
        jarTwo.add("Pesho");

        System.out.println(jarOne.remove());
        System.out.println(jarOne.remove());
    }
}
