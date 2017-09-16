package islab.nutriq;


public class Data {

    public static String user = Main3Activity.user;

    //Fragen
    public static String[] frage = {
            "Hallo Macht spätes essen dick?",
            "Hallo " + user + ". Wie oft sollte man sich für eine positive Wirkung auf das Herz-Kreislauf-System körperlich betätigen?",
            "Hallo "+ user +". Welche Krankheit wird im Volksmund auch als Zuckerkrankheit bezeichnet?",
            "Hallo "+ user +". Welches Kraut hilft gegen Einschlafprobleme?",
            "Hi "+ user +". Welche Blutdruckwerte gelten als optimal?",
            "Hi "+ user +". Wie sollte man ein gesundes Ausdauertraining durchführen?",
            "Hey "+ user +". Was ist eine Gastritis?",
            "Hey "+ user +". Unser Körper besteht zu über 70 Prozent aus Wasser. Ab wann wird ein Wassermangel lebensbedrohlich?",
            "Hey "+ user +". Welches dieser Lebensmittel hat am meisten Kalorien?",
            "Hallo "+ user +". Wie lange müssen Sie bei einer Geschwindigkeit von 10 km/h joggen, um eine Tafel Schokolade (530 Kalorien) abzutrainieren?"
    };

    //Nutzerantworten
    public static String[][] answer = {
            {"Ja", "Nein", "Es kommt auf die Mahlzeit an"},
            {"Min. einmal pro Woche für 2h", "Min. zweimal pro Woche für 1h", "Min. dreimal pro Woche für 30min"},
            {"Morbus Menière", "Diabetes", "Fettsucht"},
            {"Pfefferminz", "Rosmarin", "Melisse"},
            {"120/80 mmHg", "160/100 mmHg", "90/60 mmHg"},
            {"So, dass ich mich noch mit jemandem Unterhalten kann.", "So schnell wie möglich.", "So, dass ich innerhalb von 5 Minuten schwitze."},
            {"Bauchspeicheldrüsenentzündung", "Schilddrüsenentzündung", "Magenschleimhautentzündung"},
            {"Ab 2 bis 4 Prozent", "Ab 10 bis 15 Prozent", "Ab 25 bis 30 Prozent"},
            {"100 Gramm eingelegte schwarze Oliven", "100 Gramm Banane", "100 Gramm Putenbrust"},
            {"Circa 20 Minuten", "Circa 50 Minuten", "Circa 90 Minuten"}
    };

