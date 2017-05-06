package hackatheon.beczka.dominocane;

/**
 * Created by Grzegorz on 06.05.2017.
 */

import android.net.Uri;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import hackatheon.beczka.dominocane.db.BiconObject;
import hackatheon.beczka.dominocane.db.XMLParser;

import static org.junit.Assert.*;

public class XMLParserTest {
    @Test
    public void parsingIsCorrect() throws Exception {
        Uri uri = Uri.parse("android.resource://com.segf4ult.test/xml_db/object/objects.xml");
        HashMap<String, BiconObject> map = XMLParser.parse(new FileInputStream(new File(uri.getPath())));
        for (Object biconObject : map.entrySet()){
            System.out.println(biconObject.toString());
        }
    }
}
