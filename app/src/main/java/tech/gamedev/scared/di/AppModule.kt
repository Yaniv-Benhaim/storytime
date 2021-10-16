package tech.gamedev.scared.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.gamedev.scared.R
import tech.gamedev.scared.data.db.FirebaseDatabase
import tech.gamedev.scared.exoplayer.MusicServiceConnection
import tech.gamedev.scared.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMusicServiceConnection(
        @ApplicationContext context: Context
    ) = MusicServiceConnection(context)

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_headphone)
            .error(R.drawable.ic_headphone)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

    @Singleton
    @Provides
    fun provideFirebaseDatabase() : FirebaseDatabase = FirebaseDatabase()

    @Singleton
    @Provides
    fun provideMainRepo(firebaseDatabase: FirebaseDatabase) : MainRepository = MainRepository(firebaseDatabase)
}