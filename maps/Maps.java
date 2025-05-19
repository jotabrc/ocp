import java.util.Collections;
import java.util.Map;
import java.util.OptionalInt;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps(){
        Map<String, Integer> channelToSubscribers    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)
        // V2 -> V1
        channelToSubscribers.forEach((k,v) -> {
            String publisher = channelToPublisher.get(k);
            if (publisherToSubscribers.containsKey(publisher)) {
                publisherToSubscribers.merge(publisher, channelToSubscribers.get(k), Integer::sum);
            } else {
                publisherToSubscribers.put(publisher, v);
            }
        });


        // 2. Output "publisherToSubscribers"
        publisherToSubscribers.forEach((k,v) -> System.out.printf("Publisher:%s, Subscribers=%d%n", k, v));


        // 3. Who has the most/least subscribers?
        OptionalInt max = publisherToSubscribers.values().stream().mapToInt(Integer::intValue).max();
        System.out.printf("Max subscribers:%s%n", max.orElse(0));

        OptionalInt least = publisherToSubscribers.values().stream().mapToInt(Integer::intValue).min();
        System.out.printf("Least subscribers:%s%n", least.orElse(0));

    }
}
