package com.liellison.caat.caatapi16.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by liellison on 17/01/17.
 */

public class rss {
    @SerializedName("channel")
    @Expose
    private Channel channel;
    @SerializedName("version")
    @Expose
    private String version;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+", version = "+version+"]";
    }
    ////////////////////////////////////////
    public class Channel
    {
        @SerializedName("pubDate")
        @Expose
        private String pubDate;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("docs")
        @Expose
        private String docs;
        @SerializedName("lastBuildDate")
        @Expose
        private String lastBuildDate;
        @SerializedName("item")
        @Expose
        private String[] item;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("generator")
        @Expose
        private String generator;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("ttl")
        @Expose
        private String ttl;

        public String getPubDate ()
        {
            return pubDate;
        }

        public void setPubDate (String pubDate)
        {
            this.pubDate = pubDate;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getDocs ()
        {
            return docs;
        }

        public void setDocs (String docs)
        {
            this.docs = docs;
        }

        public String getLastBuildDate ()
        {
            return lastBuildDate;
        }

        public void setLastBuildDate (String lastBuildDate)
        {
            this.lastBuildDate = lastBuildDate;
        }

        public String[] getItem ()
        {
            return item;
        }

        public void setItem (String[] item)
        {
            this.item = item;
        }

        public String getLink ()
        {
            return link;
        }

        public void setLink (String link)
        {
            this.link = link;
        }

        public String getGenerator ()
        {
            return generator;
        }

        public void setGenerator (String generator)
        {
            this.generator = generator;
        }

        public String getImage ()
        {
            return image;
        }

        public void setImage (String image)
        {
            this.image = image;
        }

        public String getLanguage ()
        {
            return language;
        }

        public void setLanguage (String language)
        {
            this.language = language;
        }

        public String getCopyright ()
        {
            return copyright;
        }

        public void setCopyright (String copyright)
        {
            this.copyright = copyright;
        }

        public String getTtl ()
        {
            return ttl;
        }

        public void setTtl (String ttl)
        {
            this.ttl = ttl;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [pubDate = "+pubDate+", title = "+title+", description = "+description+", docs = "+docs+", lastBuildDate = "+lastBuildDate+", item = "+item+", link = "+link+", generator = "+generator+", image = "+image+", language = "+language+", copyright = "+copyright+", ttl = "+ttl+"]";
        }
    }
}

