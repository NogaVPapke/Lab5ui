package L5GUI;

import Alecks.*;
import javax.swing.*;
import java.util.ArrayList;

public class WeaponController {

    private final WeaponAppGUI view;
    private final Poligon poligon = new Poligon();
    private Weapon selectedWeapon;

    public WeaponController(WeaponAppGUI view) {
        this.view = view;
    }

    //ДОБАВЛЕНИЕ БЛИЖНЕГО
    public void addMeleeWeapon() {

        JTextField name = new JTextField();
        JTextField dmg = new JTextField();
        JTextField speed = new JTextField();
        JTextField str = new JTextField();
        JTextField len = new JTextField();

        Object[] form = {
                "Название:", name,
                "Урон:", dmg,
                "Скорость атаки:", speed,
                "Прочность:", str,
                "Длина:", len
        };

        if (JOptionPane.showConfirmDialog(null, form,
                "Новое ближнее оружие", JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION) {
            try {
                MeleeWeapon w = new MeleeWeapon(
                        name.getText(),
                        Integer.parseInt(dmg.getText()),
                        Integer.parseInt(speed.getText()),
                        Integer.parseInt(str.getText()),
                        Integer.parseInt(len.getText())
                );

                poligon.addWeapon(w);
                updateTable();
                view.print("Добавлено ближнее оружие: " + w.getWeaponName());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Ошибка: введите корректные числа.");
            }
        }
    }

    //ДОБАВЛЕНИЕ ДАЛЬНЕГО
    public void addRangeWeapon() {

        JTextField name = new JTextField();
        JTextField dmg = new JTextField();
        JTextField speed = new JTextField();
        JTextField str = new JTextField();
        JTextField ammo = new JTextField();
        JTextField acc = new JTextField();

        Object[] form = {
                "Название:", name,
                "Урон:", dmg,
                "Скорость атаки:", speed,
                "Прочность:", str,
                "Патроны:", ammo,
                "Точность:", acc
        };

        if (JOptionPane.showConfirmDialog(null, form,
                "Новое дальнее оружие", JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION) {
            try {
                RangeWeapon w = new RangeWeapon(
                        name.getText(),
                        Integer.parseInt(dmg.getText()),
                        Integer.parseInt(speed.getText()),
                        Integer.parseInt(str.getText()),
                        Integer.parseInt(ammo.getText()),
                        Integer.parseInt(acc.getText())
                );

                poligon.addWeapon(w);
                updateTable();
                view.print("Добавлено дальнее оружие: " + w.getWeaponName());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Ошибка: введите корректные данные.");
            }
        }
    }

    //ВЫБОР ОРУЖИЯ
    public void selectWeapon(int index) {
        selectedWeapon = poligon.getWeapon(index);

        if (selectedWeapon != null) {
            view.print("Выбрано: " + selectedWeapon.getWeaponName());
        }
    }

    // АТАКА
    public void attackDummy() {

        if (selectedWeapon == null) {
            view.print("Сначала выберите оружие!");
            return;
        }

        int distance = 5;  // фиксированное условие
        int defense = 100;

        int dmg = selectedWeapon.damageDiling(distance);

        if (dmg >= defense)
            view.print("Броня пробита! Урон = " + dmg);
        else
            view.print("Броня не пробита. Урон = " + dmg);
    }

    // УДАЛЕНИЕ
    public void removeWeapon() {

        int selected = view.getWeaponTable().getSelectedRow();

        if (selected < 0) {
            view.print("Оружие не выбрано для удаления.");
            return;
        }

        poligon.removeWeaponWithID(selected);
        updateTable();

        view.print("Оружие удалено.");
    }

    private void updateTable() {
        ArrayList<Weapon> weaponsList = new ArrayList<>();
        for (int i = 0; ; i++) {
            Weapon w = poligon.getWeapon(i);
            if (w == null) break;
            weaponsList.add(w);
        }
        view.refreshTable(weaponsList);
    }

    //СОРТИРОВКА
    public void sortWeapons() {

        // Собираем все оружия в локальный список
        ArrayList<Weapon> weaponsList = new ArrayList<>();
        for (int i = 0; ; i++) {
            Weapon w = poligon.getWeapon(i);
            if (w == null) break;
            weaponsList.add(w);
        }


        // Сортируем по типу: MeleeWeapon идут первыми, потом RangeWeapon
        weaponsList.sort((w1, w2) -> {
            if (w1 instanceof MeleeWeapon && w2 instanceof RangeWeapon) return -1;
            else if (w1 instanceof RangeWeapon && w2 instanceof MeleeWeapon) return 1;
            else return 0; // одинаковый тип, порядок не меняется
        });

        // Чистим полигон и добавляем заново в порядке сортировки
        for (int i = 0; i < weaponsList.size(); i++) {
            poligon.removeWeaponWithID(0); // удаляем первый элемент
        }
        for (Weapon w : weaponsList) {
            poligon.addWeapon(w);
        }

        // Обновляем таблицу
        updateTable();
        view.print("Таблица отсортирована по типу оружия.");

    }
}