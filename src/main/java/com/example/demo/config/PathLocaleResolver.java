package com.example.demo.config;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;

/**
 * LocaleResolver that derives the locale from the first path segment:
 * /en/... -> Locale.ENGLISH
 * /vi/... -> new Locale("vi")
 * anything else -> default (EN).
 */
public class PathLocaleResolver implements LocaleResolver {

    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final Locale VIETNAMESE = new Locale("vi");

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if (uri == null) {
            return DEFAULT_LOCALE;
        }
        if (uri.startsWith("/vi/") || uri.equals("/vi")) {
            return VIETNAMESE;
        }
        if (uri.startsWith("/en/") || uri.equals("/en")) {
            return DEFAULT_LOCALE;
        }
        return DEFAULT_LOCALE;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // no-op: locale is fully derived from the path
    }
}


