import HEROES.IronMan;
import HEROES.SuperHero;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        SuperHero Spiderman = SuperHeroFactory.getInstance(SuperHeroFactory.SPIDERMAN);
        SuperHero hulk = SuperHeroFactory.getInstance(SuperHeroFactory.HULK);
        SuperHero ironman = SuperHeroFactory.getInstance(SuperHeroFactory.IRONMAN);
        ArrayList<SuperHero> lstHero = new ArrayList<>() ;

        lstHero.add(Spiderman);
        lstHero.add(ironman);
        lstHero.add(hulk);

        Spiderman.attack();
        Spiderman.SuperAttack();
        hulk.defend();
        ironman.SuperAttack();


    }
}