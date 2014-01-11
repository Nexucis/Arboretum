package com.ricm.arboretum;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void readText(String text) {
        //Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        //DescriptionArbo.speakOut(text);
    	DescriptionArbo.speakOut("premier texte, on fait un essai");
    	DescriptionArbo.speakOut("Puis un second essai");
    	DescriptionArbo.speakOut("Et enfin un troisieme");
    	DescriptionArbo.speakOut("Il ne semble pas y avoir de probleme");
    	DescriptionArbo.speakOut("Cependant mettre plus de texte permettrait");
    	DescriptionArbo.speakOut("De se faire une meilleur idée");
    }
    
}
