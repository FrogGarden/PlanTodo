package org.example.hongjun.plantodo

import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by loop on 14/12/14.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: Application)

}
