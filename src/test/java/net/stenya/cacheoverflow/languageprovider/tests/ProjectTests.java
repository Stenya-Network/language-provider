package net.stenya.cacheoverflow.languageprovider.tests;

import com.google.gson.Gson;
import net.stenya.cacheoverflow.languageprovider.ILanguageProvider;
import net.stenya.cacheoverflow.languageprovider.implementation.DefaultLanguageExporter;
import net.stenya.cacheoverflow.languageprovider.implementation.JsonLanguageProvider;
import net.stenya.cacheoverflow.languageprovider.implementation.factories.DefaultLanguageFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectTests {

    @Test
    public void testResourceLoading() {
        ILanguageProvider provider = new JsonLanguageProvider(new DefaultLanguageFactory());
        Assertions.assertEquals("Test", provider.loadByResource("assets\\lang\\de_DE.json", null).findBy("test.test"));
    }

    @Test
    public void testLanguageExporting() {
        ILanguageProvider provider = new JsonLanguageProvider(new DefaultLanguageFactory());
        Gson gson = new Gson();
        Assertions.assertEquals("{\"test.test\":\"Test\"}", gson.toJson(new DefaultLanguageExporter().exportLanguageToJsonObject(provider.loadByResource("assets\\lang\\de_DE.json", null))));
    }

}
