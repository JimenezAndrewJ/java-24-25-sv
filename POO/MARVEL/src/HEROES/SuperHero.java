package HEROES;

public abstract class SuperHero {
    protected String name;

    public SuperHero(String name) {
        this.name = name;
    }

    public abstract void SuperAttack();

    // Métodos abstractos que deben implementar los héroes
    public abstract void attack();
    public abstract void defend();
}
