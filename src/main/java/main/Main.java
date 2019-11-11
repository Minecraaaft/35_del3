package main;

        import gui_fields.GUI_Field;
        import gui_fields.GUI_Player;
        import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        GUI_Player p1 = new GUI_Player("max");
        GUI_Player p2 = new GUI_Player("mo");
        gui.addPlayer(p1);
        gui.addPlayer(p2);
        GUI_Field gf[] = gui.getFields();
        System.out.println(gf[0].getTitle());
    }
}
