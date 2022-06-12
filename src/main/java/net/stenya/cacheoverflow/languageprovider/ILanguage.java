package net.stenya.cacheoverflow.languageprovider;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface ILanguage {

    @NotNull String findBy(@NotNull final String code);

    boolean contains(@NotNull final String code);

    @NotNull Set<String> getCodes();

    @NotNull Collection<String> getMessages();

    @NotNull Map<String, String> getTranslations();

    @NotNull String asString();

}
