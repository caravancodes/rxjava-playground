package di

import org.koin.dsl.module
import source.Repository
import source.RxDataSource


/*
 * Created by faisalamir on 17/04/22
 * rxjava-playground
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 FrogoBox Inc.      
 * All rights reserved
 *
 */

val repositoryModule = module {

    single {
        RxDataSource()
    }

    single {
        Repository(get())
    }

}