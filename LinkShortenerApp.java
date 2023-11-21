import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class LinkShortener {

    public static String shortenURL(String longUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(longUrl.getBytes());
            return Base64.getUrlEncoder().withoutPadding().encodeToString(digest).substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class LinkShortenerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a long URL:");
        String longUrl = scanner.nextLine();

        String shortUrl = LinkShortener.shortenURL(longUrl);

        System.out.println("Shortened URL: " + shortUrl);

        scanner.close();
    }
}

class LinkStorage {

    private static Map<String, String> shortToLongMap = new HashMap<>();

    public static void storeLink(String shortUrl, String longUrl) {
        shortToLongMap.put(shortUrl, longUrl);
    }

    public static String getLongUrl(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }
}
