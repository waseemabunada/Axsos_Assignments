import java.util.HashMap;
import java.util.Map;

public class TrackListDemo {
    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("دقات", "حبيبي كان ملاك، لما لمس إيدي");
        trackList.put("تملي معاك", "تملي معاك، ولو حتى بعيد عني");
        trackList.put("أما براوة", "أما براوة يا حبيبي براوة");
        trackList.put("يا مسهرني", "يا مسهرني، ومشغول بالي عليك");

        String trackTitle = "تملي معاك";
        String lyrics = trackList.get(trackTitle);
        System.out.println("كلمات الأغنية \"" + trackTitle + "\":\n" + lyrics);
        System.out.println();

        System.out.println("جميع الأغاني:");
        for (String title : trackList.keySet()) {
            String songLyrics = trackList.get(title);
            System.out.println(title + ": " + songLyrics);
        }
    }
}