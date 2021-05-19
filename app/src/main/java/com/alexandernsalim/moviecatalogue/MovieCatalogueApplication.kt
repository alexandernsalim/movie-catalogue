package com.alexandernsalim.moviecatalogue

import android.app.Application
import com.alexandernsalim.moviecatalogue.di.component.ApplicationComponent
import com.alexandernsalim.moviecatalogue.di.component.DaggerApplicationComponent

class MovieCatalogueApplication : Application() {

    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}