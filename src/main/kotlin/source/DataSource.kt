package source


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

interface DataSource {

    fun doMultipleRxJava(callback: SourceCallback.DataResponse<String>)

}