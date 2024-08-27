package kg.geeks.game.players;
import java.util.Random;

public class Gambler extends Hero{

    public Gambler(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GAMBLING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        int indexOfLooser = random.nextInt(heroes.length);
        if (dice1 == dice2){
            boss.setHealth(boss.getHealth() - (dice1 * dice2));
            System.out.println("Gambler " + this.getName() + " gets a Jackpot and does damage: " + (dice1 * dice2));
        } else {
            heroes[indexOfLooser].setHealth(heroes[indexOfLooser].getHealth() - (dice1 + dice2));
            System.out.println("Gambler " + this.getName() + " looses and " + heroes[indexOfLooser].getName() + " gets damage: " + (dice1 + dice2));
        }
    }
}
