package net.stenya.cacheoverflow.languageprovider;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.util.Properties;

public interface ILanguageExporter {

    @NotNull JsonObject exportLanguageToJsonObject(@NotNull final ILanguage language);

    @NotNull Properties exportLanguageToProperties(@NotNull final ILanguage language);

}
