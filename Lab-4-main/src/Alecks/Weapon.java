package Alecks;

public abstract class Weapon {
    public String name;
    public int Damege;
    public int AttackSpeed;
    public int Strength;
    public int DamegeDiling;

    public Weapon() {

    }
    public Weapon(String name,  int damage, int AttackSpeed, int Strength)
    {
        this.name = name;
        this.Damege = damage;
        this.AttackSpeed = AttackSpeed;
        this.Strength = Strength;
    }

    public Weapon(Weapon weapon)
    {
        this.name = weapon.name;
        this.Damege = weapon.Damege;
        this.AttackSpeed = weapon.AttackSpeed;
        this.Strength = weapon.Strength;
    }
    public String getWeaponName() {return name;}
    public int getDamage() {return Damege;}
    public int getAttackSpeed() {return AttackSpeed;}
    public int getStrengthWeapon(){return Strength;}

    public void setWeaponName(String name) {this.name = name;}
    public void setDamage(int Damege) {this.Damege = Damege;}
    public void setAttackSpeed(int AttackSpeed) {this.AttackSpeed = AttackSpeed;}
    public void setStrengthWeapon(int Strength){this.Strength = Strength;}

    public int damageDiling(int Distance)
    {
        return DamegeDiling;
    }

}
