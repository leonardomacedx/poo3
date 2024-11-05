package com.ceub.poo3.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanCopyUtils {

    private BeanCopyUtils() {
        throw new IllegalStateException("Classe utilitária");
    }

    public static void copyNonNullProperties(Object source, Object destination, String... ignoreProperties){
        Set<String> ignorePropertiesSet = getNullPropertyNames(source);
        Collections.addAll(ignorePropertiesSet, ignoreProperties);
        BeanUtils.copyProperties(source, destination, ignorePropertiesSet.toArray(new String[0]));
    }

    private static Set<String> getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Stream.of(src.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> src.getPropertyValue(propertyName) == null)
                .collect(Collectors.toSet());
    }
}
