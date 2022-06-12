package net.stenya.cacheoverflow.languageprovider.implementation;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import net.stenya.cacheoverflow.languageprovider.ILanguage;
import net.stenya.cacheoverflow.languageprovider.ILanguageProvider;
import net.stenya.cacheoverflow.languageprovider.implementation.factories.ILanguageFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JsonLanguageProvider implements ILanguageProvider {

    private final ILanguageFactory factory;

    public JsonLanguageProvider(@NotNull final ILanguageFactory factory) {
        this.factory = factory;
    }

    @Override
    public @NotNull ILanguage loadByStream(@NotNull final String langName, @NotNull InputStream inputStream, @Nullable final Supplier<ILanguage> fallbackLanguageProvider) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            JsonObject object = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            return this.factory.create(langName, object.entrySet().stream()
                    .filter(entry -> entry.getValue() instanceof JsonPrimitive)
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getAsString())));
        } catch (Exception ex) {
            if (fallbackLanguageProvider == null)
                throw new RuntimeException(ex);
            else
                return fallbackLanguageProvider.get();
        }
    }

}
