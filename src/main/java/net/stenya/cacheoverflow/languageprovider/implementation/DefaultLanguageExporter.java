package net.stenya.cacheoverflow.languageprovider.implementation;

import com.google.gson.JsonObject;
import net.stenya.cacheoverflow.languageprovider.ILanguage;
import net.stenya.cacheoverflow.languageprovider.ILanguageExporter;
import org.jetbrains.annotations.NotNull;

import java.util.Properties;

public class DefaultLanguageExporter implements ILanguageExporter {

    @Override
    public @NotNull JsonObject exportLanguageToJsonObject(@NotNull ILanguage language) {
        JsonObject object = new JsonObject();
        language.getTranslations().forEach(object::addProperty);
        return object;
    }

    @Override
    public @NotNull Properties exportLanguageToProperties(@NotNull ILanguage language) {
        Properties properties = new Properties();
        properties.putAll(language.getTranslations());
        return properties;
    }

}
