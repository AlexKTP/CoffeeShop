package com.ktp.coffeeshopkotlin

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
public abstract class AppModule{

    companion object{

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
    }

       @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributesViewHolder(): MyViewHolder

}