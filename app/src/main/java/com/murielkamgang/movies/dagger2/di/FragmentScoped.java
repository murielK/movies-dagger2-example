/*
 * Copyright 2018 AG04 INNOVATIVE SOLUTIONS d.o.o. All rights reserved.
 */

package com.murielkamgang.movies.dagger2.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by muriel on 25/05/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScoped {
}
