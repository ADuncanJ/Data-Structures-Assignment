import java.util.*;

public class PMList {
    public static class Entry {
        public final int days;
        public final String name;

        private Entry (int days, String name) {
            this.days = days;
            this.name = name;
        }
    }

    public static List<Entry> getPrimeMinisters () {
        ArrayList<Entry> list = new ArrayList<>();

        list.add(new Entry(365*20 + 314, "Sir Robert Walpole"));
        list.add(new Entry(365* 1 + 119, "The Earl of Wilmington"));
        list.add(new Entry(365*10 + 191, "Henry Pelham"));
        list.add(new Entry(365* 7 + 205, "The Duke of Newcastle"));
        list.add(new Entry(365* 0 + 225, "The Duke of Devonshire"));
        list.add(new Entry(365* 0 + 317, "The Earl of Bute"));
        list.add(new Entry(365* 2 +  85, "George Grenville"));
        list.add(new Entry(365* 1 + 113, "The Marquess of Rockingham"));
        list.add(new Entry(365* 2 +  76, "The Earl of Chatham"));
        list.add(new Entry(365* 1 + 106, "The Duke of Grafton"));
        list.add(new Entry(365*12 +  58, "Lord North"));
        list.add(new Entry(365* 0 + 266, "The Earl of Shelburne"));
        list.add(new Entry(365*18 + 343, "William Pitt the Younger"));
        list.add(new Entry(365* 3 +  82, "The Duke of Portland"));
        list.add(new Entry(365* 3 +  54, "Henry Addington"));
        list.add(new Entry(365* 1 +  42, "The Lord Grenville"));
        list.add(new Entry(365* 2 + 221, "Spencer Perceval"));
        list.add(new Entry(365*14 + 305, "The Earl of Liverpool"));
        list.add(new Entry(365* 0 + 144, "The Viscount Goderich"));
        list.add(new Entry(365* 0 + 119, "George Canning"));
        list.add(new Entry(365* 2 + 320, "The Duke of Wellington"));
        list.add(new Entry(365* 3 + 229, "The Earl Grey"));
        list.add(new Entry(365* 6 + 255, "The Viscount Melbourne"));
        list.add(new Entry(365* 5 +  57, "Sir Robert Peel"));
        list.add(new Entry(365* 6 + 110, "Lord John Russell"));
        list.add(new Entry(365* 3 + 280, "The Earl of Derby"));
        list.add(new Entry(365* 2 +  42, "The Earl of Aberdeen"));
        list.add(new Entry(365* 9 + 141, "The Viscount Palmerston"));
        list.add(new Entry(365*12 + 126, "William Ewart Gladstone"));
        list.add(new Entry(365* 6 + 339, "Benjamin Disraeli"));
        list.add(new Entry(365*13 + 252, "The Marquess of Salisbury"));
        list.add(new Entry(365* 1 + 109, "The Earl of Rosebery"));
        list.add(new Entry(365* 3 + 145, "Arthur Balfour"));
        list.add(new Entry(365* 2 + 122, "Sir Henry Campbell-Bannerman"));
        list.add(new Entry(365* 8 + 244, "H. H. Asquith"));
        list.add(new Entry(365* 5 + 317, "David Lloyd George"));
        list.add(new Entry(365* 0 + 211, "Bonar Law"));
        list.add(new Entry(365* 7 +  82, "Stanley Baldwin"));
        list.add(new Entry(365* 6 + 289, "Ramsay MacDonald"));
        list.add(new Entry(365* 2 + 348, "Neville Chamberlain"));
        list.add(new Entry(365* 8 + 239, "Sir Winston Churchill"));
        list.add(new Entry(365* 6 +  92, "Clement Attlee"));
        list.add(new Entry(365* 1 + 279, "Sir Anthony Eden"));
        list.add(new Entry(365* 6 + 281, "Harold Macmillan"));
        list.add(new Entry(365* 0 + 363, "Sir Alec Douglas-Home"));
        list.add(new Entry(365* 7 + 279, "Harold Wilson"));
        list.add(new Entry(365* 3 + 259, "Edward Heath"));
        list.add(new Entry(365* 3 +  29, "James Callaghan"));
        list.add(new Entry(365*11 + 208, "Margaret Thatcher"));
        list.add(new Entry(365* 6 + 155, "John Major"));
        list.add(new Entry(365*10 +  56, "Tony Blair"));
        list.add(new Entry(365* 2 + 318, "Gordon Brown"));
        list.add(new Entry(365* 6 +  63, "David Cameron"));
        list.add(new Entry(365* 3 +  11, "Theresa May"));
        list.add(new Entry(365* 3 +  44, "Boris Johnson"));
        list.add(new Entry(365* 0 +  49, "Liz Truss"));
        list.add(new Entry(365* 0 +   1, "Rishi Sunak"));

        return list;
    }

    public static final int[] INCOMPLETE = {
            365* 1 + 119,
            365*10 + 191,
            365* 1 + 113,
            365* 2 +  76,
            365*18 + 343,
            365* 3 +  82,
            365* 2 + 221,
            365*14 + 305,
            365* 0 + 119,
            365* 3 + 280,
            365* 9 + 141,
            365*13 + 252,
            365* 2 + 122,
            365* 0 + 211,
            365* 6 + 289,
            365* 8 + 239,
            365* 1 + 279,
            365* 0 +   1
    };
}
