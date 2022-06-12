package net.stenya.cacheoverflow.languageprovider.implementation.factories;

import net.stenya.cacheoverflow.languageprovider.ILanguage;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DefaultLanguageFactory implements ILanguageFactory {

    @Override
    public @NotNull ILanguage create(@NotNull String name, @NotNull Map<String, String> messages) {
        return new ILanguage() {
            @Override
            public @NotNull String findBy(@NotNull String code) {
                return messages.get(code);
            }

            @Override
            public boolean contains(@NotNull String code) {
                return messages.containsKey(code);
            }

            @Override
            public @NotNull Set<String> getCodes() {
                return messages.keySet();
            }

            @Override
            public @NotNull Collection<String> getMessages() {
                return messages.values();
            }

            @Override
            public @NotNull Map<String, String> getTranslations() {
                return messages;
            }

            @Override
            public @NotNull String asString() {
                return name;
            }
        };
    }


}
