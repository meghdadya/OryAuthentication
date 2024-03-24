@file:Suppress("PackageNaming", "PackageName", "ImportOrdering")

package com.example.data.di

import com.example.data.utils.DispatcherProvider
import com.example.data.utils.PlatformDispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DispatcherModule {
    @Binds
    fun bindDispatcherProvider(impl: PlatformDispatcherProvider): DispatcherProvider
}
