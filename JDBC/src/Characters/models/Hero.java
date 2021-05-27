package Characters.models;

public class Hero {

    private int id;
    private  String name;
    private int type;
    private String image;
    private int life;
    private int attack;
    private String weaspell;
    private String shield;

    public Hero() {
    }

    @Override
    public String toString() {
        return "hero{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", type = " + type +
                ", image = '" + image + '\'' +
                ", life = " + life +
                ", attack = " + attack +
                ", weaspell = '" + weaspell + '\'' +
                ", shield = '" + shield + '\'' +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getWeaspell() {
        return weaspell;
    }

    public void setWeaspell(String weaspell) {
        this.weaspell = weaspell;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
