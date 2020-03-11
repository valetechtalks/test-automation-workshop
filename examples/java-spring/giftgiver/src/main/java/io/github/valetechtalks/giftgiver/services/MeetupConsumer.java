package io.github.valetechtalks.giftgiver.services;

import org.json.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MeetupConsumer {
    private static String MEETUP_RSVP_URL = "https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers";

    public JSONArray getRSVPs() {
        return new JSONArray(this.fetchRSVPsFromServer());
    }

    private String fetchRSVPsFromServer() {
        try {
            String jsonString = "";
            URL url = new URL(MeetupConsumer.MEETUP_RSVP_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;

            while ((output = br.readLine()) != null) {
                jsonString = jsonString + output;
            }

            conn.disconnect();

            return jsonString;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return "";
        }
    }
}
