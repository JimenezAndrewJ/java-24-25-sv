package HEROES;

public class Hulk extends SuperHero implements SuperAttack{


    public Hulk(String name) {
        super(name);
    }

    @Override
    public void SuperAttack() {
        System.out.println("activa superataque Hulk");
    }

    @Override
    public void attack() {
        System.out.println("Hulk ataca");
    }

    @Override
    public void defend() {
        System.out.println("Hulk se defiende");
    }
}


