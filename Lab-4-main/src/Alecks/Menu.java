package Alecks;

import java.util.Scanner;
public class Menu {
    private static Poligon poligon = new Poligon();
    private static Weapon weapon;
    public static void start()
    {
        mainMenu();
    }
    private static int readChoice()
    {
        Scanner scanner = new Scanner(System.in);
        int readed = -1;
        try
        {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Пожалуста вводите значения пунктов меню");
            readed =readChoice();
        }
        return readed;
    }
    private static void mainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        String weaponType;
        int choice = -1;
        int ID = 0;
        do {
            System.out.println("Главное меню");
            System.out.println("1 - Добавить оружие");
            System.out.println("2 - Войти в полигон");
            System.out.println("0 - Выход");
            choice = readChoice();
            switch (choice)
            {
                case 1:
                    String name;
                    int Damege;
                    int AttackSpeed;
                    int ammunition;
                    int Strength;
                    int Accuracy;
                    int Lenght;
                    System.out.println("Выберите тип оружия, введите 1 для ближнего, 2 для дальнего");
                    try {
                        while(true) {
                            weaponType = scanner.nextLine();
                            if (weaponType.equals("1")) {
                                System.out.println("Введите название оружие");
                                name = scanner.nextLine();
                                System.out.println("Введите урон оружия");
                                Damege = readChoice();
                                System.out.println("Введите скорость атаки");
                                AttackSpeed = readChoice();
                                System.out.println("Введите прочность оружия");
                                Strength = readChoice();
                                System.out.println("Введите длину оружия");
                                Lenght = readChoice();
                                MeleeWeapon meleeWeapon = new MeleeWeapon(name, Damege,AttackSpeed, Strength, Lenght);
                                poligon.addWeapon(meleeWeapon);
                                System.out.println("Оружие добавлено");
                                break;
                            }
                            if (weaponType.equals("2")) {
                                System.out.println("Введите название оружие");
                                name = scanner.nextLine();
                                System.out.println("Введите урон оружия");
                                Damege = readChoice();
                                System.out.println("Введите скорость атаки");
                                AttackSpeed = readChoice();
                                System.out.println("Введите прочность оружия");
                                Strength = readChoice();
                                System.out.println("Введите количество патронов");
                                ammunition = readChoice();
                                System.out.println("Введите точность оружия");
                                Accuracy = readChoice();
                                RangeWeapon rangeWeapon = new RangeWeapon(name, Damege,AttackSpeed, Strength, ammunition, Accuracy);
                                poligon.addWeapon(rangeWeapon);
                                System.out.println("Оружие добавлено");
                                break;
                            }
                            else {
                                System.out.println("Неверный класс оружия, повторите ввод");
                            }
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
                    {
                        System.out.println("Неверное значение кости урона");
                    }
                    break;
                case 2:PoligonMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        }while (choice !=0);
    }

    private static void PoligonMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int ID = 0;
        int choice = -1;
        int Damage;
        do {
            System.out.println("Полигон");
            System.out.println("1 - Выбрать оружие");
            System.out.println("2 - Атакавать манекен");
            System.out.println("3 - Проверить статус орижия");
            System.out.println("4 - Удалить оружие из списка");
            System.out.println("0 - Выйти из палигона");
            choice = readChoice();
            switch (choice)
            {
                case 1:
                    System.out.println("Введите номер оружия");
                    ID = readChoice() -1;
                    weapon = poligon.getWeapon(ID);
                    if(weapon == null) {break;}
                    poligon.writeWeapon(ID);
                    break;
                case 2:
                    int distance = 5;
                    int Deffenc = 100;
                    int DamageDiling;
                    try {
                    Damage = weapon.damageDiling(distance);
                    if (Damage >= Deffenc)
                    {
                        System.out.println("Броня пробита, манекен получил урон");
                    }
                    else
                    {
                        System.out.println("Броня не пробита, манекен не получил урон");
                    }
                }
                catch (NullPointerException nullPointerException)
                {
                    System.out.println("Оружие ещё не выбрано");
                }
                    break;
                case 3:
                    if (ID == -1) {System.out.println("Оружие ещё не выбрано");}
                    else {poligon.writeWeapon(ID);}
                    break;
                case 4:
                    System.out.println("Введите номер оружия");
                    ID = readChoice();
                    poligon.removeWeaponWithID(ID - 1);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        }while (choice !=0);
    }
}
