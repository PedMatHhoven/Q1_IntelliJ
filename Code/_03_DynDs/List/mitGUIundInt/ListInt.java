package _03_DynDs.List.mitGUIundInt;

public class ListInt extends ListErw <Integer> {
    public void toMax() {
        if (!isEmpty()) {
            ListNode help = first;
            toFirst(); next();
            while (hasAccess()) {
                if (getContent() > help.getContentObject()) {
                    help = current;
                }
                next();
            }
            current = help;
        }
    }

    public double average() {
        double erg = 0;
        if (!isEmpty()) {
            ListNode help = current; //zwischenspeichern
            toFirst();
            while (hasAccess()) {
                erg = erg + getContent();
                next();
            }
            erg = erg/count();
            current = help; //zurücksetzen
        }
        return erg;
    }
}
