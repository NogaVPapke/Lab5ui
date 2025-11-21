package Alecks;

public class MeleeWeapon extends Weapon
{

    int Length;
    public MeleeWeapon()
    {
        super();
        this.setWeaponName("Камень");
        this.setDamage(1);
        this.setAttackSpeed(1);
        this.setStrengthWeapon(10);
        this.Length = 10;
    }
    public MeleeWeapon(String name,  int damage, int AttackSpeed, int Strength)
    {
        super(name, damage, AttackSpeed, Strength);
        Length = 10;
    }
    public MeleeWeapon(MeleeWeapon meleeWeapon)
    {
        super(meleeWeapon);
        this.Length = meleeWeapon.Length;

    }
    public int getLength() {return Length;}
    public MeleeWeapon(String name,  int damage, int AttackSpeed, int Strength,int Lenght)
    {
        super(name, damage, AttackSpeed, Strength);
        this.Length = Lenght;
    }
    @Override
    public int damageDiling(int Distance)
    {
        int DamegeDiling = 0;
        if (Strength > 0)
        {
            Strength--;
            DamegeDiling = Damege * AttackSpeed;
        }
        if (Distance > Length) {
            System.out.println("Манекен слишком далеко, атака невозможна");
            return 0;
        }
        if (Strength == 0)
        {
            System.out.println("Оружие сломано, атаковать манекен более нельзя");
            return 0;
        }
        System.out.println("Общий урон оружия"+" "+DamegeDiling);
        return DamegeDiling;
    }
}
