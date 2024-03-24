package com.example.data.di

import com.example.data.data_source.local.config.ConfigLocalDataSource
import com.example.data.data_source.local.config.ConfigLocalDataSourceImpl
import com.example.data.data_source.remote.login.LoginRemoteDataSource
import com.example.data.data_source.remote.login.LoginRemoteDataSourceImpl
import com.example.data.data_source.remote.register.RegisterRemoteDataSource
import com.example.data.data_source.remote.register.RegisterRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindConfigLocalDataSource(
        userLocalDataSource: ConfigLocalDataSourceImpl,
    ): ConfigLocalDataSource

    @Binds
    fun bindRegisterRemoteDataSource(
        registerRemoteDataSourceImpl: RegisterRemoteDataSourceImpl
    ): RegisterRemoteDataSource

    @Binds
    fun bindLoginRemoteDataSource(
        loginRemoteDataSourceImpl: LoginRemoteDataSourceImpl
    ): LoginRemoteDataSource

}