package com.tiago.vinhos.vinhos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return this.messageSource.getMessage(key, null, this.getLocale());
    }

    private Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
