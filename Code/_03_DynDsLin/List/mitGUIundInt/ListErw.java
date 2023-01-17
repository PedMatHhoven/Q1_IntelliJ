package _03_DynDsLin.List.mitGUIundInt;

public class ListErw <ContentType> extends List <ContentType> {
    public int count() {
        int i=0;
        if (!isEmpty()) {
            ListNode help = current; //zwischenspeichern
            toFirst();
            while (hasAccess()) {
                next();
                i++;
            }
            current = help; //zurücksetzen
        }
        return i;
    }

    public void dreheUm() {
        if (first != last) {
            ListNode help1 = last;
            while (help1 != first) {
                ListNode help2 = help1;
                help1 = getPrevious(help1); //help1 vor help2
                help2.setNextNode(help1);
            }
            help1.setNextNode(null);
            first = last;
            last = help1;
        }
    }

    public void tauscheRechts() {
        if (hasAccess() && !(current == last)) {
            ListNode help = current.getNextNode(); //current vor help
            current.setNextNode(help.getNextNode());
            help.setNextNode(current); //current hinter help, help aber ohne Vorgänger!
            if (current == first) {
                first = help; //help wird verbunden (current bleibt dahinter)
            }
            else {
                current = getPrevious(current); //current geht zum alten Vorgänger
                current.setNextNode(help); //help wird verbunden (current vor help)
                current = help.getNextNode(); //current wieder hinter help
            }
            if (help == last) last = last.getNextNode();
        }
    }
}