import di.repositoryModule
import org.koin.core.context.GlobalContext.startKoin

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

fun main(args: Array<String>) {

    startKoin {
        // use Koin logger
        printLogger()
        // declare modules
        modules(repositoryModule)
    }

    Application().start()

}