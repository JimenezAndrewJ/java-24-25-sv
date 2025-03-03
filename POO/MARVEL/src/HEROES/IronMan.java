package HEROES;

public class IronMan extends SuperHero implements SuperAttack{

    public IronMan(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("iron man ataca");
    }

    @Override
    public void defend() {
        System.out.println("iron man se defiende");
    }

    @Override
    public void SuperAttack() {
        System.out.println("activa superataque iron man");
    }
}
