package Alecks;

import java.util.ArrayList;

public class Poligon
{
    private ArrayList<Weapon> Poligon = new ArrayList<>();
    public Poligon()
    {
        this.Poligon = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon)
    {
        if(weapon.getClass() == MeleeWeapon.class)
        {
            Poligon.add((MeleeWeapon)weapon);
        }
        if(weapon.getClass() == RangeWeapon.class)
        {
            Poligon.add((RangeWeapon)weapon);
        }
    }

    public void removeWeapon(Weapon weapon) {
        if(weapon.getClass() == MeleeWeapon.class)
        {
            Poligon.remove((MeleeWeapon)weapon);
        }
        if(weapon.getClass() == RangeWeapon.class)
        {
            Poligon.remove((RangeWeapon)weapon);
        }
        System.out.println("Оружие убрано");
    }

    public Weapon getWeapon(int weaponID)
    {
        try {
            return  Poligon.get(weaponID);
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Оружия под данным номером нет");
        }
        return null;
    }

    public void removeWeaponWithID(int weaponID) {
        try {
            Poligon.remove(Poligon.get(weaponID));
            System.out.println("Оружие убрано из арсенала");
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Оружия под данным номером нет");
        }
    }
    public void writeWeapon(int weaponID)
    {
        try {
            Weapon weapon;
            weapon = Poligon.get(weaponID);
            if(weapon.getClass() == MeleeWeapon.class)
            {
                System.out.println("Название оружия:"+""+weapon.getWeaponName()+ "" +"Урон оружия:"+" "+weapon.getDamage() + " " +"Скорость атаки:"+""+  weapon.getAttackSpeed() + " " +"Прочность оружия:"+""+ weapon.getStrengthWeapon()+ " " +"Длина оружия:"+""+((MeleeWeapon) weapon).getLength());
            }
            if (weapon.getClass() == RangeWeapon.class)
            {
                System.out.println(("Название оружия:"+""+weapon.getWeaponName()+ "" +"Урон оружия:"+" "+ weapon.getDamage() + " " +"Скорость атаки:"+""+ weapon.getAttackSpeed() + " " +"Прочность оружия:"+""+ weapon.getStrengthWeapon() + " " +"Количество потронов:"+""+ ((RangeWeapon) weapon).getAmmunition()));
            }
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println("Оружия под данным номером нет");
        }
    }

}
