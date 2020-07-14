package com.ktp.coffeeshopkotlin.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.ktp.coffeeshopkotlin.*
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
public abstract class AppModule{



    companion object{

        private val mTypeOfCoffee = arrayOf(
            Coffee("Espresso", R.drawable.espresso),
            Coffee("Capuccino", R.drawable.capuccino),
            Coffee("Macchiato", R.drawable.macchiato),
            Coffee("Mocha", R.drawable.mocha),
            Coffee("Latte", R.drawable.latte)
        )

        @Singleton
        @Provides
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions()
                .placeholder(R.drawable.espresso)
        }

        @Singleton
        @Provides
        fun provideGlideInstance(
            application: Application?,
            requestOptions: RequestOptions?
        ): RequestManager {
            return Glide.with(application!!)
                .setDefaultRequestOptions(requestOptions!!)
        }


        @Provides
        fun provideCoffeeArray(): Array<Coffee> {
            return mTypeOfCoffee
        }
    }

       @ContributesAndroidInjector
    abstract fun contributesMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailFragment(): DetailFragment

}