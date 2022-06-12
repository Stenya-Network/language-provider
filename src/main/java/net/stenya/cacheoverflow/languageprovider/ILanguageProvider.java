package net.stenya.cacheoverflow.languageprovider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Supplier;

public interface ILanguageProvider {

    @NotNull ILanguage loadByStream(@NotNull final String langName, @NotNull final InputStream inputStream, @Nullable final Supplier<ILanguage> fallbackLanguageProvider);

    default @NotNull ILanguage loadByResource(@NotNull final String resource, @Nullable final Supplier<ILanguage> fallbackLanguageProvider) {
        System.out.println("GG");
        String[] resourceSplit = resource.split("\\" + File.separator);
        return this.loadByStream(resourceSplit[resourceSplit.length - 1].split("\\.")[0], Objects.requireNonNull(ILanguageProvider.class
                .getResourceAsStream("/" + resource)), fallbackLanguageProvider);
    }

    default @NotNull ILanguage loadByFile(@NotNull final Path path, @NotNull final Supplier<ILanguage> fallbackLanguageProvider) throws IOException {
        return this.loadByStream(path.getFileName().toString(), Files.newInputStream(path), fallbackLanguageProvider);
    }

}