    //Systemantworten
    public static String[][] rep = {
            {
                    "Das stimmt so leider nicht. Die Uhrzeit der Nahrungsmittelaufnahme ist nicht entscheidend für die Gewichtszunahme. Es kommt auf die Gesamtzahl der Kalorien an, die am Tag aufgenommen werden.",
                    "Das ist korrekt. Die Uhrzeit der Nahrungsmittelaufnahme ist nicht entscheidend für die Gewichtszunahme. Es kommt auf die Gesamtzahl der Kalorien an, die am Tag aufgenommen werden.",
                    "Prinzipiell ist das korrekt. Wenn die Gesamtzahl der aufgenommenen Kalorien bis spät Abends noch nicht zu groß ist, kann man Abends ruhig essen ohne zuzunehmen."
            },
            {
                    "Das ist leider falsch. Du solltest dich min. dreimal pro Woche für eine halbe Stunde sportlich betätigen. Dadurch kannst du eine positive Wirkung auf das Herz-Kreislauf-System erzielen.",
                    "Das ist leider falsch. Du solltest dich min. dreimal pro Woche für eine halbe Stunde sportlich betätigen. Dadurch kannst du eine positive Wirkung auf das Herz-Kreislauf-System erzielen.",
                    "Das ist richtig. Du solltest dich min. dreimal pro Woche für eine halbe Stunde sportlich betätigen. Dadurch kannst du eine positive Wirkung auf das Herz-Kreislauf-System erzielen."
            },
            {
                    "Leider falsch. Als Morbus Menière wird eine Innenohrerkrankung bezeichnet, die anfallsartig mit Drehschwindel, Hörminderung und Tinnitus einhergeht. Die richtige Antwort lautet Diabetes.",
                    "Das ist richtig. Dieabetes ist eine Stoffwechselerkrankung, die auf Insulinresistenz oder Insulinmangel beruht und durch einen chronisch hohen Blutzuckerspiegel gekennzeichnet wird. Der Begriff wird verwendet, da beim Urinieren auch Zucker ausgeschieden wird.",
                    "Leider falsch. Fettsucht bzw. Adipositas bezeichnet die übermäßige Vermehrung von Fettgewebe im Körper."
            },
            {
                    "Das ist leider falsch. Die richtige Antwort lautet Melisse. Pfefferminz beruhigt den Mangen - trinken Sie einen Pfefferminztee, wenn Sie Magenbeschwerden haben.",
                    "Das ist leider falsch. Die richtige Antwort lautet Melisse. Rosmarin wirkt anregend auf das Zentrale Nervensystem.",
                    "Melisse ist hilfreich beim Einschlafen - machen Sie sich bei Problemen abends einfach einen heißen Melissentee."
            },
            {
                    "Das ist richtig. Ein Blutdruck von 120/80 mmHg gilt als optimal.",
                    "Das ist leider falsch. Ein Blutdruck von 120/80 mmHg gilt als optimal.",
                    "Das ist leider falsch. Ein Blutdruck von 120/80 mmHg gilt als optimal."
            },
            {
                    "Das ist richtig. Man sollte als Hobbysportler noch soviel Puste übrig haben,um sich noch unterhalten zu können.",
                    "Das ist leider falsch. Man sollte als Hobbysportler noch soviel Puste übrig haben,um sich noch unterhalten zu können.",
                    "Das ist leider falsch. Man sollte als Hobbysportler noch soviel Puste übrig haben,um sich noch unterhalten zu können."
            },
            {
                    "Falsche Antwort. Eine Bauchspeicheldrüsenentzündung wird Pankreatitis genannt. Die richtige Antwort ist Gastritis.",
                    "Falsche Antwort. Eine Schilddrüsenentzündung wird Thyreoiditis genannt. Die richtige Antwort ist Gastritis.",
                    "Die Antwort ist richtig. Eine Magenschleimhautentzündung wird in Fachkreisen Gastritis genannt."
            },
            {
                    "Falsch. Es kann jedoch bei einem Flüssigkeitsdefizit von zwei Prozent zu einer Verminderung der Ausdauer und Denkfähigkeit kommen.",
                    "Korrekt. Ein Flüssigkeitsdefizit von 10 bis 15 Prozent kann lebensbedrohlich werden.",
                    "Falsch. Ein Flüssigkeitsdefizit von 10 bis 15 Prozent kann bereits lebensbedrohlich werden."
            },
            {

                    "Richtig. 100 Gramm eingelegte schwarze Oliven haben 294 Kalorien. 100 Gramm Bananen haben 95 Kalorien und 100 Gramm Putenbrust haben 107 Kalorien.",
                    "Falsch. 100 Gramm Bananen haben 95 Kalorien, wohingegen 100 Gramm Putenbrust 107 Kalorien hat. 100 Gramm eingelegte Oliven besitzen 294 Kalorien.",
                    "Falsch. 100 Gramm Putenbrust besitzt 107 Kalorien, wohingegen 100 Gramm Bananen 95 Kalorien haben. 100 Gramm eingelgte Oliven besitzen 294 Kalorien."
            },
            {

                    "Falsch. Um 530 Kalorien zu verbrennen, müssen Sie bei einer Geschwindigkeit von 10 km/h etwa 50 Minuten joggen. Wenn Sie langsamer laufen, verlängert sich die Dauer etwas. Daneben spielt aber auch noch das Gewicht eine Rolle.",
                    "Richtig. Um 530 Kalorien zu verbrennen, müssen Sie bei einer Geschwindigkeit von 10 km/h etwa 50 Minuten joggen. Wenn Sie langsamer laufen, verlängert sich die Dauer etwas. Daneben spielt aber auch noch das Gewicht eine Rolle.",
                    "Falsch. Um 530 Kalorien zu verbrennen, müssen Sie bei einer Geschwindigkeit von 10 km/h etwa 50 Minuten joggen. Wenn Sie langsamer laufen, verlängert sich die Dauer etwas. Daneben spielt aber auch noch das Gewicht eine Rolle."
            }
    };
}
