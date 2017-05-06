package hackatheon.beczka.dominocane.db;

import android.util.Pair;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Grzegorz on 06.05.2017.
 */

public class XMLParser {
    private static final String namespace = null;

    private XMLParser(){
        //util class, constructor not needed
    }

    public static HashMap<String, BiconObject> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readResources(parser);
        } finally {
            in.close();
        }
    }

    private static HashMap<String, BiconObject> readResources(XmlPullParser parser) throws XmlPullParserException, IOException {
        HashMap<String, BiconObject> biconObjects = new HashMap();

        parser.require(XmlPullParser.START_TAG, namespace, "resources");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();

            if (name.equalsIgnoreCase("biconObject")) {
                Pair<String, BiconObject> keyAndValue = readBiconObject(parser);
                biconObjects.put(keyAndValue.first, keyAndValue.second);
            } else {
                skip(parser);
            }
        }
        return biconObjects;
    }

    private static Pair<String,BiconObject> readBiconObject(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, namespace, "biconObject");
        String ssid = parser.getAttributeValue(0);
        String name = null;
        String description = null;
        String img = null;
        String audio = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String tagName = parser.getName();
            if (tagName.equalsIgnoreCase("name")) {
                name = readText(parser);
            } else if (tagName.equalsIgnoreCase("description")) {
                description = readText(parser);
            } else if (tagName.equalsIgnoreCase("img")) {
                img = readText(parser);
            } else if (tagName.equalsIgnoreCase("audio")) {
                audio = readText(parser);
            } else {
                skip(parser);
            }
        }
        return new Pair<String,BiconObject>(ssid, new BiconObject(name, description, img, audio));
    }

    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

    private static String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
}
