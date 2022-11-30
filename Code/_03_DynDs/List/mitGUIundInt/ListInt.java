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
        int zaehler=1; //zählt die Anzahl an Durchläufen
        while(hasAccess() && getContent() != x) {
            next();
            zaehler ++;
        }
        System.out.println(zaehler);
    }

    public void searchBin(int x) {
        //Zahlen müssen in sortierter Form vorliegen!
        int l=1;
        int r=count();
        int zaehler=0; //zählt die Anzahl an Durchläufen
        while (l<=r) {
            int m = (l+r)/2; zaehler ++;
            toFirst(); for (int i=1; i<m; i++) next(); //current geht zu "m"
            if (getContent() < x) l=m+1;
            else if (getContent() > x) r=m-1;
            else l=r+2;
        }
        if (l==r+1) current = null;
        System.out.println(zaehler);
    }

    public void sort() {
        //BubbleSort
        ListNode help = current; //zwischenspeichern
        int zaehler=0; //zählt die Anzahl an Vergleichen
        for (int i=1; i<count(); i++) {
            toFirst();
            for (int j=0; j<count()-i; j++) {
                int nachbar = current.getNextNode().getContentObject();
                if (getContent() > nachbar) tauscheRechts(); else next();
                zaehler ++;
            }
        }
        current = help; //zurücksetzen
        System.out.println(zaehler);
    }
}
