package net.stenya.cacheoverflow.languageprovider.implementation;

import net.stenya.cacheoverflow.languageprovider.ILanguage;
import net.stenya.cacheoverflow.languageprovider.ILanguageProvider;
import net.stenya.cacheoverflow.languageprovider.implementation.factories.ILanguageFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PropertiesLanguageProvider implements ILanguageProvider {

    private final ILanguageFactory factory;

    public PropertiesLanguageProvider(@NotNull final ILanguageFactory factory) {
        this.factory = factory;
    }

    @Override
    public @NotNull ILanguage loadByStream(@NotNull final String langName, @NotNull InputStream inputStream, @Nullable final Supplier<ILanguage> fallbackLanguageProvider) {
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            return this.factory.create(langName, properties.entrySet().stream().collect(Collectors
                    .toMap(entry -> String.valueOf(entry.getKey()), entry -> String.valueOf(entry.getValue()))));
        } catch (IOException ex) {
            if (fallbackLanguageProvider == null)
                throw new RuntimeException(ex);
            else
                return fallbackLanguageProvider.get();
        }
    }

}
