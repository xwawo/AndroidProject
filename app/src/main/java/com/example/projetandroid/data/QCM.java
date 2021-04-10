package com.example.projetandroid.data;

public class QCM {
    private String topic;

    public String getTopic() {
        return topic;
    }

    public static String getQuestions(int i,int j) {
        return questions[i][j];
    }

    public static String[] getReponses() {
        return reponses;
    }

    private static final String[][] questions = { //tableau à deux dimensions contenant questions et reponses
            {"Dans quelle ville se trouve la Statue de la Liberté ?"},
            {"Washington","Chicago","New York","Los Angeles"},{"Sur quel continent le Nil coule-t-il ?"},
            {"L’Océanie","L’Afrique","L’Europe","L’Amérique"},{"Où siège la Cour de Justice de l’Union européenne ?"},
            {"La Haye","Luxembourg","Maastricht","Amsterdam"},{"Quelle est la capitale de la Norvège ?"},
            {"Oslo","Paris","Copenhaghen","Bucarest"},{"Avec quel pays, la France n'a-t-elle aucune frontière ?"},
            {"Belgique","Autriche","Suisse","Espagne"},{"Quelle est la capitale des Philippines ?"},
            {"Jakarta","Wellington","Séoul","Manille"},{"Dans quel pays est enclavée la République de Saint-Marin ?"},
            {"La Suisse","La France","L'Autriche","L'Italie"},{" Quel canal relie la Méditerranée à la Mer Rouge ?"},
            {"Panama","Suez","Beagle","Bristol"},{"Quelle chaîne de montagnes sépare la France de l'Espagne ?"},
            {"Les Alpes","Les Pyrénées","Les Vosges","Le Jura"},{"Dans quelle ville française  se trouve la place Bellecour, la plus grande place piétonne d’Europe ?"},
            {"Nancy","Lille","Lyon","Saint-Étienne"},{"Quels sont les trois pays de la Triple-Entente ?"},
            {"France - Italie - Royaume-Uni","Allemagne - Italie - Autriche","France - Royaume-Uni - Russie","Allemagne - Autriche - Empire ottoman"},{"Quel célèbre général romain conquiert la Gaule ?"},
            {"Scipion Emilien","Marcus Aemilius Lepidus","Marco Antonio","Giulio Cesare"},{"Comment appelait-on les empereurs de Russie jusqu'en 1917 ?"},
            {"Les tsars","Les émirs","Les sultans","Les pirates"},{"Dans l'Antiquité, quelle cité grecque a vaincu Athènes ?"},
            {"Olympie","Troie","Thèbes","Sparte"},{"Où a été signé l'armistice de la Première Guerre mondiale?"},
            {"Compiègne","Reims","Berlin","Paris"},{"Quel est le bilan humain de la seconde Guerre mondiale ?"},
            {"150 millions de morts","55 à 66 millions de morts","1 milliard de morts","6 millions de morts"},{"Selon la mythologie égyptienne, quelle divinité règne sur le royaume des morts ?"},
            {"Mâat","Anubis","Osiris","Seth"},{"Quand l’URSS a-t-elle disparue (à la suite de la chute du mur de Berlin) ?"},
            {"1971","1991","1987","1981"},{"Quel est le nom actuel du pays dans lequel s'étaient installés les Étrusques au VIIIe siècle avant Jésus-Christ ?"},
            {"L'Allemagne","Le Royaume-Uni","Le Portugal","L'Italie"},{"Que n'a pas créé Napoléon Bonaparte ?"},
            {"La Banque de France","Le Code civil","L'Encyclopédie","La Légion d'honneur"},
    };
    private static final String[] reponses = {"New York", "L’Afrique","Luxembourg", "Oslo", "Autriche","Manille", //tableau contenant la bonne reponse de chaque question
            "L'Italie","Suez","Les Pyrénées","Lyon","France - Royaume-Uni - Russie","Giulio Cesare","Les tsars",
            "Sparte","Compiègne","55 à 66 millions de morts","Osiris","1991","L'Italie","L'Encyclopédie"};

    private QCM[] Quiz;


    public QCM(String s) {
        topic = s;
    } //initialisation avec le sujet du qcm (histoire/geo)

}
