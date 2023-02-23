package uz.lazydevv.kattabozortask.presenter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.lazydevv.kattabozortask.data.remote.ApiService
import uz.lazydevv.kattabozortask.data.repositories.ProductRepoImpl
import uz.lazydevv.kattabozortask.domain.repositories.ProductRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepo(
        apiService: ApiService
    ): ProductRepo {
        return ProductRepoImpl(apiService)
    }

}