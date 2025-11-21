package L5GUI;

import Alecks.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WeaponAppGUI extends JFrame {

    private WeaponController controller;

    private DefaultTableModel tableModel;
    private JTable weaponTable;
    private JTextArea outputArea;

    public WeaponAppGUI() {
        super("ЛР5 — Полигон оружия (модернизированный)");

        controller = new WeaponController(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout(10,10));

        //Верхняя панель
        JPanel topPanel = new JPanel();

        JButton addMeleeBtn = new JButton("Добавить ближнее");
        JButton addRangeBtn = new JButton("Добавить дальнее");
        JButton attackBtn = new JButton("Атаковать");
        JButton removeBtn = new JButton("Удалить");
        JButton sortBtn = new JButton("Сортировать по типу");

        topPanel.add(addMeleeBtn);
        topPanel.add(addRangeBtn);
        topPanel.add(attackBtn);
        topPanel.add(removeBtn);
        topPanel.add(sortBtn);

        //Таблица оружия

        tableModel = new DefaultTableModel(new Object[]{"Тип", "Название", "Урон", "Скорость", "Прочность"}, 0);
        weaponTable = new JTable(tableModel);
        weaponTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane tableScroll = new JScrollPane(weaponTable);
        tableScroll.setPreferredSize(new Dimension(350, 300));

        //Поле вывода
        outputArea = new JTextArea(4, 20); // уменьшено
        outputArea.setEditable(false);

        JScrollPane outputScroll = new JScrollPane(outputArea);

        add(topPanel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.WEST);
        add(outputScroll, BorderLayout.CENTER);

        //Слушатели
        addMeleeBtn.addActionListener(e -> controller.addMeleeWeapon());
        addRangeBtn.addActionListener(e -> controller.addRangeWeapon());
        removeBtn.addActionListener(e -> controller.removeWeapon());
        attackBtn.addActionListener(e -> controller.attackDummy());
        sortBtn.addActionListener(e -> controller.sortWeapons());

        weaponTable.getSelectionModel().addListSelectionListener(e -> {
            int row = weaponTable.getSelectedRow();
            if (row >= 0) controller.selectWeapon(row);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Методы, вызываемые контроллером

    public void print(String text) {
        outputArea.append(text + "\n");
    }

    public void refreshTable(java.util.List<Weapon> weapons) {
        tableModel.setRowCount(0); // очистка

        for (Weapon w : weapons) {
            String type = (w instanceof MeleeWeapon) ? "Melee" : "Range";
            tableModel.addRow(new Object[]{
                    type,
                    w.getWeaponName(),
                    w.getDamage(),
                    w.getAttackSpeed(),
                    w.getStrengthWeapon()
            });
        }
    }
    public JTable getWeaponTable() {
        return weaponTable;
    }
}

