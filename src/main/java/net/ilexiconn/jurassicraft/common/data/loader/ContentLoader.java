package net.ilexiconn.jurassicraft.common.data.loader;

import java.util.ArrayList;
import java.util.List;

public class ContentLoader
{
    private List<IContentHandler> contentHandlers = new ArrayList<IContentHandler>();

    public void addContentHandler(IContentHandler contentHandler)
    {
        contentHandlers.add(contentHandler);
    }

    public void init()
    {
        for (IContentHandler contentHandler : contentHandlers)
        {
            contentHandler.init();
        }
    }
}
