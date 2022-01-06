package player;

public class Player {
    private String name;
    private int dexterity;
    private int health;
    private int experience;
    private long gold;
    private int strength;

    private int level = 1;

    public Player(String name, int dexterity, int health, int experience, long gold, int strength, int level) {
        this.name = name;
        this.dexterity=dexterity;
        this.health=health;
        this.experience=experience;
        this.gold=gold;
        this.strength=strength;
        this.level=level;
    }

    int attack() {
        return health-strength;
    }

    public String getName() {
        if (name.length()>25) return "Имя слишком длинное!";
        else return this.name;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getHealth() {
        return this.health;
    }

    public int getExperience() {
        return this.experience;
    }

    public long getGold() {
        return this.gold;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getLevel() {
        return this.level;
    }
}
