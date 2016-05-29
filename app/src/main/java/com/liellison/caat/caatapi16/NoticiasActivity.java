package com.liellison.caat.caatapi16;

import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.liellison.caat.caatapi16.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NoticiasActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static class PlaceholderFragment extends ListFragment{
        public PlaceholderFragment(){}
    }
    @Override
    public void onStart(){
        super.onStart();
        new GetAndroidPitRssFeedTask().execute();
    }
    private String getAndroidPitRssFeed() throws IOException{
        InputStream in = null;
        String rssFeed = null;
        try{
            URL url = new URL("http://www.androidpit.com/feed/main.xml");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int count;(count = in.read(buffer))!= -1;){
                out.write(buffer, 0, count);
            }
            byte[] response = out.toByteArray();
            rssFeed = new String(response, "UTF-8");
        } finally {
            if (in != null){
                in.close();
            }
        }
        return rssFeed;
    }

    private class GetAndroidPitRssFeedTask extends AsyncTask<Void, Void, List<String>>{
        //@Override
        protected List<String> doInbackground(Void... voids){
            List<String> result = null;
            try {
                String feed = getAndroidPitRssFeed();
                result = parse(feed);
            } catch (XmlPullParserException | IOException e){
                e.printStackTrace();
            }
            return result;
        }
        private List<String> parse(String rssFeed) throws XmlPullParserException, IOException{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(rssFeed));
            xpp.nextTag();
            return readRss(xpp);
        }
        private List<String> readRss(XmlPullParser parser) throws XmlPullParserException, IOException{
            List<String> items = new ArrayList<>();
            parser.require(XmlPullParser.START_TAG, null, "rss");
            while (parser.next() != XmlPullParser.END_TAG){
                if (parser.getEventType()!= XmlPullParser.START_TAG){
                    continue;
                }
                String name = parser.getName();
                if (name.equals("channel")){
                    items.addAll(readChannel(parser));
                }else {
                    skip(parser);
                }
            } return items;
        }
        private List<String> readChannel(XmlPullParser parser) throws IOException, XmlPullParserException{
        List<String> items = new ArrayList<>();
        parser.require(XmlPullParser.START_TAG, null, "channel");
        while (parser.next() !=XmlPullParser.END_TAG){
            if (parser.getEventType() != XmlPullParser.START_TAG){
                continue;
            }
            String name = parser.getName();
            if (name.equals("item")){
                items.add(readItem(parser));
            }else {
                skip(parser);
            }
        }
        return items;
        }
        private String readItem(XmlPullParser parser) throws XmlPullParserException, IOException{
            String result = null;
            parser.require(XmlPullParser.START_TAG, null, "item");
            while (parser.next() != XmlPullParser.END_TAG){
                if (parser.getEventType() != XmlPullParser.START_TAG){
                    continue;
                }
                String name = parser.getName();
                if (name.equals("title")){
                    result = readTitle(parser);
                } else{
                    skip(parser);
                }
            }
            return result;
        }
        private String readTitle(XmlPullParser parser) throws IOException, XmlPullParserException{
            parser.require(XmlPullParser.START_TAG, null, "title");
            String title = readText(parser);
            parser.require(XmlPullParser.END_TAG, null, "title");
            return title;
        }
        private String readText(XmlPullParser parser) throws IOException, XmlPullParserException{
            String result = "";
            if (parser.next() == XmlPullParser.TEXT){
                result = parser.getText();
                parser.nextTag();
            }
            return result;
        }
        private void skip(XmlPullParser parser) throws XmlPullParserException, IOException{
            if (parser.getEventType() != XmlPullParser.START_TAG){
                throw new IllegalStateException();
            }
            int depth = 1;
            while (depth != 0){
                switch (parser.next()){
                    case XmlPullParser.END_TAG:
                        depth--;
                        break;
                    case XmlPullParser.START_TAG:
                        depth++;
                        break;
                }
            }
        }

        @Override
        protected List<String> doInBackground(Void... params) {
            return null;
        }

        /*@Override
        protected void onPostExecute(List<String> rssFeed){
            if (rssFeed != null){
                setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1, rssFeed));
            }
        } */


    }
}
