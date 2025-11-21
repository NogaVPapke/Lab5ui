package Alecks;

public class RangeWeapon extends Weapon {
    int Accuracy;
    int Ammunation;

    public RangeWeapon()
    {
        super();
        this.setWeaponName("Камень");
        this.setDamage(1);
        this.setAttackSpeed(1);
        this.setStrengthWeapon(10);
        this.Ammunation = 20;
        this.Accuracy = 50;
    }
    public RangeWeapon(String name,  int damage, int AttackSpeed, int Strength)
    {
        super(name, damage, AttackSpeed, Strength);
        this.Ammunation = 20;
    }
    public RangeWeapon(String name,  int damage, int AttackSpeed, int Strength, int Ammunation, int Accuracy)
    {
        super(name, damage, AttackSpeed, Strength);
        this.Ammunation = Ammunation;
        this.Accuracy = Accuracy;
    }
    public RangeWeapon(RangeWeapon rangeWeapon)
    {
        super(rangeWeapon);
        this.Ammunation = rangeWeapon.Ammunation;
        this.Accuracy = rangeWeapon.Accuracy;
    }

    public int getAmmunition() {return Ammunation;}
    @Override
    public int damageDiling(int Distance)
    {
        int DamegeDiling = 0;
        if (Ammunation > 0 && Strength > 0)
        {
            Strength--;
            Ammunation--;
            DamegeDiling = Damege * AttackSpeed * Accuracy;
        }
        else if (Ammunation == 0 && Strength == 0)
        {
            System.out.println("Отсутствуют боеприпасы для выстрела, стрельба не возможна");
            System.out.println("Оружие сломано, стрельба не возможна");
        }
        else if (Ammunation == 0) {
            System.out.println("Отсутствуют боеприпасы для выстрела, стрельба не возможна");
            return 0;
        }
        else if (Strength == 0)
        {
            System.out.println("Оружие сломано, стрельба не возможна");
            return 0;
        }
        System.out.println("Общий урон оружия"+" "+DamegeDiling);
        return DamegeDiling;
    }
}
