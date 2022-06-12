package net.stenya.cacheoverflow.languageprovider.implementation.factories;

import net.stenya.cacheoverflow.languageprovider.ILanguage;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface ILanguageFactory {

    @NotNull ILanguage create(@NotNull final String name, @NotNull final Map<String, String> messages);

}
