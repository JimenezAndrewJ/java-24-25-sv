import HEROES.Hulk;
import HEROES.IronMan;
import HEROES.SpiderMan;
import HEROES.SuperHero;

public class SuperHeroFactory<I extends SuperHero> {
    public static final String SPIDERMAN = "Spiderman";
    public static final String IRONMAN = "IRONMAN";
    public static final String HULK = "HULK";

    public static SuperHero getInstance(String heroe) {
        switch (heroe) {
            case SPIDERMAN:
                return new SpiderMan("Spiderman");
            case IRONMAN:
                return new IronMan("IRONMAN");
            case HULK:
                return new Hulk("HULK");
        }
        return null;
    }
}

