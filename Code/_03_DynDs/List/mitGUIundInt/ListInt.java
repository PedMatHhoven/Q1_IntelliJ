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

    public void searchLin(int x) {
        //current geht zu x (1. Auftreten) oder wird null
        toFirst();
        while(hasAccess() && current.getContentObject() != x) next();
    }

    public void searchBin(int x) {
        //Zahlen müssen in sortierter Form vorliegen!
        int l=1;
        int r=count();
        //... m=(l+r)/2;
    }

    public void sort() {

    }
}
