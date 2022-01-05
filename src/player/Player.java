package player;

public class Player {
    private String name;
    private int dexterity;
    private int health;
    private int experience;
    private long gold;
    private int strength;

    private int level;

    public Player(String name, int dexterity, int health, int experience, long gold, int strength, int level) {
        this.name = name;
        this.dexterity=dexterity;
        this.health=health;
        this.experience=experience;
        this.gold=gold;
    }

    int attack() {
        return health-strength;
    }
}
