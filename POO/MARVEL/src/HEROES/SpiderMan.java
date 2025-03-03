package HEROES;

public class SpiderMan extends SuperHero implements SuperAttack{
    public SpiderMan(String name) {
        super(name);
    }

    @Override
    public void SuperAttack() {
        System.out.println("activa superataque SpiderMan");
    }

    @Override
    public void attack() {
        System.out.println("SpiderMan ataca");
    }

    @Override
    public void defend() {
        System.out.println("SpiderMan se defiende");
    }
}
